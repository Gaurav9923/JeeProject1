package Dao;

import Dto.Student;

public interface IStudentDao {
public String addStudent(Integer s_roll,String s_names,String s_course,Integer s_age,String s_gender);
public String updateStudent(Integer s_roll,String s_names,String s_course,Integer s_age,String s_gender);
public String deleteStudent(Integer s_roll);
public Student searchSudent(Integer s_roll);

}
