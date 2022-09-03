package Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.CascadeType

@Entity(name="Customer")
class Customer
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id
    String firstName
    String lastName

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CustomerProfile_id", referencedColumnName ="id")
    // will be switching to factory method
    private CustomerProfile CustomerProfile 

    // add factory methods

    Customer(firstName,lastName)
    {
        this.firstName = firstName
        this.lastName = lastName
        createCustomerProfile()
    }


    //add getters and setters
    String toString()
    {
        return firstName
    }

    private void createCustomerProfile()
    {
        this.CustomerProfile = new CustomerProfile()
    }

}