package com.codeup.nonspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice")
public class DiceController {
    @GetMapping
    public String diceRoll(){
        return "roll-dice";
    }

    @GetMapping("/{number}")
    public String diceGuess(@PathVariable String number, Model model){
        model.addAttribute("number", number);
        model.addAttribute("randomNumber", Math.floor((Math.random() * 6) + 1));
        return "roll-dice";
    }
}
