package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController makes the class ready for use by Spring MVC to handle web requests.
// It also combines @Controller and @ResponseBody, resulting in web requests returning data
// rather than a view.
@RestController
public class HelloController {

    // @RequestMapping maps '/' to the index() method so that when invoked from a client it returns the given string.
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
