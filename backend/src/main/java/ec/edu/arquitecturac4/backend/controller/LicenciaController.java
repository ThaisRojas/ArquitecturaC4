package ec.edu.arquitecturac4.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.arquitecturac4.backend.model.LicenciaInfo;
import ec.edu.arquitecturac4.backend.service.LicenciaService;

@RestController
public class LicenciaController {

    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }

    @GetMapping("/api/ant/licencia")
    public LicenciaInfo obtenerLicencia(@RequestParam String cedula) {
        return licenciaService.consultarLicencia(cedula);
    }
}