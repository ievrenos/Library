<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Books</title>
    </head>
    <body>

        <form action="BookListServlet" method="POST">

            <table border="0" width="200" align="left" bgcolor="#CDFFFF">
                <tr><td colspan=2 style="font-size:12pt;color:#00000;" align="center">
                        <h3>List Books</h3></td></tr>
          
                <tr><td colspan=1 align="left">
                        <input  type="submit" name="submit" value="List Books"></td></tr>
            </table>
        </form>

    </body>
</html>
