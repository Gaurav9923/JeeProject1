package DaoFactory;

import Dao.*;

public class StudentDaoFactory {

	private StudentDaoFactory() {}
	private static IStudentDao stdudentDao=null;
	
	public static IStudentDao getIStudentDao() {
		if(stdudentDao==null)
		stdudentDao =new StudentDaoImpl();
		
		return stdudentDao;
	}
	
	
	
	
	
}
