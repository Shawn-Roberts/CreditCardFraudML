package Bank.API

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RestController
class APIController
{
    //GET
    @GetMapping("/")
    String test()
    {
        return "what is up"

    }

}