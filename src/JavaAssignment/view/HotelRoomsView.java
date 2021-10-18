package JavaAssignment.view;

import java.util.ArrayList;
import java.util.Scanner;

import JavaAssignment.model.Account;
import JavaAssignment.model.HotelRooms;

public class HotelRoomsView {
	private Scanner scanner;
	
	public HotelRoomsView() {
		scanner = new Scanner(System.in);
	}
	
	
	public void showAll(ArrayList<HotelRooms> listRooms) {
		System.out.println("-----------ALL LIST ROOMS-----------");
		for (HotelRooms hotelRooms : listRooms) {
			System.out.println(hotelRooms);
		}
		System.out.println();
	}
	public void listEmptyRooms(ArrayList<HotelRooms> listEmptyRooms) {
		System.out.println("-----------LIST EMPTY ROOMS-----------");
		for (HotelRooms hotelRooms : listEmptyRooms) {
			System.out.println(hotelRooms);
		}
		System.out.println();
	}
	public int getRoomById() {
		System.out.println("-----------ROOM INFORMATION-----------");
		System.out.print("roomId: ");
		int roomId = scanner.nextInt();
		scanner.nextLine();
		return roomId;
	}
	public String getRoomsByUserBooked() {
		System.out.println("-----------LIST BOOKED ROOMS BY USER-----------");
		System.out.print("userBooked: ");
		String userBooked = scanner.nextLine();
		return userBooked;
	}
	public String getRoomsByDateIn() {
		System.out.println("-----------LIST ROOMS BY DATE IN-----------");
		System.out.print("dateIn: ");
		String dateIn = scanner.nextLine();
		return dateIn;
	}
	public String getRoomsByDateOut() {
		System.out.println("-----------LIST ROOMS BY DATE OUT-----------");
		System.out.print("dateOut: ");
		String dateOut = scanner.nextLine();
		return dateOut;
	}
	public HotelRooms bookingRooms() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("roomId: ");
		int roomId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("dataIn: ");
		String dateIn = scanner.nextLine();
		
		System.out.print("dataOut: ");
		String dateOut = scanner.nextLine();
		
		System.out.print("userName: ");
		String userBooked =scanner.nextLine();
		
		HotelRooms bookingRooms = new HotelRooms(roomId, dateIn, dateOut, userBooked);
		System.out.println("Booking successfully!");
		System.out.println("Please wait hotel clerk to update your booking!");
		System.out.println();
		return bookingRooms;
	}
	
	public HotelRooms updateStatusRooms() {
		System.out.println("-----------UPDATE STATUS ROOMS-----------");
		System.out.print("roomId: ");
		int roomId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("statusRoom: ");
		String statusRoom = scanner.nextLine();
		
		HotelRooms updateStatusRooms = new HotelRooms(roomId, statusRoom);
		System.out.println("Update status successfully!");
		return updateStatusRooms;
	}
	
}
