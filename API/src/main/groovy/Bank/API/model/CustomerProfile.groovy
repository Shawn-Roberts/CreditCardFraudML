package Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.ManyToMany;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "CustomerProfile_Terminal",
        joinColumns = @JoinColumn(name = "profile_id"), 
        inverseJoinColumns = @JoinColumn(name = "terminal_id")
    )
    private Set<Terminal> terminals = new HashSet<>()
    
    private Double x = 0.0
    private Double y = 0.0
    private Double stdAmount = 0.0
    private Double meanAmount = 0.0
    private Double meanNumberOfTransactionsPerDay = 0.0

    // add factory method

    //add getters and setters

}