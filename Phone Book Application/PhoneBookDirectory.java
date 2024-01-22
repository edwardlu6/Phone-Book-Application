import java.util.*;


public class PhoneBookDirectory {
	
	// member variables
	private PhoneBookEntry[] test;
	static Scanner sc = new Scanner(System.in);
	public PhoneBookDirectory() {
		test = new PhoneBookEntry[6];
	}

	// Getter/Setter for 'test' variable
	public PhoneBookEntry[] getTest() {
		return test;
	}

	public void setTest(int index, PhoneBookEntry input) {
		this.test[index] = input;
	}


	// 1. add entry
	public int addEntry(PhoneBookEntry entry) {
		for (int i = 0; i < test.length; i++) {
			if (test[i] == null) {
				test[i] = entry;
				return 1;
			}
		}
		return 0;
	}

	// 2. print all entries
	public  void printAllEntries() {
		for (int i = 0; i < test.length; i++) {
			test[i].printBookEntry();
		}
	}

	// 3. linear search by phone number
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		for (int i = 0; i < test.length; i++) {
			if (test[i].getPhoneNumber().equals(PhoneNumber)) {

				return 1;
			}
		}
		return 0;
	}

	// 4 search by ID using binary search
	public PhoneBookEntry SearchbyIdBinarySearch(int id) {
		int low = 0;
		int high = test.length - 1;
		while (high >= low) {
			int mid = (low + high) / 2;
			if (id < test[mid].getId()) {
				high = mid - 1;
			} else if (id == test[mid].getId()) {
				return test[mid];
			} else {
				low = mid + 1;
			}
		}
		return new PhoneBookEntry();

	}

	// 5 sort all phone book entries
	public void sortPhoneBookEntry() {
	        int n = test.length;

	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;

	            for (int j = i + 1; j < n; j++) {
	                if (test[j].getId() < test[minIndex].getId()) {
	                    minIndex = j;
	                }
	            }

	            // Swap test[i] and test[minIndex]
	            PhoneBookEntry temp = test[i];
	            test[i] = test[minIndex];
	            test[minIndex] = temp;

	        }
	        
	    
	}
	
	// Edit phone book entry based on first name and last name.
	public int Edit(String firstName, String lastName) {
		
		

		for (PhoneBookEntry i: test) {
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
					sc.nextLine(); 
					String newLName = sc.nextLine();
					i.setLastName(newLName);
					
				} else if (choice == 2) {
					System.out.println("Edit the first name");
					 sc.nextLine(); 
					String newFName = sc.nextLine();
					i.setFirstName(newFName);
					
				} else if (choice == 3) {
					System.out.println("Edit the ID");
					 sc.nextLine(); 
					int newID = sc.nextInt();
					i.setId(newID);
					
				} else if (choice == 4) {
					System.out.println("Edit the email");
					 sc.nextLine(); 
					String newEmail = sc.nextLine();
					i.setEmail(newEmail);
				} else if (choice == 5) {
					System.out.println("Edit the zip code");
					sc.nextLine(); 
					String newZipCode = sc.nextLine();
					i.setZipCode(newZipCode);
				} else if (choice == 6) {
					System.out.println("Edit the phone number");
					 sc.nextLine(); 
					String newPhoneNumber = sc.nextLine();
					i.setPhoneNumber(newPhoneNumber);;
				}
				return 1;
			} 
		}
		return 0;

	}
	
	// delete an entry based on given id
	public int DeleteEntry(int id) {
		for (PhoneBookEntry i: test) {
			if (i.getId() == id) {
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

}
