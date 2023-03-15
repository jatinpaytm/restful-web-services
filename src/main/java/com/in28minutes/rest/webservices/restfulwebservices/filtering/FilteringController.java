package com.in28minutes.rest.webservices.restfulwebservices.filtering;
/**
 * Dynamic filtering ->  is done with the help of MappingJacksonValue class
 * and @JsonFilter
 */

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    // Below is done for static filtering
    /*
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list") //field2, field3
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"));
    }

     */

    // Below is done for Dynamic filtering

    @GetMapping("/filtering") //field2
    public MappingJacksonValue filtering() {

        SomeBean someBean = new SomeBean("value1","value2", "value3");

        // MappingJacksonValue allows us to set filters
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        //step 3
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        //step 2
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
        //step 1
        mappingJacksonValue.setFilters(filters );


        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list") //field2, field3
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2", "value3"),
                new SomeBean("value4","value5", "value6"));

        // MappingJacksonValue allows us to set filters
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        //step 3
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        //step 2
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
        //step 1
        mappingJacksonValue.setFilters(filters );

        return mappingJacksonValue;
    }
}
