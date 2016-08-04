<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>


        <h1>Welcome to Pretend Library</h1>
        <UL>
            <LI><%= new java.util.Date() %>
        </UL>

        <a href="AddMember.jsp">Go to member add page</a>
    <br />
    <br />

    <a href="AddBook.jsp">Go to add book page</a>    

    <br />
    <br />
    
    <a href="ListMembers.jsp">List the members</a>
    
    <br />
    <br />
    
     <a href="ListBooks.jsp">List the books and choose one to checkout</a>
     
      <br />
    <br />

    <img src="library.jpg" width="1400" height="750" alt="library"/>              

</body>
</html>
