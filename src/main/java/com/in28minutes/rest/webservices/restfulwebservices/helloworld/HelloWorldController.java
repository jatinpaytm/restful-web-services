package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

// REST API
@RestController   // it will expose the rest api in here
public class HelloWorldController {

    // MessageSource is the class used for internalization - i18n
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")   // no need to specify method .. because naming is done like that
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {  // this will create a JSON response --> output : {"message":"Hello World"}
        return new HelloWorldBean("Hello World");  // we are returning an instance , not a direct string
    }

    // Path Parameters
    // /users/{id}/todos/{id}  => /users/2/todos/200 -> it says give 2nd user's 200th todo -> 2 and 200 are path parameter

    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/Jatin
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {  // we can capture value of name with the help of @PathVariable
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }


    // It is done using messages.properties file in resources folder
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale );

        //return "Hello World V2";

        //1:
        //2:
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

    }


}
