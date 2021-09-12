// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});

async function RegisterUsers(){
    let datos = {};
    datos.name = document.getElementById('txtName').value;
    datos.lastName = document.getElementById('txtLastName').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repeatPassword = document.getElementById('txtRepeatPassword').value;
    if (repeatPassword !== datos.password){
        alert("Password doesn't match");
        return;
    }

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(datos)
    });
    alert("successfully");
    window.location.href = 'login.html';

}

