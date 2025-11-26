// frontend/src/App.jsx
import { useState } from "react";
import "./App.css";
import ConsultaForm from "./components/ConsultaForm";
import ResultadoContribuyente from "./components/ResultadoContribuyente";
import ResultadoVehiculo from "./components/ResultadoVehiculo";
import ResultadoLicencia from "./components/ResultadoLicencia";
import {
  consultarContribuyente,
  consultarVehiculo,
  consultarLicencia,
} from "./api/ApiClient";

function App() {
  const [contribuyente, setContribuyente] = useState(null);
  const [vehiculo, setVehiculo] = useState(null);
  const [licencia, setLicencia] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleConsultar = async ({ email, ruc, placa, cedula }) => {
    // el correo podrías almacenarlo o enviarlo al backend si luego lo necesitas
    console.log("Consulta realizada por:", email);

    setLoading(true);
    setError("");
    setContribuyente(null);
    setVehiculo(null);
    setLicencia(null);

    try {
      const [respContrib, respVeh, respLic] = await Promise.all([
        consultarContribuyente(ruc),
        consultarVehiculo(placa),
        consultarLicencia(cedula),
      ]);

      setContribuyente(respContrib);
      setVehiculo(respVeh);
      setLicencia(respLic);
    } catch (e) {
      console.error(e);
      setError(e.message || "Ocurrió un error al realizar las consultas");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App" style={{ padding: "2rem" }}>
      <h1>Sistema SRI / ANT - Demo</h1>

      <ConsultaForm onConsultar={handleConsultar} loading={loading} />

      {error && (
        <div
          style={{
            marginBottom: "1.5rem",
            padding: "0.75rem 1rem",
            backgroundColor: "#fee2e2",
            color: "#991b1b",
            borderRadius: "4px",
          }}
        >
          {error}
        </div>
      )}

      <ResultadoContribuyente data={contribuyente} />
      <ResultadoVehiculo data={vehiculo} />
      <ResultadoLicencia data={licencia} />
    </div>
  );
}

export default App;