package com.example.demo.fizzbuzz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FizzBuzzController {

    @GetMapping("/fizzbuzz")
    public String fizzbuzz(@RequestParam(name = "fbinput", required = false, defaultValue = "") String input, Model model) {
        FizzBuzz fizzBuzz = new FizzBuzz(input);
        FizzBuzzService.process(fizzBuzz);
        model.addAttribute("fizzbuzz", fizzBuzz);
        return "fizzbuzz";
    }

}

