// frontend/src/components/ConsultaForm.jsx
import { useState } from "react";

export default function ConsultaForm({ onConsultar, loading }) {
  const [email, setEmail] = useState("");
  const [ruc, setRuc] = useState("");
  const [placa, setPlaca] = useState("");
  const [cedula, setCedula] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    onConsultar({ email, ruc, placa, cedula });
  };

  return (
    <form onSubmit={handleSubmit} style={{ maxWidth: 600, marginBottom: "2rem" }}>
      <h2>Consulta de contribuyente, vehículo y licencia</h2>

      <div style={{ marginTop: "1rem" }}>
        <label>
          Correo electrónico:
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            style={{ display: "block", width: "100%", padding: "0.4rem", marginTop: "0.25rem" }}
          />
        </label>
      </div>

      <div style={{ marginTop: "1rem" }}>
        <label>
          RUC:
          <input
            type="text"
            value={ruc}
            onChange={(e) => setRuc(e.target.value)}
            required
            style={{ display: "block", width: "100%", padding: "0.4rem", marginTop: "0.25rem" }}
          />
        </label>
      </div>

      <div style={{ marginTop: "1rem" }}>
        <label>
          Matrícula del vehículo:
          <input
            type="text"
            value={placa}
            onChange={(e) => setPlaca(e.target.value)}
            required
            style={{ display: "block", width: "100%", padding: "0.4rem", marginTop: "0.25rem" }}
          />
        </label>
      </div>

      <div style={{ marginTop: "1rem" }}>
        <label>
          Cédula para puntos de licencia:
          <input
            type="text"
            value={cedula}
            onChange={(e) => setCedula(e.target.value)}
            required
            style={{ display: "block", width: "100%", padding: "0.4rem", marginTop: "0.25rem" }}
          />
        </label>
      </div>

      <button
        type="submit"
        disabled={loading}
        style={{
          marginTop: "1.5rem",
          padding: "0.6rem 1.2rem",
          backgroundColor: "#1f2937",
          color: "white",
          border: "none",
          borderRadius: "4px",
          cursor: loading ? "not-allowed" : "pointer",
        }}
      >
        {loading ? "Consultando..." : "Realizar consultas"}
      </button>
    </form>
  );
}