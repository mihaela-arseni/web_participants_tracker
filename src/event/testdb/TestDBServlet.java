package event.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDBServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		setup connection variables
		String user = "springguest";
		String password = "springguest";
		String url = "jdbc:mysql://localhost:3306/web_participants_tracker";

//		get a connection to the database

		try {

			PrintWriter out = response.getWriter();
			out.println("Connecting to db: " + url);

//			load and register JDBC driver for MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myConnection = DriverManager.getConnection(url, user, password);

			out.println("Successfully connected!");

			myConnection.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
