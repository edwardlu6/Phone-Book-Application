
public interface PhoneBookAdminInterface {

	
	// All the methods for PhoneBookAdmin class
	int addEntry(PhoneBookEntry entry);

    int editEntry(String firstName, String lastName);

    int deleteEntry(String firstName, String lastName);

    void sortPhoneBook();

    int linearSearchByPhoneNumber(String phoneNumber);

    PhoneBookEntry binarySearchById(int id);

    void printAdminInfo();

    void changePassword(String newPassword);

    void changeUsername(String newUsername);    
    

    

}

