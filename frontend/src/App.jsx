import { useState } from "react";

function App() {
  const [respuesta, setRespuesta] = useState("");

  const probarBackend = async () => {
    try {
      const res = await fetch("http://localhost:8080/api/ping");
      const data = await res.text();
      setRespuesta(data);
    } catch (err) {
      setRespuesta("Error: " + err.message);
    }
  };

  return (
    <div style={{ padding: "2rem", fontFamily: "Arial" }}>
      <h1>Sistema SRI / ANT - Demo</h1>
      <button onClick={probarBackend}>
        Probar conexión con backend
      </button>

      <p>Respuesta del backend: {respuesta}</p>
    </div>
  );
}

export default App;