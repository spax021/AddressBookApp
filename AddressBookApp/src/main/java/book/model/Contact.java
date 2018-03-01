package book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblcontact")
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "addrprivate")
    private String addrPrivate;
    
    @Column(name = "addrbusiness")
    private String addrBusiness;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "province")
    private String province;
    
    @Column(name = "zipcode")
    private String zipcode;
    
    @Column(name = "numberprivate")
    private String numberPrivate;
    
    @Column(name = "numberbusiness")
    private String numberBusiness;
    
    @Column(name = "numberfax")
    private String numberFax;
    
    @Column(name = "mailaddrprivate")
    private String mailAddrPrivate;
    
    @Column(name = "mailaddrbusiness")
    private String mailAddrBusiness;
    
    @Column(name = "age")
    private int age;

    @Column(name = "info")
    private String info;

    @Column(name = "contgroup")
    private String contGroup;

    public Long     getId()                                             {return id;}
    public void     setId(Long id)                                      {this.id = id;}
    public String   getFirstName()                                      {return firstName;}
    public void     setFirstName(String firstName)                      {this.firstName = firstName;}
    public String   getLastName()                                       {return lastName;}
    public void     setLastName(String lastName)                        {this.lastName = lastName;}
    public String   getAddrPrivate()                                    {return addrPrivate;}
    public void     setAddrPrivate(String addrPrivate)                  {this.addrPrivate = addrPrivate;}
    public String   getAddrBusiness()                                   {return addrBusiness;}
    public void     setAddrBusiness(String addrBusiness)                {this.addrBusiness = addrBusiness;}
    public String   getCity()                                           {return city;}
    public void     setCity(String city)                                {this.city = city;}
    public String   getProvince()                                       {return province;}
    public void     setProvince(String province)                        {this.province = province;}
    public String   getZipcode()                                        {return zipcode;}
    public void     setZipcode(String zipcode)                          {this.zipcode = zipcode;}
    public String   getNumberPrivate()                                  {return numberPrivate;}
    public void     setNumberPrivate(String numberPrivate)              {this.numberPrivate = numberPrivate;}
    public String   getNumberBusiness()                                 {return numberBusiness;}
    public void     setNumberBusiness(String numberBusiness)            {this.numberBusiness = numberBusiness;}
    public String   getNumberFax()                                      {return numberFax;}
    public void     setNumberFax(String numberFax)                      {this.numberFax = numberFax;}
    public String   getMailAddrPrivate()                                {return mailAddrPrivate;}
    public void     setMailAddrPrivate(String mailAddrPrivate)          {this.mailAddrPrivate = mailAddrPrivate;}
    public String   getMailAddrBusiness()                               {return mailAddrBusiness;}
    public void     setMailAddrBusiness(String mailAddrBusiness)        {this.mailAddrBusiness = mailAddrBusiness;}
    public int      getAge()                                            {return age;}
    public void     setAge(int age)                                     {this.age = age;}
    public String   getInfo()                                           {return info;}
    public void     setInfo(String info)                                {this.info = info;}
    public String   getContGroup()                                          {return contGroup;}
    public void     setContGroup(String contGroup)                              {this.contGroup = contGroup;}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addrBusiness == null) ? 0 : addrBusiness.hashCode());
        result = prime * result + ((addrPrivate == null) ? 0 : addrPrivate.hashCode());
        result = prime * result + age;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((contGroup == null) ? 0 : contGroup.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((mailAddrBusiness == null) ? 0 : mailAddrBusiness.hashCode());
        result = prime * result + ((mailAddrPrivate == null) ? 0 : mailAddrPrivate.hashCode());
        result = prime * result + ((numberBusiness == null) ? 0 : numberBusiness.hashCode());
        result = prime * result + ((numberFax == null) ? 0 : numberFax.hashCode());
        result = prime * result + ((numberPrivate == null) ? 0 : numberPrivate.hashCode());
        result = prime * result + ((province == null) ? 0 : province.hashCode());
        result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (addrBusiness == null) {
            if (other.addrBusiness != null)
                return false;
        } else if (!addrBusiness.equals(other.addrBusiness))
            return false;
        if (addrPrivate == null) {
            if (other.addrPrivate != null)
                return false;
        } else if (!addrPrivate.equals(other.addrPrivate))
            return false;
        if (age != other.age)
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (contGroup == null) {
            if (other.contGroup != null)
                return false;
        } else if (!contGroup.equals(other.contGroup))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (mailAddrBusiness == null) {
            if (other.mailAddrBusiness != null)
                return false;
        } else if (!mailAddrBusiness.equals(other.mailAddrBusiness))
            return false;
        if (mailAddrPrivate == null) {
            if (other.mailAddrPrivate != null)
                return false;
        } else if (!mailAddrPrivate.equals(other.mailAddrPrivate))
            return false;
        if (numberBusiness == null) {
            if (other.numberBusiness != null)
                return false;
        } else if (!numberBusiness.equals(other.numberBusiness))
            return false;
        if (numberFax == null) {
            if (other.numberFax != null)
                return false;
        } else if (!numberFax.equals(other.numberFax))
            return false;
        if (numberPrivate == null) {
            if (other.numberPrivate != null)
                return false;
        } else if (!numberPrivate.equals(other.numberPrivate))
            return false;
        if (province == null) {
            if (other.province != null)
                return false;
        } else if (!province.equals(other.province))
            return false;
        if (zipcode == null) {
            if (other.zipcode != null)
                return false;
        } else if (!zipcode.equals(other.zipcode))
            return false;
        return true;
    }

    public Contact(Contact contact) {
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.addrPrivate = contact.getAddrPrivate();
        this.addrBusiness = contact.getAddrBusiness();
        this.city = contact.getCity();
        this.province = contact.getProvince();
        this.zipcode = contact.getZipcode();
        this.numberPrivate = contact.getNumberPrivate();
        this.numberBusiness = contact.getNumberBusiness();
        this.numberFax = contact.getNumberFax();
        this.mailAddrPrivate = contact.getMailAddrPrivate();
        this.mailAddrBusiness = contact.getMailAddrBusiness();
        this.age = contact.getAge();
        this.contGroup = contact.getContGroup();
        this.info = contact.getInfo();
    }
    
    public Contact(){}
    
    
}