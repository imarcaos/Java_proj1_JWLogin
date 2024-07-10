$(document).ready(function () {
    callGetAllUsers();
});

function getAllUsers() {
    $.ajax({
        url: 'GetAllUsers',
        type: 'GET',
        dataType: 'JSON',
        data: 'accao=getAllUsers'
    }).done(function (response) {
        console.log(response);
        tableUsers(response);
    }).fail(function () {
        console.log("Erro na obtenção dos Users");
    });
}

function callGetAllUsers() {
    $(document).on('click', '#btn_getAllUsers', function () {
        getAllUsers();
    });
}

function tableUsers(data) {
    const divUsers = $('.tabela-users');
    let div = '';
    div += '<div class="row">';
    div += '<div class="col-md-12">';
    div += '<h3>Gestão de Users</h3>';
    div += '<button class="btn btn-primary">Add New User</button>';
    div += '<table class="table mt-3">';
    div += '<thead class="table-dark">';
    div += '<tr>';
    div += '<th>User name</th>';
    div += '<th>Email</th>';
    div += '<th>Created at</th>';
    div += '<th>Updated at</th>';
    div += '<th>Actions</th>';
    div += '</tr>';
    div += '</thead>';
    div += '<tbody>';
    for(const value of data) {
        div += '<tr>';
    div += '<td>'+value.idUser+'</td>';
    div += '<td>'+value.userEmail+'</td>';
    div += '<td>'+value.createdAt+'</td>';
    div += '<td>'+value.updatedAt+'</td>';
    div += '<td>';
    div += '<button class="btn btn-primary me-2">Edit</button>';
    div += '<button class="btn btn-danger">Delete</button>';
    div += '</td>';
    div += '</tr>';
    }    
    div += '</tbody>';
    div += '</table>';
    div += '</div>';
    div += '</div>';
    divUsers.html(div);
}