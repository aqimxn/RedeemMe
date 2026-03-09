// Get the modals
var modalView = document.getElementById("modal-view");
var modalUpdate = document.getElementById("modal-update");
var updateBtn = document.getElementById("submit-btn");

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
    updateBtn.style.display = "none";
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

// Function to handle status change dynamically
    function handleStatusChange() {
        var currentStatus = document.getElementById("modal-update").getAttribute("data-current-status");
        var statusSelect = document.getElementById("status");

        // Disable options based on current status
        switch (currentStatus) {
            case "Pending":
                disableOptions(statusSelect, ["Pending", "Shipped", "Delivered"]);
                break;
            case "Processed":
                disableOptions(statusSelect, ["Pending", "Processed", "Delivered"]);
                break;
            case "Shipped":
                disableOptions(statusSelect, ["Pending", "Processed", "Shipped"]);
                break;
            case "Delivered":
                disableOptions(statusSelect, ["Pending", "Processed", "Shipped", "Delivered"]);
                break;
            default:
                break;
        }
    }

    // Function to disable options in select element
    function disableOptions(selectElement, optionsToDisable) {
        Array.from(selectElement.options).forEach(function(option) {
            if (optionsToDisable.includes(option.value)) {
                option.disabled = true;
            } else {
                option.disabled = false;
            }
        });
    }

    // Validation function to prevent invalid form submission
    function validateAndUpdate() {
        var selectedStatus = document.getElementById("status").value;
        var currentStatus = document.getElementById("modal-update").getAttribute("data-current-status");

        // Perform additional validation if needed
        // For example, prevent changing to an invalid status
        if (currentStatus === "Delivered" && selectedStatus !== "Delivered") {
            alert("Cannot change from Delivered status.");
            return false; // Prevent form submission
        }

        // Add more validation logic as per your requirements

        return true; // Allow form submission
    }

    // Initially handle status change on page load
    handleStatusChange();