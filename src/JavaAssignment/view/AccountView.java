package JavaAssignment.view;

import java.util.ArrayList;
import java.util.Scanner;

import JavaAssignment.model.Account;

public class AccountView {
	private Scanner scanner;

	public AccountView() {
		scanner = new Scanner(System.in);
	}

	public void showAll(ArrayList<Account> accountList) {
		System.out.println("-----------SHOW ALL-----------");
		for (Account account : accountList) {
			System.out.println(account);
		}
		System.out.println();
	}
	
	public void showRoles(ArrayList<Account> accountList) {
		for (Account account : accountList) {
			System.out.println("You are: " +account.getRoles());;
		}
	}

	public Account newCustomerAccount() {
		System.out.println("-----------NEW ACCOUNT-----------");
		
		System.out.print("userName: ");
		String userName = scanner.nextLine();
		
		System.out.print("pass: ");
		String pass = scanner.nextLine();
		
		String roles = "customer";
		
		System.out.print("fullName: ");
		String fullName = scanner.nextLine();
		
		System.out.print("age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("gender: ");
		String gender = scanner.nextLine();
		
		System.out.print("phoneNumber: ");
		String phoneNumber = scanner.nextLine();
		
		Account account = new Account(userName, pass, roles, fullName, age, gender, phoneNumber);
		return account;
	}
	
	public Account createNewUser() {
		System.out.println("-----------NEW ACCOUNT-----------");
		
		System.out.print("userName: ");
		String userName = scanner.nextLine();
		
		System.out.print("pass: ");
		String pass = scanner.nextLine();
		
		System.out.print("roles: ");
		String roles = scanner.nextLine();
		
		System.out.print("fullName: ");
		String fullName = scanner.nextLine();
		
		System.out.print("age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("gender: ");
		String gender = scanner.nextLine();
		
		System.out.print("phoneNumber: ");
		String phoneNumber = scanner.nextLine();
		
		Account account = new Account(userName, pass, roles, fullName, age, gender, phoneNumber);
		System.out.println();
		return account;
	}
	
	public String getUserName() {
		System.out.print("userName: ");
		String userName = scanner.nextLine();
		return userName;
	}
	public String getPassword() {
		System.out.print("password: ");
		String password = scanner.nextLine();
		System.out.println();
		return password;
	}

	public Account setRoles() {
		System.out.print("userName: ");
		String userName = scanner.nextLine();
		
		System.out.print("roles: ");
		String roles = scanner.nextLine();
		
		Account setRoles = new Account(userName, roles);
		System.out.println();
		return setRoles;
	}
}
