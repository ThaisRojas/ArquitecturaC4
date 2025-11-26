// frontend/src/components/ResultadoLicencia.jsx

export default function ResultadoLicencia({ data }) {
  if (!data) return null;

  return (
    <section style={{ marginBottom: "1.5rem" }}>
      <h3>Resultado licencia ANT (con caché)</h3>
      <p><strong>Cédula:</strong> {data.cedula}</p>
      <p><strong>Fecha última actualización en caché:</strong> {data.fechaActualizacion}</p>

      <p style={{ marginTop: "0.5rem" }}>
        A continuación se muestra el HTML devuelto por la ANT (solo como texto):
      </p>

      <textarea
        readOnly
        value={data.htmlRespuesta}
        rows={10}
        style={{ width: "100%", marginTop: "0.5rem", fontFamily: "monospace", fontSize: "0.8rem" }}
      />
    </section>
  );
}