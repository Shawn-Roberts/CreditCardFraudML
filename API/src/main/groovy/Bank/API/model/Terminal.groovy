package Bank.API


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.CascadeType
import javax.persistence.ManyToMany;

@Entity(name = "Terminal")
class Terminal
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    private Double x = 0.0
    private Double y = 0.0

    Terminal(String x,String y)
    {
        this.x = Double.parseDouble(x)
        this.y = Double.parseDouble(y)
    }

    Terminal(Double x, Double y)
    {
        this.x = x
        this.y = y
    }

    //process transaction
    private void processTransaction(customer, datetime, amount)
    {
        //create transaction
        // update customer profile
        
    }



}