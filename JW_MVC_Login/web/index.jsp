<%-- 
    Document   : index
    Created on : 07/07/2024, 12:59:01
    Author     : Marcos Melo
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="assets/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="assets/js/jquery-3.7.1.min.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="UserController" method="POST">
            <input type="text" name="user">
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        
    
    <script>
        $(document).ready(() => {
            
        });
    </script>
    </body>
</html>
