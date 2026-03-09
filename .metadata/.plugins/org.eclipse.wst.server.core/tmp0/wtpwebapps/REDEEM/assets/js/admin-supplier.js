// Get the modals
var modalView = document.getElementById("modal-view");
var modalUpdate = document.getElementById("modal-update");
var modalDelete = document.getElementById("modal-delete");

// When the user clicks on the buttons to open the modals
function openViewSupplier(){
    modalView.style.display = "flex";
    modalUpdate.style.display = "none";
    modalDelete.style.display = "none";
}

function openUpdateSupplier() {
    modalUpdate.style.display = "flex"  //use flex in order to center a div, otherwise it will display block
    modalView.style.display = "none";
    modalDelete.style.display = "none";
}

function openDeleteSupplier(){
    modalDelete.style.display = "flex";
    modalView.style.display = "none";
    modalUpdate.style.display = "none";
}

// When the user clicks on the buttons to close the modals
function closeViewSupplier(){
    modalView.style.display = "none";
}

function closeUpdateSupplier(){
    modalUpdate.style.display = "none";
}

function closeDeleteSupplier(){
    modalDelete.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalView) {
        modalView.style.display = "none";
    }
    if (event.target == modalUpdate) {
        modalUpdate.style.display = "none";
    }
    if (event.target == modalDelete) {
        modalDelete.style.display = "none";
    }
}