package com.codeup.nonspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public double addNumbers(@PathVariable double x, @PathVariable double y ){
        return x + y;
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public double subtract(@PathVariable double x, @PathVariable double y ){
        return x - y;
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public double multiply(@PathVariable double x, @PathVariable double y){
        return x * y;
    }

    @GetMapping("/divide/{x}/and/{y}")
    @ResponseBody
    public double divide(@PathVariable double x, @PathVariable double y){
        return x / y;
    }

}
