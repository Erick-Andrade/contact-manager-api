package github.com.Erick_Andrade.contact_manager_api.controller;

import github.com.Erick_Andrade.contact_manager_api.entity.Contact;
import github.com.Erick_Andrade.contact_manager_api.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @GetMapping
    public List<Contact> findAll() {
        return contactService.findAll();
    }

}
