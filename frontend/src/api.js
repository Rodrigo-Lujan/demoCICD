const URL = "/api/productos";

export async function obtenerProductos() {
    const response = await fetch(URL);
    return response.json();
}