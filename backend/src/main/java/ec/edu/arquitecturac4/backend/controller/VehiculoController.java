package ec.edu.arquitecturac4.backend.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.arquitecturac4.backend.service.VehiculoService;

@RestController
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/api/sri/vehiculo")
    public Map<String, Object> obtenerVehiculo(@RequestParam String placa) {
        return vehiculoService.consultarVehiculo(placa);
    }
}