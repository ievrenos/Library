<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Confirmation</title>
    </head>
    <body>
        
        <!-- If book exists and is available, confirm that for the user -->
        <% if (request.getAttribute("existsBook").toString() == "true" && 
                request.getAttribute("isAvailable").toString() == "true") { %>
            <h3>The book was successfully checked out!</h3>
        <% } %>
        
        <!-- If book exists but is not available, print that it's checked out -->
        <% if (request.getAttribute("existsBook").toString() == "true" && 
                request.getAttribute("isAvailable").toString() == "false") { %>
            <h3>Sorry! All copies of that book are currently checked out!</h3>
        <% } %>
        
        <!-- If book doesn't exist, print that we don't have it -->
        <% if (request.getAttribute("existsBook").toString() == "false") { %>
            <h3>Sorry! A book with that ISBN either doesn't exist or we don't have it at this library!</h3>
        <% } %>
          
    </body>
</html>
