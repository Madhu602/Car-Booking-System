package CarRent;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/seeallbookedcars")
public class Bookedcars extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("app");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		

		et.begin();
		String jpql = "SELECT b FROM Booking b";
		List<Booking> carlist = em.createQuery(jpql, Booking.class).getResultList();

		req.setAttribute("carlist", carlist);
		
		et.commit();
        RequestDispatcher rd = req.getRequestDispatcher("showbookedcars.jsp");
        rd.forward(req, resp);
		
	}

}
