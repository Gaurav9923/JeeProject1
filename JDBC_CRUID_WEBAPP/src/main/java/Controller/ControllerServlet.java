package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Student;
import ServiceFactory.StudentServiceFactory;
import ServiceLayer.IStudentService;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		System.out.println("URI ::"+ request.getRequestURI());
		System.out.println("PATH ::"+ request.getPathInfo());
		if(request.getRequestURI().endsWith("addform")) {
			addAction(request,response);
			System.out.println("add operation succesfull");
		}
		
		if(request.getRequestURI().endsWith("deleteform")) {
			deleteAction(request,response);
			System.out.println("delete operation succesfull");
		}
		if(request.getRequestURI().endsWith("searchform")) {
			searchAction(request,response);
			System.out.println("search operation succesfull");
		}
		if(request.getRequestURI().endsWith("editform")) {
			updateAction(request,response);
			
		}
		if(request.getRequestURI().endsWith("updaterecord")) {
			//IStudentService iStudentService = StudentServiceFactory.getIStudentService();		
			IStudentService iStudentService = StudentServiceFactory.getIStudentService();
			
					String ids=request.getParameter("sroll");
					int id=Integer.parseInt(ids);
					String name=request.getParameter("name");
					String ages=request.getParameter("age");
					int age=Integer.parseInt(ages);
					String course=request.getParameter("course");
					String gender=request.getParameter("gender");
					System.out.println("point1");
					System.out.println(ids+":"+id+"//"+name+"//"+ages+":"+age+"//"+course+"//"+gender);
					System.out.println("point2");
					
				String msg=	iStudentService.updateStudent(id, name, course, age,gender);
				PrintWriter out1 = response.getWriter();
				
				if(msg.equalsIgnoreCase("Update successfull")) {
					out1.println("<h1 style='color:green ;text-align:center ;'> UPDATE SUCCESSFUL </h1>");
				}else {
					out1.println("<h1 style='color:red ;text-align:center ;'> UPDATE FAILED </h1>");

				}
				out1.close();					
	      }

		
		
		
	}
	
	public void addAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		IStudentService iStudentService = StudentServiceFactory.getIStudentService();
		Integer roll=Integer.parseInt(request.getParameter("sroll"));
				String name=request.getParameter("sname");
				String course=request.getParameter("scourse");
				Integer age= Integer.parseInt(request.getParameter("sage"));
				String gend= request.getParameter("sgender");
		String msg=iStudentService.addStudent(roll,name,course,age,gend);
		System.out.println(name+"//"+course+"//"+age+"//"+gend+"//"+roll);
		PrintWriter out = response.getWriter();
		
		if(msg.equalsIgnoreCase("success")) {
			out.println("<h1 style='color:green ;text-align:center ;'> OPERATION SUCCESSFUL </h1>");
		}else {
			out.println("<h1 style='color:red ;text-align:center ;'> OPERATION FAILED </h1>");

		}
		out.close();
	}
	public void deleteAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		IStudentService iStudentService=StudentServiceFactory.getIStudentService();
		Integer roll=Integer.parseInt(request.getParameter("sroll").strip());

		String msg=iStudentService.deleteStudent(roll);
		System.out.println(msg);
		PrintWriter out = response.getWriter();
		
		if(msg.equalsIgnoreCase("success")) {
			out.println("<h1 style='color:green ;text-align:center ;'> OPERATION SUCCESSFUL ::"+ msg+"</h1>");
		}else {
			out.println("<h1 style='color:red ;text-align:center ;'> OPERATION FAILED ::"+ msg+" </h1>");

		}
		out.close();
	}
	
	public void searchAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		IStudentService iStudentService=StudentServiceFactory.getIStudentService();
		Integer roll=Integer.parseInt(request.getParameter("sroll").strip());

		Student std=iStudentService.searchSudent(roll);
		PrintWriter out = response.getWriter();
		if(std!=null) {
			
			out.println("<h1 style='color:green ;text-align:center ;'> OPERATION SUCCESSFUL </h1>");
			
					
				
					out.println("<th>Roll ::</th>");
					out.println("<td>"+std.getS_roll()+"</td> </br>");
					out.println("<th>Name ::</th>");
					out.println("<td>"+std.getS_name()+"</td> </br>");
					out.println("<th>Course ::</th>");
					out.println("<td>"+std.getS_course()+"</td> </br>");
					out.println("<th>Age ::</th>");
					out.println("<td>"+std.getS_age()+"</td> </br>");
					out.println("<th>Gender ::</th>");
					out.println("<td>"+std.getS_gender()+"</td> </br>");
					
					out.println(" </tr>");
				
				
		       
		}
		else
		{out.println("<h1 style='color:red ;text-align:center ;'> OPERATION FAILED  </h1>");}
		
		out.close();
		}
	
	public void updateAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		IStudentService iStudentService=StudentServiceFactory.getIStudentService();
	
		String sid=request.getParameter("sroll").strip();
		Student std=iStudentService.searchSudent(Integer.parseInt(sid));
		PrintWriter out = response.getWriter();
		
		if(std!=null) {
			
			out.println("<body>");
			out.println("<center>");
			out.println("<form method='post' action='./controller/updaterecord' >");		
			out.println("<table>");
			
			out.println("<tr> <th> ID </th> <td>" +std.getS_roll()+"</td></tr>");
			out.println("<input type='hidden' name='sroll' value='"+std.getS_roll()+"'/>");
			out.println("<tr> <th> NAME </th> <td> <input type='text' name='name' value='" +std.getS_name()+"'/> </td></tr>");
			out.println("<tr> <th> AGE </th> <td> <input type='text' name='age' value='" +std.getS_age()+"'/> </td></tr>");
			out.println("<tr> <th> COURSE </th> <td> <input type='text' name='course' value='" +std.getS_course()+"'/> </td></tr>");
			out.println("<tr> <th> GENDER </th> <td> <input type='text' name='gender' value='" +std.getS_gender()+"'/> </td></tr>");
	         
			out.println("<tr><td><input type='submit' value='update'/> </td></tr> ");
			
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			
			out.println("</body>");
			
		}
		else {
			out.println("<body>");
			
			out.println("<h1 style='color:red ;text-align:center ;'> RECORD NOT AVAILABLE</h1>");
			out.println("</body>");
			
		}
		out.close();
		
		
		
	}






}


