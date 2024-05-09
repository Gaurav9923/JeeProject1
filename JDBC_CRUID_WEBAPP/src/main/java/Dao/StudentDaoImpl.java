package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dto.Student;
import JdbcUtils.UtilConnection;

public class StudentDaoImpl implements IStudentDao {
	Connection connection=null;
	PreparedStatement pstmt = null;
	ResultSet resultset=null;
	Student std=null;
	@Override
	public String addStudent(Integer s_roll, String s_names, String s_course, Integer s_age, String s_gender) {
		String sqlInsertQuery = "insert into student_data(`s_roll`,`s_names`,`s_course`,`s_age`,`s_gender`)values(?,?,?,?,?)";
		try {
			connection = UtilConnection.get_JDBC_Connection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			else {
				System.out.println("connection null");
			}

			if (pstmt != null) {
				pstmt.setInt(1, s_roll);
				pstmt.setString(2, s_names);
				pstmt.setString(3, s_course);
				pstmt.setInt(4, s_age);
				pstmt.setString(5, s_gender);

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public String updateStudent(Integer s_roll, String s_names, String s_course, Integer s_age, String s_gender) {
		String qry= "update  student_data set s_names=?,s_course=?,s_age=?,s_gender=?  where s_roll= ? ";
		try {
			connection=UtilConnection.get_JDBC_Connection();
			if(connection!=null) {
				pstmt=connection.prepareStatement(qry);
				pstmt.setString(1,s_names);
				pstmt.setString(2,s_course);
				pstmt.setInt(3,s_age);
				pstmt.setString(4,s_gender);
				pstmt.setInt(5,s_roll);
				System.out.println(qry);
			}
			Integer rowCount=null;
			if(pstmt!=null) {
			   rowCount=pstmt.executeUpdate();
			}
			if(rowCount==0) {
				return "Not Updated";
			}
			else {
				return "Update successfull";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
			}
	
	
	}

	@Override
	public String deleteStudent(Integer s_roll) {
		String qry ="delete from  student_data where s_roll= ?	";
		try {
			connection=UtilConnection.get_JDBC_Connection();
			if(connection!=null) {
				pstmt=connection.prepareStatement(qry);
				pstmt.setInt(1, s_roll);
			}
			Integer rowCount=null;
			if(pstmt!=null) {
				 rowCount=pstmt.executeUpdate();	
			}
			
			if(rowCount==0) {
				return "Not Found";
			}
			else {
				return "success";
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "catch failure ";
		}
	}

	@Override
	public Student searchSudent(Integer s_roll) {
		String qry="select * from student_data where s_roll=?";
		try {
			connection =UtilConnection.get_JDBC_Connection();
			if(connection!=null) {
					pstmt=connection.prepareStatement(qry);
					pstmt.setInt(1, s_roll);
										
			}
			resultset=pstmt.executeQuery();
			if(resultset!=null) {
				if(resultset.next()) {
					std=new Student();
					///copy result set data to student obj
					
					std.setS_age(resultset.getInt(5));
					std.setS_roll(resultset.getInt(2));
					std.setS_name(resultset.getString(3));
					std.setS_course(resultset.getString(4));
					std.setS_gender(resultset.getString(6));
					
					
					return std;
					
				}					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return std;
	}

}
