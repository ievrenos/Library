
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


public class BookListServlet extends HttpServlet {

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
            out.println("<title>Servlet BookSearchServlet</title>");
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

        // processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");

        emf = Persistence.createEntityManagerFactory("edu.depaul_Group2Project-MostRecent_war_1.0PU");
        em = emf.createEntityManager();
        Query bookQuery = em.createQuery("SELECT b FROM Book b");
        List books;
        books = bookQuery.getResultList();

        request.setAttribute("bookList", books);
        String nextJSP = "/DisplayBookListResult.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

        em.getTransaction().begin();

        //em.persist(book);

        em.getTransaction().commit();

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public void init() {
        counter = 0;

        em = (EntityManager) getServletContext().getAttribute("EntityManager");
    }

    public void destroy() {
        //em.close();
        //emf.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
