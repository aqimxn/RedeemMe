// Get the modals
var modalUpdate = document.getElementById("modal-update");
var modalUpdatePassword = document.getElementById("modal-update-password");

function openUpdateCustomer() {
    modalUpdate.style.display = "flex"  //use flex in order to center a div, otherwise it will display block
}

function closeUpdateCustomer(){
    modalUpdate.style.display = "none";
}

function openUpdatePassword() {
    modalUpdatePassword.style.display = "flex"  //use flex in order to center a div, otherwise it will display block
}

function closeUpdatePassword(){
    modalUpdatePassword.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalUpdate) {
        modalUpdate.style.display = "none";
    }
    if (event.target == modalUpdatePassword) {
        modalUpdatePassword.style.display = "none";
    }
}