package book.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import book.model.Contact;
import book.service.ContactService;
import book.service.impl.JpaContactService;

public class ContactServiceTest {
    
    private ContactService contactService;
    
    @Before
    public void setUp() {
        contactService = new JpaContactService();
        
        Contact contact1 = new Contact();
        contact1.setFirstName("Boris");
        contact1.setLastName("Cvijanovic");
        contact1.setAddrPrivate("Brace Dronjak 13");
        contact1.setNumberPrivate("381631234567");
        contact1.setContGroup("relative");
        
        Contact contact2 = new Contact();
        contact2.setFirstName("Aleksandra");
        contact2.setLastName("Simic");
        contact2.setAddrPrivate("Brace Popovic 12");
        contact2.setNumberPrivate("381632345678");
        contact2.setContGroup("relative");
        
        
        contactService.save(contact1);
        contactService.save(contact2);
    }

    @Test
    public void testFindFirst(){
        Contact contact = contactService.findOneById(0L);
        Assert.assertNotNull(contact);
        Assert.assertEquals("Boris", contact.getFirstName());
        Assert.assertEquals("Cvijanovic", contact.getLastName());
        Assert.assertEquals("Brace Dronjak 13", contact.getAddrPrivate());
        Assert.assertEquals("381631234567", contact.getNumberPrivate());
        Assert.assertEquals("relative", contact.getContGroup());
    }
    
    @Test
    public void testFindSecond(){
        Contact contact = contactService.findOneById(1L);
        Assert.assertNotNull(contact);
        Assert.assertEquals("Aleksandra", contact.getFirstName());
        Assert.assertEquals("Simic", contact.getLastName());
        Assert.assertEquals("Brace Popovic 12", contact.getAddrPrivate());
        Assert.assertEquals("381632345678", contact.getNumberPrivate());
        Assert.assertEquals("relative", contact.getContGroup());
    }
    
//    @Test
//    public void testFindAll(){
//        List<Contact> contacts = contactService.findAll(0);
//        Assert.assertNotNull(contacts);
//        Assert.assertEquals(2, contacts.size());
//        
//    }
}
