$(document).ready(function() {
    callGetAllUsers();
});

function getAllUsers() {
    $.ajax({
        url: 'GetAllUsers',
        type: 'GET',
        dataType: 'JSON',
        data: 'accao=getAllUsers'
    }).done(function(response) {
        // teste
        console.log(response);
    }).fail(function() {
        console.log("Erro na obten��o dos Users");
    });
}

function callGetAllUsers() {
    $(document).on('click', '#btn_getAllUsers', function() {
        getAllUsers();
    });
}