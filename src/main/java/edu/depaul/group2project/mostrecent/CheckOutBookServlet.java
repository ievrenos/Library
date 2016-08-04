package edu.depaul.group2project.mostrecent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckOutBookServlet extends HttpServlet {
    
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("edu.depaul_Group2Project-MostRecent_war_1.0PU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    

        entityManager.getTransaction().begin();
        boolean existsBook  = false;
        boolean isAvailable = false;
        String isbn         = request.getParameter("isbn");
        int quantityInStock = 0;
        
        if(existsBook(isbn)) {
            existsBook = true;           
        }
        
        if(existsBook && isAvailable(isbn)) {
            isAvailable = true;
            quantityInStock = decreaseQuantityAvailableOnCheckout(isbn);            
        }
        
        request.setAttribute("existsBook", existsBook);
        request.setAttribute("isAvailable", isAvailable);
        request.setAttribute("quantityInStock", quantityInStock);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CheckoutConfirmation.jsp");
        dispatcher.forward(request, response);
        entityManager.getTransaction().commit();
    }
    
    /**
     * Validate that the ISBN exists in the database
     */
    private boolean existsBook(String isbn) {
        Query isbnCount = entityManager.createNamedQuery("Book.getCountByIsbn", Book.class);
        isbnCount.setParameter("isbn", Integer.parseInt(isbn));
        
        int bookCount = ((Number)isbnCount.getSingleResult()).intValue();        
        
        if (bookCount == 0) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Validate that there are copies of the book available. 
     * Call existsBook first, else passing a non-existent ISBN here will cause an exception.
     */
    private boolean isAvailable(String isbn) {
        Query bookQuery = entityManager.createNamedQuery("Book.findByIsbn", Book.class);
        bookQuery.setParameter("isbn", Integer.parseInt(isbn));
        
        List<Book> bookList = bookQuery.getResultList();
        
        // Selecting the 1st one because there should only be one book returned since ISBNs are unique
        Book book = bookList.get(0);
        
        if (book.getCopiesAvailable() > 0) {
            return true;
        }       
        
        return false;
    }
    
    /**
     * Assuming the book has been validated to exist and be available, decrease the quantity
     * by 1 to indicate that a copy has been checked out and return the new inventory count.
     */
    private int decreaseQuantityAvailableOnCheckout(String isbn) {
        // Get current quantity
        Query bookQuery = entityManager.createNamedQuery("Book.findByIsbn", Book.class);
        bookQuery.setParameter("isbn", Integer.parseInt(isbn));
        
        List<Book> bookList = bookQuery.getResultList();
        
        // Selecting the 1st one because there should only be one book returned since ISBNs are unique
        Book book                   = bookList.get(0);
        int currentQuantityInStock  = book.getCopiesAvailable();
        
        // Decrease that quantity by 1
        int newQuantityInStock = --currentQuantityInStock;
        System.out.println("newQuantityInStock: " + newQuantityInStock);
        
        // Update the quantity
        book.setCopiesAvailable(newQuantityInStock);
        entityManager.persist(book);    
        
        return newQuantityInStock;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
