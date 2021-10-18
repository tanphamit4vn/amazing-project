package JavaAssignment.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	private String userName;
	private String pass;
	private String roles;
	private String fullName;
	private int age;
	private String gender;
	private String phoneNumber;
	
	
	
	public Account(ResultSet resultSet) {
		try {
			userName = resultSet.getString("userName");
			pass = resultSet.getString("pass");
			roles = resultSet.getString("roles");
			fullName = resultSet.getString("fullName");
			age = resultSet.getInt("age");
			gender = resultSet.getString("gender");
			phoneNumber = resultSet.getString("phoneNumber");
		} catch (SQLException e) {
			System.out.println("Account - ResultSet Error: " + e.getMessage());
		}
	}
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String userName, String pass, String roles, String fullName, int age, String gender,
			String phoneNumber) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.roles = roles;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}
	public Account(String userName, String roles) {
		super();
		this.userName = userName;
		this.roles = roles;
	}



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", pass=" + pass + ", roles=" + roles + ", fullName=" + fullName
				+ ", age=" + age + ", gender=" + gender + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
