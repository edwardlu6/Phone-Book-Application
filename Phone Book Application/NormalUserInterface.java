
public interface NormalUserInterface {
	
	// The four methods for Normal Users
	int addEntry(PhoneBookEntry entry);

    int editEntry(String firstName, String lastName);
    
    void sortPhoneBook();
    
    int linearSearchByPhoneNumber(String phoneNumber);
    

	
}
