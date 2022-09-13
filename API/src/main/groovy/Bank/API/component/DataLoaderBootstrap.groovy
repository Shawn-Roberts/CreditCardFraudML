package Bank.API

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Component
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException
import java.sql.SQLException
import java.lang.RuntimeException
import java.lang.Exception
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths

@Component
class DataLoaderBootstrap
{
    private static final String customerProfileCSV = "./sampleData/customers.csv";
    private static final String terminalCSV = "./sampleData/terminals.csv";
    private static final String terminalCSV = "./sampleData/transactions.csv";

    @Autowired
    CustomerRepository customerRepository

    @Autowired
    TerminalRepository terminalRepository

    void loadData()
    {
        try
        {
            Reader reader = Files.newBufferedReader(Paths.get(customerProfileCSV))
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)

            for(CSVRecord customerRecord: csvParser)
            {
                createCustomer(customerRecord)
            }

            reader = Files.newBufferedReader(Paths.get(terminalCSV))
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            

            for(CSVRecord terminalRecord: csvParser)
            {
                createTerminal(terminalRecord)
            }
        }
        catch(IOException e)
        {
            println(e.getMessage())
        }
        catch(SQLException e)
        {
             println(e.getMessage())
        }
        catch(RuntimeException e)
        {
            println(e.getMessage())
        }
        catch(Exception e)
        {
            println(e.getMessage())
        }

    }

    private Customer createCustomer(CSVRecord customerRecord)
    {
        Customer c = new Customer(customerRecord.get(0),customerRecord.get(1))
        customerRepository.save(c)
        //need to get profile and feed in any transactions belonging to that account

    }

    private Terminal createTerminal(CSVRecord terminalRecord)
    {
        Terminal t = new Terminal(terminalRecord.get(0),terminalRecord.get(1))
        terminalRepository.save(t)

    }
}