// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});

async function loginUser(){
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(datos)
    });

    const response = await request.text();

    if (response != 'FAIL'){
        localStorage.token = response;
        localStorage.email = datos.email;
        window.location.href = 'users.html';
    }else{
        alert("User and password are wrong")
    }

}