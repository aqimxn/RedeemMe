// Get the modals
var modalView = document.getElementById("modal-view");
var modalUpdate = document.getElementById("modal-update");
var submitBtn = document.getElementById("submit-btn");
var updateBtn = document.getElementById("update-btn");

var currentStatus = document.getElementById("modal-update").getAttribute("data-current-status");
if (currentStatus == "Delivered"){
    updateBtn.style.display = "none";
}

// When the user clicks on the buttons to open the modals
function openViewOrder(){
    modalView.style.display = "flex";
}

function closeViewOrder(){
    modalView.style.display = "none";
}

function openUpdateOrder() {
    submitBtn.style.display = "none";
    var currentStatus = document.getElementById("modal-update").getAttribute("data-current-status");
    var statusSelect = document.getElementById("status");
    
    // Set the selected attribute for the current status option
    for (var i = 0; i < statusSelect.options.length; i++) {
        if (statusSelect.options[i].value === currentStatus) {
            statusSelect.options[i].selected = true;
            break;
        }
    }
    
    modalUpdate.style.display = "flex";
    updateStatusOptions(); // Initial update based on current status
}

function closeUpdateOrder(){
    modalUpdate.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalView) {
        modalView.style.display = "none";
    }
    if (event.target == modalUpdate) {
        modalUpdate.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", function() {
        updateStatusOptions();
    });

    document.getElementById("status").addEventListener("change", function() {
        updateStatusOptions();
    });

    function updateStatusOptions() {
        var currentStatus = document.getElementById("modal-update").getAttribute("data-current-status");
        var statusSelect = document.getElementById("status");
        var submitBtn = document.getElementById("submit-btn");
        var options = statusSelect.options;

        for (var i = 0; i < options.length; i++) {
            options[i].disabled = false;
        }

        if (currentStatus === statusSelect.value) {
            submitBtn.style.display = "none";
        } else {
            submitBtn.style.display = "flex";
        }

        if (currentStatus === "Pending") {
            disableOptions(["Shipped", "Delivered"]);
        } else if (currentStatus === "Processed") {
            disableOptions(["Pending", "Delivered"]);
        } else if (currentStatus === "Shipped") {
            disableOptions(["Pending", "Processed"]);
        } else if (currentStatus === "Delivered") {
            disableOptions(["Pending", "Processed", "Shipped"]);
        }
    }

    function disableOptions(optionsToDisable) {
        var statusSelect = document.getElementById("status");
        for (var i = 0; i < statusSelect.options.length; i++) {
            if (optionsToDisable.includes(statusSelect.options[i].value)) {
                statusSelect.options[i].disabled = true;
            }
        }
    }

    function closeUpdateOrder() {
        var modal = document.getElementById('modal-update');
        modal.style.display = 'none';
    }