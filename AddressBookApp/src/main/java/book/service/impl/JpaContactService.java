package book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import book.model.Contact;
import book.repository.ContactRepository;
import book.service.ContactService;

@Transactional
@Service
public class JpaContactService implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public Contact findOneById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Page<Contact> findAll(int page) {
        return contactRepository.findAll(new PageRequest(page, 5));
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void remove(Long id) throws IllegalArgumentException {
        Contact contact = contactRepository.findOne(id);
        if(contact == null) {
            throw new IllegalArgumentException("Tried to remove nonexistant contact id:" + id);
        }
        contactRepository.delete(contact);
    }

    @Override
    public Page<Contact> findByFirstName(String firstname, int page) {
        return contactRepository.findByFirstNameLike("%" + firstname + "%", new PageRequest(page, 5));
    }

    @Override
    public Page<Contact> findByLastName(String lastname, int page) {
        return contactRepository.findByLastNameLike("%" + lastname + "%", new PageRequest(page, 5));
    }

    @Override
    public Page<Contact> findByContGroup(String group, int page) {
        return contactRepository.findByContGroupLike("%" + group + "%", new PageRequest(page, 5));
    }

}
