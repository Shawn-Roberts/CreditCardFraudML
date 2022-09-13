package Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.OneToMany;
import javax.persistence.CascadeType
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


@Entity(name="CustomerProfile")
class CustomerProfile
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    @OneToOne(mappedBy = "CustomerProfile")
    private Customer customer

    @OneToMany(mappedBy="customerProfile")
    private Set<CardTransaction> transactions;

    private Double x = 0.0
    private Double y = 0.0
    private Double stdAmount = 0.0
    private Double meanAmount = 0.0
    private Double meanNumberOfTransactionsPerDay = 0.0


    //update profile based on transactions
    private void updateProfile()
    {
        //get transaction values and update
    }

    //link to terminals
    private void getTerminalsWithin100GridUnits()
    {
        // get terminals within 100 grid units
    }

    //getters and setters

}