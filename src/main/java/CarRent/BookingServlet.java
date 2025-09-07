package CarRent;

import java.io.IOException;

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

@WebServlet("/booking")
public class BookingServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carid")) ;
		String userName=req.getParameter("username");
		String fromDate=req.getParameter("from");
		String toDate=req.getParameter("to");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = em.find(Car.class, carId);
		Booking booking = new Booking(carId, userName, fromDate, toDate, car.getImage()); 

		car.setStatus("Booked");
		
		et.begin();
		
		em.persist(booking);
		em.persist(car);
		
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("book.html");
		rd.forward(req, resp);
		
	}

}
