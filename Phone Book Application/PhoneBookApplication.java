import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class PhoneBookApplication {

	static Scanner sc = new Scanner(System.in);
	static PhoneBookAdmin object1 = new PhoneBookAdmin();
	static NormalUser object2 = new NormalUser();

	public static void main(String[] args) {

		// Read Phone Book Admin's txt document
		String fileName = "src/Phone_Book_Admin.txt";

		String line = null;

		String[] word = new String[3];

		try {

			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				word = line.split(",");

			}
			for (int i = 0; i < 3; i++) {
				object1.setUsername(word[0]);
				object1.setPassword(word[1]);
				object1.setEmailAddress(word[2]);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {

			System.out.println("file not found");
		} catch (IOException ex) {

			System.out.println("IO Exception");
			ex.printStackTrace();

		}

		// Read Normal User's txt document
		fileName = "src/Normal_Info.txt";
		line = null;
		word = new String[3];
		try {

			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				word = line.split(",");

			}

			int intID = Integer.parseInt(word[0]);
			for (int i = 0; i < 3; i++) {
				object2.setId(intID);
				object2.setUsername(word[1]);
				object2.setPassword(word[2]);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {

			System.out.println("file not found");
		} catch (IOException ex) {

			System.out.println("IO Exception");
			ex.printStackTrace();

		}

		// Ask User's information
		int choice = 0; // initialize 'choice' variable to use in menu part later.
		int exit = 0;
		System.out.println("To log in, enter your user name: ");
		String inputUsername = sc.nextLine();
		System.out.println("Enter your password: ");
		String inputPassword = sc.nextLine();

		// Normal User's Menu

		if (inputUsername.equals(object2.getUsername()) && inputPassword.equals(object2.getPassword())) {
			do {
				System.out.println("Hello users! Please choose an option: ");
				System.out.println("1.Add a phone entry");
				System.out.println("2.Edit a phone entry of a given first name and last name");
				System.out.println("3.Sort the PhoneBookDirectory");
				System.out.println("4.Search using Linear Search");
				System.out.println("5.Print user’s info");
				System.out.println("6.Exit");
				choice = sc.nextInt();
				sc.nextLine();
				if (choice == 1) {
					System.out.println("Please Enter a first name: ");
					String firstN = sc.nextLine();
					System.out.println("Please Enter a last name: ");
					String lastN = sc.nextLine();
					System.out.println("Please Enter an id: ");
					int id = sc.nextInt();
					System.out.println("Please Enter an email: ");
					sc.nextLine();
					String email = sc.nextLine();
					System.out.println("Please Enter a zip code: ");
					String zipCode = sc.nextLine();
					System.out.println("Please Enter a phone number: ");
					String phone = sc.nextLine();

					PhoneBookEntry entry = new PhoneBookEntry(lastN, firstN, id, email, zipCode, phone);
					object2.addEntry(entry);// Error------------------------------------------
				} else if (choice == 2) { // Edit a phone entry
					System.out.println("Enter the first name of the entry to edit:");
					String editFirstName = sc.nextLine();

					System.out.println("Enter the last name of the entry to edit:");
					String editLastName = sc.nextLine();

					int result = object2.editEntry(editFirstName, editLastName);

					if (result == 1) {
						System.out.println("Entry edited successfully!");
					} else {
						System.out.println("Entry not found. Unable to edit.");
					}

				} else if (choice == 3) { // sort Phone Book Directory
					object2.sortPhoneBook();
					System.out.println("PhoneBookDirectory has been sorted successfully!");

				} else if (choice == 4) { // linear search method
					System.out.println("Enter the phone number to search:");
					String searchPhoneNumber = sc.nextLine();

					int result = object2.linearSearchByPhoneNumber(searchPhoneNumber);

					if (result == 1) {
						System.out.println("Phone number found in the PhoneBookDirectory!");
					} else {
						System.out.println("Phone number not found in the PhoneBookDirectory.");
					}

				} else if (choice == 5) { // print normal user's info
					object2.PrintUserInfo();

				} else if (choice == 6) {
					exit++;
					System.out.println("Thanks for using!");

				} else {
					System.out.println("Invalid Choice");
				}
			} while (exit != 1);
		}
		// Phone Book Admin's Menu
		else if (inputUsername.equals(object1.getUsername()) && inputPassword.equals(object1.getPassword())) {
			do {
				System.out.println("Hello Phone Book Admin! Please choose an option: ");
				System.out.println("1.Add a phone entry");
				System.out.println("2.Edit a phone entry of a given first name and last name");
				System.out.println("3.Delete a phone entry of a given first name and last name");
				System.out.println("4.Sort the PhoneBookDirectory");
				System.out.println("5.Search using Linear Search");
				System.out.println("6.Search using Binary Search");
				System.out.println("7.Print Admin’s info");
				System.out.println("8.Change Password");
				System.out.println("9.Change Username");
				System.out.println("10.Exit");
				choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("—New phone entry—");

					System.out.println("Please enter the first name:");
					sc.nextLine();
					String firstName = sc.nextLine();

					System.out.println("Please enter the last name:");
					String lastName = sc.nextLine();

					System.out.println("Please enter the ID:");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.println("Please enter the email address:");
					String email = sc.nextLine();

					System.out.println("Please enter the zip code:");
					String zipCode = sc.nextLine();

					System.out.println("Please enter the phone number:");
					String phoneNumber = sc.nextLine();

					// new PhoneBookEntry
					PhoneBookEntry entry = new PhoneBookEntry(firstName, lastName, id, email, zipCode, phoneNumber);

					int result = object1.addEntry(entry);

					if (result == 1) {
						System.out.println("New entry added successfully!");
					} else {
						System.out.println("Unable to add new entry. PhoneBookDirectory may be full.");
					}
				} else if (choice == 2) {

					System.out.println("Enter the first name of the entry to edit:");
					sc.nextLine();
					String editFirstName = sc.nextLine();

					System.out.println("Enter the last name of the entry to edit:");
					String editLastName = sc.nextLine();

					int result = object1.editEntry(editFirstName, editLastName);

					if (result == 1) {
						System.out.println("Entry edited successfully!");
					} else {
						System.out.println("Entry not found. Unable to edit.");
					}
				}

				else if (choice == 3) {
					System.out.println("Enter the first name of the entry to delete:");
					sc.nextLine();
					String deleteFirstName = sc.nextLine();

					System.out.println("Enter the last name of the entry to delete:");
					String deleteLastName = sc.nextLine();

					int result = object1.deleteEntry(deleteFirstName, deleteLastName);

					if (result == 1) {
						System.out.println("Entry deleted successfully!");
					} else {
						System.out.println("Entry not found. Unable to delete.");
					}

				} else if (choice == 4) {
					object1.sortPhoneBook();
					System.out.println("PhoneBookDirectory has been sorted successfully!");

				} else if (choice == 5) {
					System.out.println("Enter the phone number to search:");
					sc.nextLine();
					String searchPhoneNumber = sc.nextLine();

					int result = object1.linearSearchByPhoneNumber(searchPhoneNumber);

					if (result == 1) {
						System.out.println("Phone number found in the PhoneBookDirectory!");
					} else {
						System.out.println("Phone number not found in the PhoneBookDirectory.");
					}

				} else if (choice == 6) {
					System.out.println("Enter the ID to search:");
					int searchId = sc.nextInt();
					sc.nextLine(); // Consume the newline character left in the buffer

					PhoneBookEntry resultEntry = object1.binarySearchById(searchId);

					if (resultEntry.getId() != 0) {
						System.out.println("Entry found in the PhoneBookDirectory:");
						System.out.println(resultEntry); // Assuming you have a toString method in PhoneBookEntry
					} else {
						System.out.println("Entry not found in the PhoneBookDirectory.");
					}

				} else if (choice == 7) {
					object1.printAdminInfo();

				} else if (choice == 8) {
					System.out.println("Enter the new password:");
					sc.nextLine();
					String newPassword = sc.nextLine();

					object1.changePassword(newPassword);
					System.out.println("Password changed successfully!");

				} else if (choice == 9) {
					System.out.println("Enter the new username:");
					sc.nextLine();
					String newUsername = sc.nextLine();

					object1.changeUsername(newUsername);
					System.out.println("Username changed successfully!");

				} else if (choice == 10) {
					exit++;
					System.out.println("Thanks for using!");
				} else {
					System.out.println("Invalid Choice");
				}
			} while (exit != 1);

		} else {
			System.out.println("Invalid login");
		}

	}

}
