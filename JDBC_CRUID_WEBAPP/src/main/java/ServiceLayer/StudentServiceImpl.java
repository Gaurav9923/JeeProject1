package ServiceLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.*;
import DaoFactory.StudentDaoFactory;
import Dto.Student;
import JdbcUtils.UtilConnection;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao=null;

	@Override
	public String addStudent(Integer s_roll, String s_names, String s_course, Integer s_age, String s_gender) {
		studentDao=StudentDaoFactory.getIStudentDao();
		return studentDao.addStudent(s_roll, s_names, s_course, s_age, s_gender);
		
	}

	@Override
	public String updateStudent(Integer s_roll, String s_names, String s_course, Integer s_age, String s_gender) {
		studentDao=StudentDaoFactory.getIStudentDao();
		
		return studentDao.updateStudent(s_roll, s_names, s_course, s_age, s_gender);
	}

	@Override
	public String deleteStudent(Integer s_roll) {
		studentDao=StudentDaoFactory.getIStudentDao();
		
		return studentDao.deleteStudent(s_roll);
	}

	@Override
	public Student searchSudent(Integer s_roll) {
		studentDao=StudentDaoFactory.getIStudentDao();
		return studentDao.searchSudent(s_roll);
	}

}
