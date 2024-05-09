package ServiceFactory;

import ServiceLayer.IStudentService;
import ServiceLayer.StudentServiceImpl;

public class StudentServiceFactory {
		private static IStudentService studentService=null;
		private StudentServiceFactory() {
			
		}
		public static IStudentService getIStudentService() {
			if(studentService==null) {
			studentService =new StudentServiceImpl();
			}
			
			return studentService;
		}
		
}
