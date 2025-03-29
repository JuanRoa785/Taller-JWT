function togglePassword() {
    const passwordInput = document.getElementById("password");
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

async function iniciarSesion(){
    try {
        const respuesta = await fetch("http://localhost:8080/api/usuarios/logIn", {
            method: "POST",
            headers: {
              "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({
                "userName": document.getElementById("username").value,
                "password": document.getElementById("password").value
            }),
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
            alert("Usuario o contraseña incorrectos");
            return
        }

        const data = await respuesta.json();
        localStorage.setItem("token", data.token);
        //console.log("Token almacenado en localStorage:", data.token);
        
        window.location.href = "proveedores.html";
        

    } catch (error) {
        console.log(error)
    }
}    