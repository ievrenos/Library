

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add book</title>
    </head>
    <form action="AddBookServlet" method="POST">
    
       
       
            Book Title : <input type="text" name="title" size="20"><br />
            Book Author : <input type="text" name="author" size="20"><br />
            Book ISBN : <input type="text" name="isbn" size="6">
            (Only the first 6 numbers will be used)<br />
            Publication Date : <input type="text" name="date" size="20"><br />
            Copies Available : <input type="text" name="copiesAvailable" size="20"><br />
            Checkout Duration Type :
            <SELECT NAME="checkoutTime">
                <OPTION VALUE="day" selected> day</option>
                <OPTION VALUE="week"> week </option>
                <OPTION VALUE="2 weeks"> 2 weeks</option>
            </SELECT>
            <br />
            Maximum Number Of Renewals : <input type ="text" name="maxRenewals" size="20"><br />
            <br /><br />
            <input type="submit" value="Submit">
        </form>
    </html>
