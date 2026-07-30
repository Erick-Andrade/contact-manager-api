package github.com.Erick_Andrade.contact_manager_api.service;

import github.com.Erick_Andrade.contact_manager_api.entity.Contact;
import github.com.Erick_Andrade.contact_manager_api.excepetion.ContactNotFoundException;
import github.com.Erick_Andrade.contact_manager_api.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @Test
    void shouldCreateContact() {
        Contact contact = new Contact(null, "João Silva", "joao@gmail.com", "11999999999");
        Contact savedContact = new Contact(1L, "João Silva", "joao@email.com", "11999999999");

        when(contactRepository.save(contact)).thenReturn(savedContact);

        Contact result = contactService.create(contact);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("João Silva");
        verify(contactRepository).save(contact);
    }

    @Test
    void shouldReturnAllContacts(){
        Contact contact1 = new Contact(1L, "João", "joao@email.com", "11999999999");
        Contact contact2 = new Contact(2L, "Maria", "maria@email.com", "11988888888");
        when(contactRepository.findAll()).thenReturn(List.of(contact1, contact2));
        List<Contact> result = contactService.findAll();
        assertThat(result).hasSize(2);
        assertThat(result).contains(contact1, contact2);
    }

    @Test
    void shouldReturnContactWhenIdExits() {
        Contact contact = new Contact(1L, "João", "joao@email.com", "11999999999");
        when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
        Contact result = contactService.findById(1L);
        assertThat(result.getName()).isEqualTo("João");
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExist() {
        when(contactRepository.findById(9999L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> contactService.findById(9999L))
                .isInstanceOf(ContactNotFoundException.class)
                .hasMessage("Contact not found with id: 9999");
    }

    @Test
    void shouldUpdateContact() {
        Contact existingContact = new Contact(1L, "João", "joao@email.com", "11999999999");
        Contact updatedData = new Contact(null, "João Souza", "joao.souza@email.com", "11988888888");

        when(contactRepository.findById(1L)).thenReturn(Optional.of(existingContact));
        when(contactRepository.save(any(Contact.class))).thenReturn(existingContact);

        Contact result = contactService.update(1L, updatedData);

        assertThat(result.getName()).isEqualTo("João Souza");
        assertThat(result.getEmail()).isEqualTo("joao.souza@email.com");
        assertThat(result.getPhone()).isEqualTo("11988888888");
    }

    @Test
    void shouldDeleteContact() {
        Contact contact = new Contact(1L, "João", "joao@email.com", "11999999999");
        when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
        contactService.delete(1L);
        verify(contactRepository).delete(contact);
    }



}
