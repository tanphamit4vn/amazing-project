package JavaAssignment.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelRooms {
	private int roomId;
	private String statusRoom;
	private String userBooked;
	private String dateIn;
	private String dateOut;
	
	
	
	public HotelRooms(ResultSet resultSet) {
		try {
			roomId = resultSet.getInt("roomId");
			statusRoom = resultSet.getString("statusRoom");
			userBooked = resultSet.getString("userBooked");
			dateIn = resultSet.getString("dateIn");
			dateOut = resultSet.getString("dateOut");
		} catch (SQLException e) {
			System.out.println("HotelRooms - ResultSet Error: " + e.getMessage());
		}
	}
	
	
	
	public HotelRooms() {
		super();
	}
	public HotelRooms(int roomId, String statusRoom, String userBooked, String dateIn, String dateOut) {
		super();
		this.roomId = roomId;
		this.statusRoom = statusRoom;
		this.userBooked = userBooked;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
	}
	public HotelRooms(int roomId, String dateIn, String dateOut, String userBooked) {
		super();
		this.roomId = roomId;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.userBooked = userBooked;
	}
	public HotelRooms(int roomId, String dateIn, String dateOut) {
		super();
		this.roomId = roomId;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
	}
	public HotelRooms(int roomId, String statusRoom) {
		super();
		this.roomId = roomId;
		this.statusRoom = statusRoom;
	}



	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getStatusRoom() {
		return statusRoom;
	}
	public void setStatusRoom(String statusRoom) {
		this.statusRoom = statusRoom;
	}
	public String getUserBooked() {
		return userBooked;
	}
	public void setUserBooked(String userBooked) {
		this.userBooked = userBooked;
	}
	public String getDateIn() {
		return dateIn;
	}
	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}
	public String getDateOut() {
		return dateOut;
	}
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	
	
	
	@Override
	public String toString() {
		return "HoteRooms [roomId=" + roomId + ", status=" + statusRoom + ", userBooked=" + userBooked + ", dateIn="
				+ dateIn + ", dateOut=" + dateOut + "]";
	}
	
}
