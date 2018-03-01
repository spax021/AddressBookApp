package book.service;

import org.springframework.data.domain.Page;

import book.model.Contact;

public interface ContactService {

    Contact findOneById(Long id);
    Page<Contact> findAll(int page);
    Contact save(Contact contact);
    void remove(Long id) throws IllegalArgumentException;
    Page<Contact> findByFirstName(String firstname, int page);
    Page<Contact> findByLastName(String lastname, int page);
    Page<Contact> findByContGroup(String group, int page);
}
