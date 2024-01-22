import java.util.*;


public class PhoneBookAdmin extends User implements PhoneBookAdminInterface {
	// initializing member variables for Phone Book Admin class
	private String username;
	private String password;
	private PhoneBookDirectory phoneBD = new PhoneBookDirectory();
	private String emailAddress;
	static Scanner sc = new Scanner(System.in);
	
	// Overriding Methods
	@Override
	public void PrintUserInfo() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(phoneBD);
		System.out.println(emailAddress);
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
	public int deleteEntry(String firstName, String lastName) {
		for (PhoneBookEntry i: phoneBD.getTest()) {
			if (i.getFirstName().equals(firstName) && i.getLastName().equals(lastName)) {
				i.setFirstName(null);
				i.setLastName(null);
				i.setId(0);
				i.setEmail(null);
				i.setZipCode(null);
				i.setPhoneNumber(null);
				
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
	@Override
	public PhoneBookEntry binarySearchById(int id) {
	    PhoneBookEntry[] entries = phoneBD.getTest();

	    if (entries == null || entries.length == 0) {
	        System.out.println("PhoneBookDirectory is empty or not initialized.");
	        return new PhoneBookEntry();
	    }
		
		int low = 0;
		int high = phoneBD.getTest().length - 1;
		while (high >= low) {
			int mid = (low + high) / 2;
	        PhoneBookEntry midEntry = entries[mid];

	        if (midEntry == null) {
	            System.out.println("Null entry found at index " + mid + ".");
	            return new PhoneBookEntry();
	        }
			if (id < phoneBD.getTest()[mid].getId()) {
				high = mid - 1;
			} else if (id == phoneBD.getTest()[mid].getId()) {
				return phoneBD.getTest()[mid];
			} else {
				low = mid + 1;
			}
		}
		return new PhoneBookEntry();
	}
	@Override
	public void printAdminInfo() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(phoneBD);
		System.out.println(emailAddress);
		
	}
	@Override
	public void changePassword(String newPassword) {
		this.password=newPassword;
		
	}
	@Override
	public void changeUsername(String newUsername) {
		this.username=newUsername;
		
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
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
}
