package ec.edu.arquitecturac4.backend.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class SRIClienteRuc {

    private static final String URL_EXISTE =
            "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/existePorNumeroRuc?numeroRuc=";

    private static final String URL_OBTENER =
            "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerPorNumerosRuc?&ruc=";

    private final RestTemplate restTemplate;

    public SRIClienteRuc(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existeContribuyente(String ruc) {
        try {
            String respuesta = restTemplate.getForObject(URL_EXISTE + ruc, String.class);
            return respuesta != null && respuesta.toLowerCase().contains("true");
        } catch (RestClientException ex) {
            // Si hay error al verificar, consideramos que no existe
            return false;
        }
    }

    // Devolvemos la respuesta de la API tal cual como String (JSON crudo)
    public String obtenerContribuyenteJson(String ruc) {
        return restTemplate.getForObject(URL_OBTENER + ruc, String.class);
    }
}