package book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

    Page<Contact> findAll(Pageable pageable);
    Page<Contact> findByFirstNameLike(String firstname, Pageable pageable);
    Page<Contact> findByLastNameLike(String lastname, Pageable pageable);
    Page<Contact> findByContGroupLike(String group, Pageable pageable);
    
}
