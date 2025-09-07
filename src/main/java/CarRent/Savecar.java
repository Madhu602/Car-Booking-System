package CarRent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/registercar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
maxFileSize = 1024 * 1024 * 10,  // 10 MB
maxRequestSize = 1024 * 1024 * 50) // 50 MB
public class Savecar extends HttpServlet{
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("carid"));
		System.out.println(id);
		
		String carname = req.getParameter("carname");
		System.out.println(carname);
		
		
		String carmodel = req.getParameter("carmodel");
		System.out.println(carmodel);
		
		int carnumber = Integer.parseInt(req.getParameter("carnumber"));
		System.out.println(carnumber);
		
		String carownername = req.getParameter("carownername");
		System.out.println(carownername);
		
	     
		// Handle file upload
        Part filePart = req.getPart("carImage");
        String fileName = filePart.getSubmittedFileName();

        // Save uploaded file in server folder "uploads"
        String uploadPath = getServletContext().getRealPath("") + "uploads";
        java.io.File uploadDir = new java.io.File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + java.io.File.separator + fileName;
        filePart.write(filePath);

        // Save only relative path in DB (so we can use it later in JSP)
        String dbPath = "uploads/" + fileName;
		
	
		
		
		
		Car car = new Car(id,carname,carmodel,carnumber,carownername,dbPath);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(car);
		
		PrintWriter pw = resp.getWriter();
		pw.println("Registered "+carname+" Successfully");
		
		
		et.commit();
		
		
		
	}

}
