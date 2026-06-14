import { useEffect, useState } from "react";
import { obtenerProductos } from "./api";

function App() {

    const [productos, setProductos] = useState([]);

    useEffect(() => {
        obtenerProductos()
            .then(data => {
                console.log(data);
                setProductos(data);
            })
            .catch(error => console.error(error));
    }, []);

    return (
        <div>
            <h1>Lista de Productos</h1>

            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Categoría</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        productos.map(p => (
                            <tr key={p.id}>
                                <td>{p.nombre}</td>
                                <td>{p.precio}</td>
                                <td>{p.categoria?.nombre}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default App;