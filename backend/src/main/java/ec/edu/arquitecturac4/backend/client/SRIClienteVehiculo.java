package ec.edu.arquitecturac4.backend.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SRIClienteVehiculo {

    private static final String URL_VEHICULO =
            "https://srienlinea.sri.gob.ec/sri-matriculacion-vehicular-recaudacion-servicio-internet/rest/BaseVehiculo/obtenerPorNumeroPlacaOPorNumeroCampvOPorNumeroCpn?numeroPlacaCampvCpn=";

    private final RestTemplate restTemplate;

    public SRIClienteVehiculo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> obtenerPorPlaca(String placa) {
        return restTemplate.getForObject(URL_VEHICULO + placa, Map.class);
    }
}