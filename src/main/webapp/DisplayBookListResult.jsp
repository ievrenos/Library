<%@page import="edu.depaul.group2project.mostrecent.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Book List</title>
    </head>
    <body>

        <table width="700px" align="center" 
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center" 
                    style="background-color:ffeeff">
                    <b>Book List Result</b></td>
            </tr>
            <tr style="background-color:efefef;">

            </tr>
            <%

                String color = "#F9EBB3";

                if (request.getAttribute("bookList") != null) {
                    List<Book> bookList = (List<Book>) request.getAttribute("bookList");

                    for (Book book : bookList) {

            %>
            <tr style="background-color:<%=color%>;">
                <td><%=book%></td>

            </tr>
            <%
                    }
                }
            %> 

        </table>
            
            <jsp:include page="SelectBookToCheckout.jsp" />
    </body>
</html>
