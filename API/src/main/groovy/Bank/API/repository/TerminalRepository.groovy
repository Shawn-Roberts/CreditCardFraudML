package Bank.API

import org.springframework.data.repository.CrudRepository;


interface TerminalRepository extends CrudRepository<Terminal,Long>
{
    
}