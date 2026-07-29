package github.com.Erick_Andrade.contact_manager_api.service;

import github.com.Erick_Andrade.contact_manager_api.entity.Contact;
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

}
