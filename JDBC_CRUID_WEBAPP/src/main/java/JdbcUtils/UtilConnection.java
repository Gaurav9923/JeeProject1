package JdbcUtils;
import java.sql.*;
import java.util.Properties;

import com.zaxxer.hikari.*;
import com.zaxxer.hikari.HikariDataSource;

import java.io.*;

public class UtilConnection {
	private UtilConnection() {
			
			
		
	}
		static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Driver Loaded Manually");
	}
	
	public static Connection get_JDBC_Connection() throws IOException, SQLException     {
		//Physical connectio 
//		FileInputStream fis=new FileInputStream("D:\\Java_Workspace2\\JDBC_CRUID_WEBAPP\\src\\main\\java\\AppProperties\\app.properties");
//		Properties prop=new Properties();
//		prop.load(fis);
//		   String user =prop.getProperty("user");
//        String pass =prop.getProperty("password");
//        String url =prop.getProperty("jdbcUrl");		
//        System.out.println("CONNECTION object created...");
//		return DriverManager.getConnection(url, user, pass); 
		
		
		
		//logical connection
		
		HikariConfig config=new HikariConfig("D:\\\\Java_Workspace2\\\\JDBC_CRUID_WEBAPP\\\\src\\\\main\\\\java\\\\AppProperties\\\\app.properties");
		HikariDataSource dataSource=new HikariDataSource(config);
		return dataSource.getConnection();				//logical connection pool
	}

}
