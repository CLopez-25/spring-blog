package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String diceRoll(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceGuess(@PathVariable int n, Model model){
        int randomNumber = (int) (Math.random() * 6) + 1;
        boolean check = randomNumber == n;
        model.addAttribute("n", n);
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("check", check);
        return "/roll-dice";
    }
}
