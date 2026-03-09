document.addEventListener("DOMContentLoaded", function() {
    const reportLink = document.querySelector(".report-link");
    const mainContent = document.getElementById(".main");
  
    reportLink.addEventListener("click", function(event) {
      event.preventDefault(); // Prevent the default action of the link
      fetch("html/login.html")
        .then(response => response.text())
        .then(data => {
          mainContent.innerHTML = data; // Set the content of mainContent to the loaded data
        })
        .catch(error => {
          console.error("Error fetching report.jsp:", error);
        });
    });
  });


  