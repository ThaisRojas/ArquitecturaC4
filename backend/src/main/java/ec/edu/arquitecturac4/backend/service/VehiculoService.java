package ec.edu.arquitecturac4.backend.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import ec.edu.arquitecturac4.backend.client.SRIClienteVehiculo;

@Service
public class VehiculoService {

    private final SRIClienteVehiculo sriClienteVehiculo;

    public VehiculoService(SRIClienteVehiculo sriClienteVehiculo) {
        this.sriClienteVehiculo = sriClienteVehiculo;
    }

    public Map<String, Object> consultarVehiculo(String placa) {
        return sriClienteVehiculo.obtenerPorPlaca(placa);
    }
}