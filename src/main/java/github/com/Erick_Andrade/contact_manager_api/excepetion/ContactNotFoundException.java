package github.com.Erick_Andrade.contact_manager_api.excepetion;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(Long id) {
        super("Contact not found with id: " + id);
    }
}
