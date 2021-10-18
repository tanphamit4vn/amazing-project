package JavaAssignment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JavaAssignment.connected.DBConnection;
import JavaAssignment.model.HotelRooms;

public class HotelRoomsDAO {
	
	public ArrayList<HotelRooms> getAll() {
		ArrayList<HotelRooms> result = new ArrayList<HotelRooms>();
		try {
			if (DBConnection.open()) {
				Statement statement = DBConnection.getConnection().createStatement();
				String sqlQuery = "SELECT * FROM HOTELROOMS";
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					HotelRooms hotelRooms = new HotelRooms(resultSet);
					result.add(hotelRooms);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	public ArrayList<HotelRooms> getEmptyRooms() {
		ArrayList<HotelRooms> result = new ArrayList<HotelRooms>();
		try {
			if (DBConnection.open()) {
				Statement statement = DBConnection.getConnection().createStatement();
				String sqlQuery = "SELECT * FROM HOTELROOMS WHERE userBooked = 'empty' ";
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				while (resultSet.next()) {
					HotelRooms hotelRooms = new HotelRooms(resultSet);
					result.add(hotelRooms);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	public ArrayList<HotelRooms> getRoomById(int roomId) {
		ArrayList<HotelRooms> result = new ArrayList<HotelRooms>();
		try {
			if (DBConnection.open()) {
				String sqlQuery = "SELECT * FROM HOTELROOMS WHERE roomId = ? ";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setInt(1, roomId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					HotelRooms hotelRooms = new HotelRooms(resultSet);
					result.add(hotelRooms);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	public ArrayList<HotelRooms> getRoomByUserBooked( String userBooked) {
		ArrayList<HotelRooms> result = new ArrayList<HotelRooms>();
		try {
			if (DBConnection.open()) {
				String sqlQuery = "SELECT * FROM HOTELROOMS WHERE userBooked = ? ";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, userBooked);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					HotelRooms hotelRooms = new HotelRooms(resultSet);
					result.add(hotelRooms);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	public ArrayList<HotelRooms> getRoomByDateIn( String dateIn) {
		ArrayList<HotelRooms> result = new ArrayList<HotelRooms>();
		try {
			if (DBConnection.open()) {
				String sqlQuery = "SELECT * FROM HOTELROOMS WHERE dateIn = ? ";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, dateIn);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					HotelRooms hotelRooms = new HotelRooms(resultSet);
					result.add(hotelRooms);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return result;
	}
	public ArrayList<HotelRooms> getRoomByDateOut( String dateOut) {
		ArrayList<HotelRooms> result = new ArrayList<HotelRooms>();
		try {
			if (DBConnection.open()) {
				String sqlQuery = "SELECT * FROM HOTELROOMS WHERE dateOut = ? ";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, dateOut);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					HotelRooms hotelRooms = new HotelRooms(resultSet);
					result.add(hotelRooms);
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
	public boolean updateStatusRooms(HotelRooms hotelRooms) {
		try {
			if (DBConnection.open()) {
				String sqlQuery = "UPDATE HOTELROOMS SET statusRoom = ? WHERE roomId = ?";
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
				preparedStatement.setString(1, hotelRooms.getStatusRoom());
				preparedStatement.setInt(2, hotelRooms.getRoomId());
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
