package ec.edu.arquitecturac4.backend.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ANTClient {

    private static final String URL_ANT =
            "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp"
            + "?ps_tipo_identificacion=CED&ps_identificacion=%s&ps_placa=";

    private final RestTemplate restTemplate;

    public ANTClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String consultarLicenciaHtml(String cedula) {
        String url = String.format(URL_ANT, cedula);
        return restTemplate.getForObject(url, String.class);
    }
}