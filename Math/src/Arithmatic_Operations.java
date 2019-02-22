import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Arithmatic_Operations
 */
@WebServlet("/Arithmatic_Operations")
public class Arithmatic_Operations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Arithmatic_Operations() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String str=request.getParameter("num1");
		String str1=request.getParameter("num2");
		String str2=request.getParameter("operation");
		
		int a=Integer.parseInt(str);
		int b=Integer.parseInt(str1);
		
		if(str2.equals("add")) {
			int c=a+b;
			out.println("Sum is:"+c);
		}
		if(str2.equals("sub")) {
			int c=a-b;
			out.println("Subtraction is:"+c);
		}
		if(str2.equals("mul")) {
			int c=a*b;
			out.println("Multiplication is:"+c);
		}
		if(str2.equals("div")) {
			int c=a/b;
			out.println("Division is:"+c);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}