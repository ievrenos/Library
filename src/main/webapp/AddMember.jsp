
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Member</title>
    </head>
    
    <form action="AddMemberServlet" method="POST">
        Member Name  : <input type="text" name="name"  size="20"><br />
        Member Email : <input type="text" name="email" size="20"><br />
        Member Phone : <input type="text" name="phone" size="10"><br />
        ID Number    : <input type="text" name="id" size="4"><br />
        
        <input type="submit" value="Submit">    
    </form>
    <br /><br />
    
    
</html>
