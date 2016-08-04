
package edu.depaul.group2project.mostrecent;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddBookServlet extends HttpServlet {

    private int counter;
    private EntityManagerFactory emf;
    private EntityManager em;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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
        processRequest(request, response);
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title"),
                author = request.getParameter("author"),
                isbn = request.getParameter("isbn"),
                date = request.getParameter("date"),
                copies = request.getParameter("copiesAvailable"),
                checkout = request.getParameter("checkoutTime").trim(),
                maxRenewals = request.getParameter("maxRenewals");
        int numCopies, numIsbn, numDate, numRenewals;
        numCopies = Integer.parseInt(copies);
        numIsbn = Integer.parseInt(isbn);
        numDate = Integer.parseInt(date);
        numRenewals = Integer.parseInt(maxRenewals);
        
        Book book = new Book();
        Author bAuthor = new Author();
        CheckoutDuration bCheckout = new CheckoutDuration();
        
        bAuthor.setAuthorId(counter);
        bAuthor.setAuthorName(author);
        
        bCheckout.setCheckoutDurationId(counter);
        bCheckout.setMaxRenewals(numRenewals);
        if(checkout.equals("day"))
            bCheckout.setDays(1);
        if(checkout.equals("week"))
            bCheckout.setDays(7);
        if(checkout.equals("2 weeks"))
            bCheckout.setDays(14);
        
        counter++;
        
        book.setTitle(title);
        book.setAuthorIdFk(bAuthor);
        book.setCopiesAvailable(numCopies);
        book.setEditionYear(numDate);
        book.setIsbn(numIsbn);
        book.setCheckoutDurationIdFk(bCheckout);
       
        em.getTransaction().begin();
        
        em.persist(bAuthor);
        em.persist(book);
        em.persist(bCheckout);
        
        em.getTransaction().commit();
        
       
        
        // display a back button
        out.print("<Form><input value=\"Back\" "
                + "onClick=\"history.go(-1);return true;\"> </form>");
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
    
    
    public void init() {
        counter = 0;
        
        // keep this assignment in the init method
        // otherwise will not get assigned.  Do not move it from this 
        // method.
        //emf = Persistence.createEntityManagerFactory("edu.depaul_Group2Project-MostRecent_war_1.0PU");
        //emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        
        // Uncomment to try using the ServletContextListener
        // Might want to comment out line 169 and 136 and do nothing in the
        // destroy method
        em = (EntityManager)getServletContext().getAttribute("EntityManager");
    }

    public void destroy() {
        //em.close();
        //emf.close();

    }    
        
}
