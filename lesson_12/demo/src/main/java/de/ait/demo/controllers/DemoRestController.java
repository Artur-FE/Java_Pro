package de.ait.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoRestController {

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getUser() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Jack", 10));
        personList.add(new Person("John", 20));
        return personList;
    };
}
