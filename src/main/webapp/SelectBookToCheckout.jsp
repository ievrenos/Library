<!-- The part of the Book List page where the user chooses a book to checkout by ISBN -->

<h3>Enter the ISBN of the book you want to checkout and click Checkout: </h3>

<form action="CheckOutBookServlet" method="POST">
    Book ISBN : <input type="text" name="isbn" size="6">
    <input type="submit" value="Checkout">
</form>
