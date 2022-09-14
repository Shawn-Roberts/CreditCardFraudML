package Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity(name = "CardTransaction")
class CardTransaction
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    // @ManyToOne
    // @JoinColumn(name="customerProfile_id", nullable= false)
    // private CustomerProfile customerProfile


    LocalDateTime time 
    Double amount = 0.0
    Long time_seconds = 0
    Long time_days = 0 

    //


}