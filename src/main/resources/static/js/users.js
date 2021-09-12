// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsers();
    $('#users').DataTable();
});

async function cargarUsers(){
    const request = await fetch('api/users', {
      method: 'GET',
      headers: getHeaders(),
    });
    const users = await request.json();

    let listadoHtml = '';

    for (let usr of users ) {
        let deleteButton = '<a href="#" onclick="deleteUser('+ usr.id +')" class=\"btn btn-danger btn-circle btn-sm\"><i class=\"fas fa-trash\"></i> </a> '
        let phone = usr.phone == null ? '-' : usr.phone;
        let user = '<tr>\n <td>' + usr.id + '</td>\n <td>'+ usr.name + ' ' + usr.lastName + '</td> ' +
            '<td> ' + usr.email + '</td> <td>' + phone + '</td><td> ' +
              deleteButton +
            '<a href=\"#\" class=\"btn btn-warning btn-circle btn-sm\"> <i class=\"far fa-edit\"></i> </a> </td> </tr>';
        listadoHtml += user;
    }
    document.querySelector('#users tbody').outerHTML = listadoHtml;
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization' : localStorage.token
    }
}

async function deleteUser(id) {

    if (!confirm("Are you sure?")){
        return;
    }

    const request = await fetch('api/user/' + id, {
        method: 'DELETE',

        headers: getHeaders(),
    });
    location.reload();
}
