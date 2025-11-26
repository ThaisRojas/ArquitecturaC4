// frontend/src/components/ResultadoContribuyente.jsx

export default function ResultadoContribuyente({ data }) {
  if (!data) return null;

  // La API del SRI devuelve un arreglo, tomamos el primer elemento
  const contribuyente = Array.isArray(data) ? data[0] : data;

  return (
    <section style={{ marginBottom: "1.5rem" }}>
      <h3>Resultado contribuyente SRI</h3>
      <div>
        <p><strong>RUC:</strong> {contribuyente.numeroRuc}</p>
        <p><strong>Razón social:</strong> {contribuyente.razonSocial}</p>
        <p><strong>Estado:</strong> {contribuyente.estadoContribuyenteRuc}</p>
        <p><strong>Tipo contribuyente:</strong> {contribuyente.tipoContribuyente}</p>
        <p><strong>Actividad principal:</strong> {contribuyente.actividadEconomicaPrincipal}</p>
      </div>
    </section>
  );
}