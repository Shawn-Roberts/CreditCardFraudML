package Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime
import javax.persistence.ManyToMany;

@Entity(name = "CardTransaction")
class CardTransaction
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id


    LocalDateTime time 
    Double amount = 0.0
    Long time_seconds 
    Long time_days

    @ManyToMany(mappedBy = "transactions")
    private Set<CustomerProfile> customerProfiles = new HashSet<>()

    //


}