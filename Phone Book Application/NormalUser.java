import java.util.Scanner;

public class NormalUser extends User implements NormalUserInterface{
	// initializing member variables for normal user class
	private String username;
	private String password;
	private PhoneBookDirectory phoneBD = new PhoneBookDirectory();
	private int id;
	static Scanner sc = new Scanner(System.in);

	// Overriding methods
	@Override
	public void PrintUserInfo() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(phoneBD);
		System.out.println(id);
	}
	@Override
	public int addEntry(PhoneBookEntry entry) {
		for (int i = 0; i < phoneBD.getTest().length; i++) {
			if (phoneBD.getTest()[i] == null) {
				phoneBD.setTest(i,entry);
				return 1;
			}
		}
		return 0;
	}
	@Override
	public int editEntry(String firstName, String lastName) {
		for (PhoneBookEntry i: phoneBD.getTest()) {
			if (i.getFirstName().equals(firstName) && i.getLastName().equals(lastName)) {
				System.out.println("Choose an attribute to edit:(type a number)");
				System.out.println("1.Last Name");
				System.out.println("2.First Name");
				System.out.println("3.ID");
				System.out.println("4.Email");
				System.out.println("5.Zip Code");
				System.out.println("6.Phone Number");
				
				int choice = sc.nextInt();
				sc.nextLine(); 
				
				if (choice == 1) {
					System.out.println("Edit the last name");
					String newLName = sc.nextLine();
					i.setLastName(newLName);
					
				} else if (choice == 2) {
					System.out.println("Edit the first name");
					String newFName = sc.nextLine();
					i.setFirstName(newFName);
					
				} else if (choice == 3) {
					System.out.println("Edit the ID");
					int newID = sc.nextInt();
					sc.nextLine(); 
					i.setId(newID);
					
				} else if (choice == 4) {
					System.out.println("Edit the email");
					String newEmail = sc.nextLine();
					i.setEmail(newEmail);
				} else if (choice == 5) {
					System.out.println("Edit the zip code");
					String newZipCode = sc.nextLine();
					i.setZipCode(newZipCode);
				} else if (choice == 6) {
					System.out.println("Edit the phone number");
					String newPhoneNumber = sc.nextLine();
					i.setPhoneNumber(newPhoneNumber);;
				}
				return 1;
			} 
		}
		return 0;
	}
	@Override
	public void sortPhoneBook() {
		int n = phoneBD.getTest().length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (phoneBD.getTest()[j] != null && phoneBD.getTest()[minIndex] != null && phoneBD.getTest()[j].getId() < phoneBD.getTest()[minIndex].getId()) {
                    minIndex = j;
                }
            }

            // Swap test[i] and test[minIndex]
            PhoneBookEntry temp = phoneBD.getTest()[i];
            phoneBD.getTest()[i] = phoneBD.getTest()[minIndex];
            phoneBD.getTest()[minIndex] = temp;

        }
		
	}
	@Override
	public int linearSearchByPhoneNumber(String phoneNumber) {
		for (int i = 0; i < phoneBD.getTest().length; i++) {
			if (phoneBD.getTest()[i].getPhoneNumber().equals(phoneNumber)) {

				return 1;
			}
		}
		return 0;
	}
	
	// Getters/Setters Section
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
