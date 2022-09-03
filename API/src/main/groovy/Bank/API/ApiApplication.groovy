package Bank.API

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired

@SpringBootApplication
class ApiApplication {

	@Autowired
	CustomerRepository customerRepository
    @Autowired
    TerminalRepository terminalRepository



	static void main(String[] args) {
		SpringApplication.run(ApiApplication, args)
	}

    @Bean
    CommandLineRunner run() throws Exception
    {
        (args) ->
        {

            // def customers = 
            // [
            //     new Customer('homer','simpson'),
            //     new Customer('ned','flanders'),
            //     new Customer('barney','gubmle')
            // ]

            // def terminals = 
            // [
            //     new Terminal(54.881350,71.518937),
            //     new Terminal(60.276338,54.488318),
            //     new Terminal(42.365480,64.589411),
            //     new Terminal(43.758721,89.177300),
            //     new Terminal(96.366276,38.344152)
            // ]

            // customers.each{c -> customerRepository.save(c)}
            // terminals.each{t -> terminalRepository.save(t)}
        }
    }

}
