$(document).ready(() => {
    callGetAllUsers();
});

function getAllUsers() {
    $.ajax({
        url: 'GetAllUsers',
        type: 'GET',
        dataType: 'JSON',
        data: 'accao=getAllUsers'
    }).done((response) => {
        // teste
        console.log(response);
    }).fail(() => {
        console.log("Erro na obtenção dos Users");
    });
}

function callGetAllUsers() {
    $(document).on('click', '#btn_getAllUsers', () => {
        getAllUsers();
    });
}