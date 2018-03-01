package book.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import book.model.Contact;
import book.service.ContactService;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Contact>> getContacts(
            @RequestParam(value="firstname", required=false) String firstname,
            @RequestParam(value="lastname", required=false) String lastname,
            @RequestParam(value="contgroup", required=false) String contgroup,
            @RequestParam(value="page", required=true) int page){
        List<Contact> contacts = new ArrayList<>();
        
        int totalPages = 0;
        long totalElements = 0;
        
        if(firstname != null) {
            Page<Contact> contactsPage = contactService.findByFirstName(firstname, page);
            for(Contact c : contactsPage) {
                contacts.add(new Contact(c));
            }
            totalPages = contactsPage.getTotalPages();
            totalElements = contactsPage.getTotalElements();
        }
        else if(firstname == null && lastname != null) {
            Page<Contact> contactsPage = contactService.findByLastName(lastname, page);
            for(Contact c : contactsPage) {
                contacts.add(new Contact(c));
            }
            totalPages = contactsPage.getTotalPages();
            totalElements = contactsPage.getTotalElements();
        }
        else if(contgroup != null) {
            Page<Contact> contactsPage = contactService.findByContGroup(contgroup, page);
            for(Contact c : contactsPage) {
                contacts.add(new Contact(c));
            }
            totalPages = contactsPage.getTotalPages();
            totalElements = contactsPage.getTotalElements();
        }
        else {
            Page<Contact> contactsPage = contactService.findAll(page);
            for(Contact c : contactsPage){
                contacts.add(new Contact(c));
            }
            totalPages = contactsPage.getTotalPages();
            totalElements = contactsPage.getTotalElements();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("total-pages", "" + totalPages);
        httpHeaders.add("total-elements", "" + totalElements);

        return new ResponseEntity<>(contacts, httpHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable Long id){
        Contact contact = contactService.findOneById(id);
        if(contact == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Contact(contact), HttpStatus.OK);
    }
    
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteContact(@PathVariable Long id){
        Contact contact = contactService.findOneById(id);
        if(contact != null){
            contactService.remove(id);
            return new ResponseEntity<>(new Contact(contact), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        
        Contact con = new Contact();
        con.setId(contact.getId());
        con.setFirstName(contact.getFirstName());
        con.setLastName(contact.getLastName());
        con.setAddrPrivate(contact.getAddrPrivate());
        con.setAddrBusiness(contact.getAddrBusiness());
        con.setCity(contact.getCity());
        con.setProvince(contact.getProvince());
        con.setZipcode(contact.getZipcode());
        con.setNumberPrivate(contact.getNumberPrivate());
        con.setNumberBusiness(contact.getNumberBusiness());
        con.setNumberFax(contact.getNumberFax());
        con.setMailAddrPrivate(contact.getMailAddrPrivate());
        con.setMailAddrBusiness(contact.getMailAddrBusiness());
        con.setAge(contact.getAge());
        con.setContGroup(contact.getContGroup());
        con.setInfo(contact.getInfo());
        
        Contact persistedContact = contactService.save(con);
        
        return new ResponseEntity<>(new Contact(persistedContact), HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes="application/json")
    public ResponseEntity<Contact> editContact(@PathVariable Long id, @RequestBody Contact contact){
        
        if(contactService.findOneById(id) != null){
            if(id != contact.getId()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            Contact con = contactService.findOneById(id);
            con.setId(contact.getId());
            con.setFirstName(contact.getFirstName());
            con.setLastName(contact.getLastName());
            con.setAddrPrivate(contact.getAddrPrivate());
            con.setAddrBusiness(contact.getAddrBusiness());
            con.setCity(contact.getCity());
            con.setProvince(contact.getProvince());
            con.setZipcode(contact.getZipcode());
            con.setNumberPrivate(contact.getNumberPrivate());
            con.setNumberBusiness(contact.getNumberBusiness());
            con.setNumberFax(contact.getNumberFax());
            con.setMailAddrPrivate(contact.getMailAddrPrivate());
            con.setMailAddrBusiness(contact.getMailAddrBusiness());
            con.setAge(contact.getAge());
            con.setContGroup(contact.getContGroup());
            con.setInfo(contact.getInfo());
            
            Contact persistedContact = contactService.save(con);
            return new ResponseEntity<>(new Contact(persistedContact), HttpStatus.OK);
        }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
