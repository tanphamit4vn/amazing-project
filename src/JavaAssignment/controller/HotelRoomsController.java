package JavaAssignment.controller;

import java.util.ArrayList;
import java.util.Scanner;

import JavaAssignment.dao.HotelRoomsDAO;
import JavaAssignment.model.HotelRooms;
import JavaAssignment.view.HotelRoomsView;

public class HotelRoomsController {
	private HotelRoomsDAO hotelRoomsDao;
	private HotelRoomsView hotelRoomsView;
	
	
	
	public HotelRoomsController() {
		hotelRoomsDao = new HotelRoomsDAO();
		hotelRoomsView = new HotelRoomsView();
	}
	
	
	
	public void showAll() {
		ArrayList<HotelRooms> hotelRoomList = hotelRoomsDao.getAll();
		if (hotelRoomList != null && !hotelRoomList.isEmpty()) {
			hotelRoomsView.showAll(hotelRoomList);
		}
		System.out.println();
	}
	public void showEmptyRooms() {
		ArrayList<HotelRooms> hotelEmptyRoomList = hotelRoomsDao.getEmptyRooms();
		if (hotelEmptyRoomList != null && !hotelEmptyRoomList.isEmpty()) {
			hotelRoomsView.listEmptyRooms(hotelEmptyRoomList);
		}
	}
	public void showRoomById() {
		int roomId = hotelRoomsView.getRoomById();
		if (roomId >= 0) {
			ArrayList<HotelRooms> hotelRooms = hotelRoomsDao.getRoomById(roomId);
			hotelRoomsView.showAll(hotelRooms);
		}
	}
	public void showRoomByUserBooked() {
		String userBooked = hotelRoomsView.getRoomsByUserBooked();
		if (userBooked != null) {
			ArrayList<HotelRooms> hotelRooms = hotelRoomsDao.getRoomByUserBooked(userBooked);
			hotelRoomsView.showAll(hotelRooms);
		}
	}
	public void showRoomByDateIn() {
		String dateIn = hotelRoomsView.getRoomsByDateIn();
		if (dateIn != null) {
			ArrayList<HotelRooms> hotelRooms = hotelRoomsDao.getRoomByDateIn(dateIn);
			hotelRoomsView.showAll(hotelRooms);
		}
	}
	public void showRoomByDateOut() {
		String dateOut = hotelRoomsView.getRoomsByDateOut();
		if (dateOut != null) {
			ArrayList<HotelRooms> hotelRooms = hotelRoomsDao.getRoomByDateOut(dateOut);
			hotelRoomsView.showAll(hotelRooms);
		}
	}
	
	
	public void bookingRooms() {
		HotelRooms hotelRooms = hotelRoomsView.bookingRooms();
		if (hotelRooms != null) {
			hotelRoomsDao.bookingRooms(hotelRooms);
		}
	}
	
	public void updateStatusRooms() {
		HotelRooms hotelRooms = hotelRoomsView.updateStatusRooms();
		if (hotelRooms != null) {
			hotelRoomsDao.updateStatusRooms(hotelRooms);
		}
	}
	
	
}
