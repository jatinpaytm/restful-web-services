package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.*;

// REST API
@RestController   // it will expose the rest api in here
public class HelloWorldController {

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


}
