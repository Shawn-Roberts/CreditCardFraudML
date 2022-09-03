pacakge Bank.API

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "CardTransaction")
class CardTransaction
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id


    Double amount
    Double time_seconds
    Double time_days


}