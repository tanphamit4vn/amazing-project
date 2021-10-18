package JavaAssignment.controller;

import java.util.ArrayList;
import java.util.Scanner;

import JavaAssignment.dao.AccountDAO;
import JavaAssignment.dao.HotelRoomsDAO;
import JavaAssignment.model.Account;
import JavaAssignment.model.HotelRooms;
import JavaAssignment.view.AccountView;
import JavaAssignment.view.HotelRoomsView;

public class AccountController {
	private AccountDAO accountDao;
	private AccountView accountView;
	public int n;

	public AccountController() {
		accountDao = new AccountDAO();
		accountView = new AccountView();
		
	}

	public void showAll() {
		ArrayList<Account> accountList = accountDao.getAll();
		if (accountList != null && !accountList.isEmpty()) {
			accountView.showAll(accountList);
		}
	}
	public void showListToSetRoles() {
		ArrayList<Account> accountList = accountDao.getListToSetRoles();
		if (accountList != null && !accountList.isEmpty()) {
			accountView.showAll(accountList);
		}
	}
	

	public void newCustomerAccount() {
		Account account = accountView.newCustomerAccount();
		if (account != null) {
			accountDao.customerRegister(account);
			System.out.println("Register successfully!");
			System.out.println();
		}
	}
	
	public void createNewUser() {
		Account account = accountView.createNewUser();
		if (account != null) {
			accountDao.customerRegister(account);
		}
	}
	
	public void setRoles() {
		Account account = accountView.setRoles();
		if (account != null) {
			accountDao.setRoles(account);
		}
	}
	
	public int login() {
		System.out.println("-----------LOGIN-----------");
		String user = accountView.getUserName();
		String pass = accountView.getPassword();

		ArrayList<Account> account = accountDao.getUserNamePassword(user, pass);
		accountView.showRoles(account);
		
		for (Account test : account) {
			if( test.getRoles().equals("customer")) {// YOU ARE CUSTOMER!------------
				n = 1;
			}else if( test.getRoles().equals("clerk") ) {//YOU ARE HOTEL CLERK!------------
				n = 2;
			} else if( test.getRoles().equals("admin") ) {// YOU ARE ADMIN!------------
				n = 3;
			}else {
				n = 4;
			}
		}
		return n;
	}
}
