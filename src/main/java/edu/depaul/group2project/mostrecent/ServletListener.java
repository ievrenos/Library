
package edu.depaul.group2project.mostrecent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        emf = Persistence.createEntityManagerFactory("edu.depaul_Group2Project-MostRecent_war_1.0PU");
        em = emf.createEntityManager();
        context.setAttribute("EntityManager", em);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        em.close();
        emf.close();
    }
}
