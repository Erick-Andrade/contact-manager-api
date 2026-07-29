package github.com.Erick_Andrade.contact_manager_api.repository;

import github.com.Erick_Andrade.contact_manager_api.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
