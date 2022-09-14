package Bank.API

import org.springframework.data.repository.CrudRepository;


interface CardTransactionRepository extends CrudRepository<CardTransaction,Long>
{
    
}