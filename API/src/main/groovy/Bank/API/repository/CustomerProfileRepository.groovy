package Bank.API

import org.springframework.data.repository.CrudRepository;


interface CustomerProfileRepository extends CrudRepository<Customer,Long>
{
    
}