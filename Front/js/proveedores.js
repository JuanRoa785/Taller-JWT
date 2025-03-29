const token = localStorage.getItem("token");

function loadData() {
    let token = localStorage.getItem("token");
    fetch("http://localhost:8080/api/proveedores/list", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    })
    .then(response => response.json())
    .then(data => {
        let table = document.getElementById('proveedor-table');
        table.innerHTML = "";
        //console.log(data);
        data.forEach((element) => {
            table.innerHTML += `
                <tr>
                    <th>${element.id}</th>
                    <th>${element.nit}</th>
                    <th>${element.nombre}</th>
                    <th>${element.ciudad}</th>
                    <th>${element.telefono}</th>
                    <th>${element.direccion}</th>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "form_proveedores.html?idproveedor=${element.id}"'>ver</button>
                    </td>
                </tr>
            `;
        });
    })
    .catch(error => {
        console.error("Error:", error);
        document.getElementById('proveedor-table').innerHTML = `
            <tr>
                <td colspan="7">Error al recuperar los datos.</td>
            </tr>
        `;
    });
}

function loadProveedor(idproveedor) {
    let token = localStorage.getItem("token");

    fetch(`http://localhost:8080/api/proveedores/list/${idproveedor}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    })
    .then(response => response.json())
    .then(data => {
        //console.log(data);
        document.getElementById('proveedor-id').value = data.id;
        document.getElementById('proveedor-ciudad').value = data.ciudad;
        document.getElementById('proveedor-nit').value = data.nit;
        document.getElementById('proveedor-nombre').value = data.nombre;
        document.getElementById('proveedor-telefono').value = data.telefono;
        document.getElementById('proveedor-direccion').value = data.direccion;
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Error al recuperar los datos.");
    });
}

function saveProveedor() {
    let token = localStorage.getItem("token");

    let data = {
        id: document.getElementById('proveedor-id').value,
        ciudad: document.getElementById('proveedor-ciudad').value,
        direccion: document.getElementById('proveedor-direccion').value,
        nombre: document.getElementById('proveedor-nombre').value,
        telefono: document.getElementById('proveedor-telefono').value,
        nit: document.getElementById('proveedor-nit').value
    };

    let endpoint = data.id ? "api/proveedores/updateProveedor" : "api/proveedores/addProveedor";
    let method = data.id ? "PUT" : "POST";

    fetch(`http://localhost:8080/${endpoint}`, {
        method: method,
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        },
        body: JSON.stringify(data)
    })
    .then(async response => {
        if (!response.ok) {
            const errorData = await response.json();
            throw errorData;
        }
        return response.json();
    })
    .then(() => {
        alert('Proveedor Creado o actualizado Exitosamente.');
        window.location = 'proveedores.html';
    })
    .catch(error => {
        console.error("Error:", error);
        alert(`Error al guardar los cambios`);
    });
}

function deleteProveedor() {
    let token = localStorage.getItem("token");
    let id = document.getElementById('proveedor-id').value;

    fetch(`http://localhost:8080/api/proveedores/deleteProveedor/${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    })
    .then(() => {
        alert('Registro Eliminado Exitosamente.');
        window.location = 'proveedores.html';
    })
    .catch(error => {
        console.error("Error:", error);
        alert('Error al eliminar el proveedor.');
    });
}

function cerrarSesion(){
    localStorage.removeItem("token");
    window.location='index.html'
}