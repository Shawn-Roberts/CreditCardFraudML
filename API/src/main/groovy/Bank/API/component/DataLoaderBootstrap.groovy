package Bank.API

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
@Grab('com.xlson.groovycsv:groovycsv:1.3')
import static com.xlson.groovycsv.CsvParser.parseCsv
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
    private static final String customerCSV = "./sampleData/customers.csv"
    private static final String customerProfileCSV = "./sampleData/customer_profiles.csv"
    private static final String terminalCSV = "./sampleData/terminals.csv"
    private static final String transactionsCSV = "./sampleData/transaction_raw.csv"
    private static final String transactionTransformedCSV = "./sampleData/transaction_transformed.csv"

    @Autowired
    CustomerRepository customerRepository

    @Autowired
    CustomerProfileRepository customerProfileRepository

    @Autowired
    TerminalRepository terminalRepository

    void loadData()
    {

        def customerCSV = new File(customerCSV)
        def cutsomterProfileCSV = new File(customerProfileCSV)
        def terminalCSV = new File(terminalCSV)
        def customerContent = customerCSV.getText('utf-8')
        def customerProfileContent = cutsomterProfileCSV.getText('utf-8')
        def terminalContent = terminalCSV.getText('utf-8')

        try(
            customerIterator = parseCsv(customerContent, separator: ',', readFirstLine: false)
            customerProfileIterator = parseCsv(customerProfileContent, separator: ',', readFirstLine: false)
            terminalIterator = parseCsv(terminalContent, separator: ',', readFirstLine: false))
        {
            while (terminalIterator.hasNext())
            {
                createTerminal(terminalIterator.next().toMap())
            }

            while(customerIterator.hasNext())
            {
                if(customerProfileIterator.hasNext())
                {  
                    CustomerProfile temp = createCustomerProfile(customerProfileIterator.next().toMap())
                    createCustomer(customerIterator.next().toMap(), temp)

                }
                else
                {
                    createCustomer(customerIterator.next().toMap())
                }

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

    private Customer createCustomer(HashMap<String,String> customerRecord, CustomerProfile customerProfile)
    {
        Customer c = new Customer(customerRecord.get("firstname"),customerRecord.get("lastname"), customerProfile)
        customerRepository.save(c)
        //need to get profile and feed in any transactions belonging to that account

    }

    private Customer createCustomer(HashMap<String,String> customerRecord)
    {
        Customer c = new Customer(customerRecord.get("firstname"),customerRecord.get("lastname"))
        customerRepository.save(c)
        //need to get profile and feed in any transactions belonging to that account

    }

    private CustomerProfile createCustomerProfile(HashMap<String,String> customerProfileRecord)
    {
        CustomerProfile cp = new CustomerProfile(Double.parseDouble(customerProfileRecord.get("x")),
        Double.parseDouble(customerProfileRecord.get("y")),Double.parseDouble(customerProfileRecord.get("mean_amount")),
        Double.parseDouble(customerProfileRecord.get("std_amount")),Double.parseDouble(customerProfileRecord.get("mean_nb_tx_per_day")))

        return cp
        // customerProfileRepository.save(cp)
        

    }

    private Terminal createTerminal(HashMap<String,String> terminalRecord)
    {
        Terminal t = new Terminal(terminalRecord.get("x"),terminalRecord.get("y"))
        terminalRepository.save(t)
    }
}


            // BufferedReader customerReader = Files.newBufferedReader(Paths.get(customerCSV))
            // CSVParser customerCsvParser = new CSVParser(customerReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())

            // BufferedReader customerProfileReader = Files.newBufferedReader(Paths.get(customerProfileCSV))
            // CSVParser customerProfileCsvParser = new CSVParser(customerProfileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())


            // for(CSVRecord customerRecord: customerCsvParser)
            // {
            //     CustomerProfile cp = createCustomerProfile(customerProfileCsvParser.readNext())
            //     println(cp)
            //     // createCustomer(customerRecord)
            // }