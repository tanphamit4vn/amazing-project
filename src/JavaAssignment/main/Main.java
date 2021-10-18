package JavaAssignment.main;

import java.util.Scanner;

import JavaAssignment.controller.AccountController;
import JavaAssignment.controller.HotelRoomsController;

public class Main {
	public static int menu() {
		System.out.println("-----------WELCOME! -----------");
		System.out.println("1. Register account.");
		System.out.println("2. Login.");
		System.out.println("3. Exit.");
		System.out.print("You want: ");
		Scanner scanner = new Scanner(System.in);
		int userChoise = scanner.nextInt();
		System.out.println();
		return userChoise;
        
	}
	public static void CustomerMenu() {
		System.out.println("----------- HELLO OUR CUSTOMER-----------");
		System.out.println();
	}
	public static int ClerkMenu() {
		System.out.println("----------- CLERK MENU-----------");
		System.out.println("1. View all of rooms.");
		System.out.println("2. Search/filter rooms.");
		System.out.println("3. Update status of rooms.");
		System.out.println("4. Exit.");
        System.out.print("Choosing: ");
        Scanner scanner = new Scanner(System.in);
        int clerkChoise = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return clerkChoise;
	}
	public static int ClerkSearchMenu() {
		System.out.println("----------- CLERK MENU-----------");
		System.out.println("SEARCH/ FILTER ROOMS:");
		System.out.println("1. Search room by ID.");
		System.out.println("2. Filter empty rooms.");
		System.out.println("3. Filter by user booked.");
		System.out.println("4. Filter by date in.");
		System.out.println("5. Filter by date out.");
		System.out.print("Choosing: ");
        Scanner scanner = new Scanner(System.in);
        int userChoise = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return userChoise;
	}
	public static int AdminMenu() {
		System.out.println("----------- ADMIN MENU-----------");
		System.out.println("1. Create new user.");
		System.out.println("2. Set Role.");
		System.out.println("3. Exit.");
        System.out.print("Choosing: ");
        Scanner scanner = new Scanner(System.in);
        int userChoise = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return userChoise;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountController accountController = new AccountController();
		HotelRoomsController hotelRoomsController = new HotelRoomsController();
		
		
		while (true) {
			int userChoise = menu();
			switch (userChoise) {
				case 1: 	// --------------- REGISTER ACCOUNT ---------------
					accountController.newCustomerAccount();	
					break;
					
				case 2: 	// --------------- LOGIN ACCOUNT ---------------
					int test2 = accountController.login();
					if( test2 == 1) {	// --------------- YOU ARE CUSTOMER ---------------
						CustomerMenu();
						hotelRoomsController.showEmptyRooms();
						
						System.out.println("-----------BOOKING ROOMS-----------");
						System.out.print("Emter number of rooms:");
						int number = scanner.nextInt();
						for (int i=0; i<number; i++) {
							hotelRoomsController.bookingRooms();
						}
						break;
						
						
					} else if (test2 == 2) {// --------------- YOU ARE HOTEL CLERK ---------------
						while (test2 ==2) {
							int clerkChoise1 = ClerkMenu();
							switch (clerkChoise1) {
							
							case 1:	//1. View all of rooms.
								hotelRoomsController.showAll();
								break;
								
							case 2:	//2. Search/filter rooms.
								int clerkChoise2 = ClerkSearchMenu();
								switch (clerkChoise2) {
									case 1: //1. Search room by ID
										hotelRoomsController.showRoomById();
										break;
									
									case 2: //2. Filter empty rooms.
										hotelRoomsController.showEmptyRooms();
										break;
																	
									case 3: //3. Filter by user booked.
										hotelRoomsController.showRoomByUserBooked();
										break;
									
									case 4: //4. Filter by date in.
										hotelRoomsController.showRoomByDateIn();
										break;
									
									case 5: //5. Filter by date out.
										hotelRoomsController.showRoomByDateOut();
										break;
								default:
									throw new IllegalArgumentException("Unexpected value: " + clerkChoise2);
								}
								break;
							
							case 3:	//3. Update status of rooms.
								hotelRoomsController.updateStatusRooms();
								break;
								
							case 4:	//4. Exit.
								System.exit(0);
								break;
							default:
								throw new IllegalArgumentException("Unexpected value: " + clerkChoise1);
							}
						}
						
						
					} else if (test2 == 3){			// --------------- YOU ARE ADMIN ---------------
						while (true) {
							int adminChoise = AdminMenu();
							switch (adminChoise) {
							case 1: //1. Create new user.
								accountController.createNewUser();
								break;
								
							case 2: //2. Set Role.
								accountController.showListToSetRoles();
								
								System.out.println("-----------SET ROLE FOR ACCOUNT-----------");
								System.out.print("Emter the number of people:");
								int number = scanner.nextInt();
								for (int i=0; i<number; i++) {
									accountController.setRoles();
								}
								break;
								
							case 3:	//3. Exit.
								System.exit(0);
								break;
								
							default:
								throw new IllegalArgumentException("Unexpected value: " + adminChoise);
							}
						}
					} else {
						System.out.println("User or Password is wrong. Please try againt!");
						System.out.println();
					}
					break;
				case 3:
					System.exit(0);
			}
		}
	}
}
