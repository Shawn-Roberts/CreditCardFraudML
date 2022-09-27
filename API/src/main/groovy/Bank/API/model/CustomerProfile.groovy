package Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import javax.persistence.ManyToMany
import javax.persistence.JoinColumn
import javax.persistence.JoinTable



@Entity(name="CustomerProfile")
class CustomerProfile
{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    @OneToOne(mappedBy = "customerProfile")
    private Customer customer

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "customerProfile_Terminals", 
      joinColumns = @JoinColumn(name = "terminal_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "customerProfile_id", 
      referencedColumnName = "id"))
    private List<Terminal> terminals

    @OneToMany(mappedBy="customerProfile")
    private Set<CardTransaction> transactions;





    private Double x = 0.0
    private Double y = 0.0
    private Double stdAmount = 0.0
    private Double meanAmount = 0.0
    private Double meanNumberOfTransactionsPerDay = 0.0

    //constructor
    CustomerProfile(){}

    CustomerProfile(x,y,stdAmount,meanAmount,meanNumberOfTransactionsPerDay)
    {
        this.x = x
        this.y = y
        this.stdAmount = stdAmount
        this.meanAmount = meanAmount
        this.meanNumberOfTransactionsPerDay = meanNumberOfTransactionsPerDay
    }


    //update profile based on transactions
    private void updateProfile()
    {
        //get transaction values and update
    }

    //link to terminals
    void addTerminals(List<Terminal> terminalList)
    {
        this.terminals = terminalList
    }

    private void getTerminalsWithin100GridUnits()
    {
        // get terminals within 100 grid units
    }


    //getters and setters
    Double getX()
    {
        return this.x
    }
    
}