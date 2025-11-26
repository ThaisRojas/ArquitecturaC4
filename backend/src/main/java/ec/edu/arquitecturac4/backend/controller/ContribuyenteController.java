package ec.edu.arquitecturac4.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.arquitecturac4.backend.service.SRIService;

@RestController
public class ContribuyenteController {

    private final SRIService sriService;

    public ContribuyenteController(SRIService sriService) {
        this.sriService = sriService;
    }

    // GET /api/sri/contribuyente?ruc=1234567890001
    @GetMapping("/api/sri/contribuyente")
    public String obtenerContribuyente(@RequestParam String ruc) {
        return sriService.consultarContribuyente(ruc);
    }
}