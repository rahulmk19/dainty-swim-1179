package com.masai.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.AdministratorDAO;
import com.masai.DAO.AdministratorDAOimpl;
import com.masai.DAO.VendorDao;
import com.masai.DAO.VendorDaoImpl;
import com.masai.DTO.Tender;
import com.masai.DTO.Vendor;
import com.masai.DTO.VendorImpl;

public class VendorUI {

	public static void option(Scanner scanner, Vendor vendor) {
		System.out.println("Welcome, " + vendor.getVender_name() + "!");
		int choice;
		do {
			System.out.println("****Enter Your Choice****");
			System.out.println("1. View Current Tender Status");
			System.out.println("2. Place Bid against a Tender");
			System.out.println("3. View Bid History");
			System.out.println("4. Update Details of User");
			System.out.println("5. View All Tenders");
			System.out.println("0. Logout");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
//				view_CurrentTender();
				break;
			case 2:
//				Bid_Tender(scanner);
				break;
			case 3:
//				view_Bid_history(scanner);
				break;
			case 4:
				update_vendor(vendor.getVender_id(), scanner);
				break;
			case 5:
				view_Tender();
				break;
			case 6:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 6);

	}

	public static void update_vendor(String vendorId, Scanner scanner) {

		System.out.println("Enter Vendor Name");
		String vender_name = scanner.next();
		System.out.println("Enter Email");
		String email = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		System.out.println("Enter phone");
		String phone = scanner.next();
		System.out.println("Enter address");
		String address = scanner.next();

		Vendor vendorDetails = new VendorImpl(vendorId, password, vender_name, email, phone, address);
		VendorDao vendorDao = new VendorDaoImpl();
		try {
			vendorDao.changeDetailsVendor(vendorDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void view_Tender() {

		List<Tender> list = new ArrayList<>();
		AdministratorDAO adminDao = new AdministratorDAOimpl();

		try {
			list = adminDao.viewAllTenders();
			list.forEach(e -> System.out.println(e));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
