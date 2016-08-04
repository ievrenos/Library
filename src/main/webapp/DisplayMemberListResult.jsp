<%@page import="edu.depaul.group2project.mostrecent.Member1"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Member List</title>
    </head>
    <body>
        <table width="700px" align="center" 
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center" 
                    style="background-color:ffeeff">
                    <b>Member List Result</b></td>
            </tr>
            <tr style="background-color:efefef;">

            </tr>
            <%

                String color = "#F9EBB3";

                if (request.getAttribute("memberList") != null) {
                    List<Member1> memberList = (List<Member1>) request.getAttribute("memberList");

                    for (Member1 member : memberList) {

            %>
            <tr style="background-color:<%=color%>;">
                <td><%=member%></td>

            </tr>
            <%
                    }
                }
            %> 

        </table>
    </body>
</html>
