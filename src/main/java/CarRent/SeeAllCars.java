package CarRent;

import java.io.IOException;
import java.util.List;

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



@WebServlet("/seeallcars")
public class SeeAllCars extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		String Query = "select c from Car c where c.status=:status";
		List<Car> carlist=em.createQuery(Query,Car.class).setParameter("status","Available").getResultList();
		
		
		
		
		req.setAttribute("carlist", carlist);
		
		RequestDispatcher rd = req.getRequestDispatcher("Showcars.jsp");
		rd.forward(req, resp);
		et.commit();

	}

}
