package CarRent;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int carid = Integer.parseInt(req.getParameter("carId"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        // 1. Update Car status
        Car car = em.find(Car.class, carid);
       
            car.setStatus("Available");
            em.merge(car);
    

        // 2. Delete the booking related to this car
        // Assuming Booking has carId mapped properly
        Booking booking = em.createQuery("SELECT b FROM Booking b WHERE b.carId = :carId", Booking.class)
                            .setParameter("carId", carid)
                            .getSingleResult();

      
            em.remove(booking);
        

        et.commit();

        // Redirect back to booked cars page
        resp.sendRedirect("seeallbookedcars");
    }
}
