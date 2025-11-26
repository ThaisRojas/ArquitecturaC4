// frontend/src/components/ResultadoVehiculo.jsx

export default function ResultadoVehiculo({ data }) {
  if (!data) return null;

  return (
    <section style={{ marginBottom: "1.5rem" }}>
      <h3>Resultado vehículo SRI</h3>
      <div>
        <p><strong>Placa:</strong> {data.numeroPlaca}</p>
        <p><strong>Marca:</strong> {data.descripcionMarca}</p>
        <p><strong>Modelo:</strong> {data.descripcionModelo}</p>
        <p><strong>Año:</strong> {data.anioAuto}</p>
        <p><strong>Estado exoneración:</strong> {data.estadoExoneracion}</p>
      </div>
    </section>
  );
}