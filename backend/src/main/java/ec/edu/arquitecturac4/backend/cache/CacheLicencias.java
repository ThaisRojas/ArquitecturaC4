package ec.edu.arquitecturac4.backend.cache;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import ec.edu.arquitecturac4.backend.model.LicenciaInfo;

@Component
public class CacheLicencias {

    // cedula -> info licencia
    private final ConcurrentHashMap<String, LicenciaInfo> cache = new ConcurrentHashMap<>();

    // Tiempo de vida de la licencia en caché (ej: 24 horas)
    private static final Duration TTL = Duration.ofHours(24);

    public Optional<LicenciaInfo> obtenerSiVigente(String cedula) {
        LicenciaInfo info = cache.get(cedula);
        if (info == null) {
            return Optional.empty();
        }
        Instant ahora = Instant.now();
        if (ahora.isAfter(info.getFechaActualizacion().plus(TTL))) {
            // Expiró
            cache.remove(cedula);
            return Optional.empty();
        }
        return Optional.of(info);
    }

    public void guardar(LicenciaInfo info) {
        cache.put(info.getCedula(), info);
    }
}