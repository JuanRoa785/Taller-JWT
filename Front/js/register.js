function toggleRepeatPassword() {
    const passwordInput = document.getElementById("repeatPassword");
    const eyeOpen = document.getElementById("eye-open");
    const eyeClosed = document.getElementById("eye-closed");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        eyeOpen.style.display = "none";
        eyeClosed.style.display = "block";
    } else {
        passwordInput.type = "password";
        eyeOpen.style.display = "block";
        eyeClosed.style.display = "none";
    }
}

async function Registrarse(){
    try {
        if (document.getElementById("password").value != document.getElementById("repeatPassword").value) {
            alert("Las contraseñas no coinciden");
            return
        }

        const usuario = {
            idTipodocumento: {
                id: 1 //Por simplicidad se dejo por default
            },
            numeroDocumento: document.getElementById("cedula").value,
            nombre: document.getElementById("name").value,
            password: document.getElementById("password").value,
            userName: document.getElementById("username").value,
            email: document.getElementById("email").value
        };

        const respuesta = await fetch("http://localhost:8080/api/usuarios/signUp", {
            method: "POST",
            headers: {
              "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(usuario),
            credentials: "include"
        })

        /*
        console.log(JSON.stringify( {
            "userName": document.getElementById("username").value,
            "password": document.getElementById("password").value
        }))*/

        if (!respuesta.ok) {
            const errorData = await respuesta.json();
            console.log(errorData);
            alert("Datos invalidos o incompletos!");
            return
        }

        const data = await respuesta.json();
        localStorage.setItem("token", data.token);
        //console.log("Token almacenado en localStorage:", data.token);
        
        window.location.href = "home.html";
        

    } catch (error) {
        console.log(error)
    }
} 