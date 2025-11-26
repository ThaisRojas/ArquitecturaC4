package ec.edu.arquitecturac4.backend.service;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import ec.edu.arquitecturac4.backend.cache.CacheLicencias;
import ec.edu.arquitecturac4.backend.client.ANTClient;
import ec.edu.arquitecturac4.backend.model.LicenciaInfo;

@Service
public class LicenciaService {

    private final ANTClient antClient;
    private final CacheLicencias cacheLicencias;

    public LicenciaService(ANTClient antClient, CacheLicencias cacheLicencias) {
        this.antClient = antClient;
        this.cacheLicencias = cacheLicencias;
    }

    public LicenciaInfo consultarLicencia(String cedula) {

        // 1) Primero revisamos la caché
        var enCache = cacheLicencias.obtenerSiVigente(cedula);
        if (enCache.isPresent()) {
            return enCache.get();
        }

        // 2) Si no hay datos vigentes en caché, llamamos a la ANT
        try {
            String html = antClient.consultarLicenciaHtml(cedula);
            LicenciaInfo info = new LicenciaInfo(cedula, html, Instant.now());
            cacheLicencias.guardar(info);
            return info;
        } catch (RestClientException ex) {

            // 3) Si la ANT está caída, intentamos devolver lo último en caché
            if (enCache.isPresent()) {
                return enCache.get();
            }

            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "La web de la ANT no está disponible actualmente");
        }
    }
}