// Get the modals
var modalView = document.getElementById("modal-view");

function openViewOrder() {
    modalView.style.display = "flex"  //use flex in order to center a div, otherwise it will display block
}

function closeViewOrder(){
    modalView.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalView) {
        modalView.style.display = "none";
    }

}