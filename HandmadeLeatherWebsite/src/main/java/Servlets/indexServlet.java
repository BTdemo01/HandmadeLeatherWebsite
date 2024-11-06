package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.CSDL;
import Model.Hanghoa;


/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, 
    		IOException {
    		// TODO Auto-generated method stub
    		CSDL csdl=new CSDL();
    		List<Hanghoa> trendlist=new
    		ArrayList<Hanghoa>();
    		List<Hanghoa> popularlist = new
    		ArrayList<Hanghoa>();
    		try {
    		trendlist=csdl.getPopularProduct();
    		popularlist=csdl.getPopularProduct();
    		} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
    		request.setAttribute("trendlistp", trendlist);
    		request.setAttribute("popularlistp", 
    		popularlist);
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    /**
    * @see HttpServlet#doPost(HttpServletRequest 
    request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, 
    IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
    }

}
