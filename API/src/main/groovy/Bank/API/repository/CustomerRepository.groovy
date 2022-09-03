package Bank.API

import org.springframework.data.repository.CrudRepository;


interface CustomerRepository extends CrudRepository<Customer,Long>
{
    
}