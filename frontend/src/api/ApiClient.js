// frontend/src/api/ApiClient.js

const BASE_URL = "http://localhost:8080";

async function handleResponse(response, defaultErrorMessage) {
  const text = await response.text(); // leemos el cuerpo como texto
  if (!response.ok) {
    // si hay error HTTP, lanzamos excepción con el mensaje del backend o uno por defecto
    throw new Error(text || defaultErrorMessage);
  }

  // Intentamos parsear como JSON. Si falla, devolvemos el texto tal cual.
  try {
    return JSON.parse(text);
  } catch {
    return text;
  }
}

export async function consultarContribuyente(ruc) {
  const url = `${BASE_URL}/api/sri/contribuyente?ruc=${encodeURIComponent(ruc)}`;
  const resp = await fetch(url);
  return handleResponse(resp, "Error al consultar contribuyente en el SRI");
}

export async function consultarVehiculo(placa) {
  const url = `${BASE_URL}/api/sri/vehiculo?placa=${encodeURIComponent(placa)}`;
  const resp = await fetch(url);
  return handleResponse(resp, "Error al consultar vehículo en el SRI");
}

export async function consultarLicencia(cedula) {
  const url = `${BASE_URL}/api/ant/licencia?cedula=${encodeURIComponent(cedula)}`;
  const resp = await fetch(url);
  return handleResponse(resp, "Error al consultar licencia en la ANT");
}