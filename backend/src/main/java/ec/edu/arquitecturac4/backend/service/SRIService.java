package ec.edu.arquitecturac4.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ec.edu.arquitecturac4.backend.client.SRIClienteRuc;

@Service
public class SRIService {

    private final SRIClienteRuc sriClienteRuc;

    public SRIService(SRIClienteRuc sriClienteRuc) {
        this.sriClienteRuc = sriClienteRuc;
    }

    public String consultarContribuyente(String ruc) {
        boolean existe = sriClienteRuc.existeContribuyente(ruc);
        if (!existe) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El RUC ingresado no corresponde a un contribuyente válido");
        }

        // Devolvemos el JSON que responde el SRI tal cual
        return sriClienteRuc.obtenerContribuyenteJson(ruc);
    }
}