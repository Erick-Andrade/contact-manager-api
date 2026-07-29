package github.com.Erick_Andrade.contact_manager_api.service;

import github.com.Erick_Andrade.contact_manager_api.entity.Contact;
import github.com.Erick_Andrade.contact_manager_api.excepetion.ContactNotFoundException;
import github.com.Erick_Andrade.contact_manager_api.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id).
                orElseThrow(() -> new ContactNotFoundException(id));
    }

    public Contact update(Long id, Contact updatedContact) {
        Contact existingContact = findById(id);
        existingContact.setName(updatedContact.getName());
        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setPhone(updatedContact.getPhone());
        return contactRepository.save(existingContact);
    }

    public void delete(Long id) {
        Contact existingContact = findById(id);
        contactRepository.delete(existingContact);
    }




}
