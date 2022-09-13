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
        }
    }

}
