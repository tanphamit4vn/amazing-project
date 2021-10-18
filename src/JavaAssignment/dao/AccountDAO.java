package JavaAssignment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JavaAssignment.connected.DBConnection;
import JavaAssignment.model.Account;
import JavaAssignment.model.HotelRooms;

public class AccountDAO {
	public ArrayList<Account> getAll() {
		ArrayList<Account> result = new ArrayList<Account>();
		try {
			if (DBConnection.open()) {
				Statement statement = DBConnection.getConnection().createStatement();
				String sqlQuery = "SELECT * FROM ACCOUNT";
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					Account account = new Account(resultSet);
					result.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	
	public ArrayList<Account> getUserName() {
		ArrayList<Account> result = new ArrayList<Account>();
		try {
			if (DBConnection.open()) {
				Statement statement = DBConnection.getConnection().createStatement();
				String sqlQuery = "SELECT userName FROM ACCOUNT";
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					Account account = new Account(resultSet);
					result.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	
	public ArrayList<Account> getListToSetRoles() {
		ArrayList<Account> result = new ArrayList<Account>();
		try {
			if (DBConnection.open()) {
				Statement statement = DBConnection.getConnection().createStatement();
				String sqlQuery = "SELECT * FROM ACCOUNT WHERE roles != 'admin' ";
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					Account account = new Account(resultSet);
					result.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	
	
	public boolean customerRegister(Account account) {
		try {
			if (DBConnection.open()) {
				String sqlQuery = "INSERT INTO ACCOUNT " + "(userName, pass, roles, fullName, age, gender, phoneNumber) VALUES " + "(?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, account.getUserName());
				preparedStatement.setString(2, account.getPass());
				preparedStatement.setString(3, account.getRoles());
				preparedStatement.setString(4, account.getFullName());
				preparedStatement.setInt(5, account.getAge());
				preparedStatement.setString(6, account.getGender());
				preparedStatement.setString(7, account.getPhoneNumber());
				preparedStatement.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close();
		}
	}
	
	
	public ArrayList<Account> getUserNamePassword(String userName, String pass) {
		ArrayList<Account> result = new ArrayList<Account>();
		try {
			if (DBConnection.open()) {
				String sqlQuery = "SELECT * FROM ACCOUNT WHERE userName = ? AND pass = ?";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, userName); 
				preparedStatement.setString(2, pass);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Account account = new Account(resultSet);
					result.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	
	
	public boolean bookingRooms(HotelRooms hotelRooms) {
		try {
			if (DBConnection.open()) {
				String sqlQuery = "UPDATE HOTELROOMS SET userBooked = ?, dateIn = ?, dateOut = ? WHERE roomId = ?";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, hotelRooms.getUserBooked());
				preparedStatement.setString(2, hotelRooms.getDateIn());
				preparedStatement.setString(3, hotelRooms.getDateOut());
				preparedStatement.setInt(4, hotelRooms.getRoomId());
				preparedStatement.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close();
		}
	}
	public boolean setRoles(Account account) {
		try {
			if (DBConnection.open()) {
				String sqlQuery = "UPDATE ACCOUNT SET roles = ? WHERE userName = ?";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, account.getRoles());
				preparedStatement.setString(2, account.getUserName());
				preparedStatement.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close();
		}
	}
}
