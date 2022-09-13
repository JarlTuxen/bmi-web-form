package dk.kea.bmiwebform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiCalculator {

    @GetMapping("/")
    public String ShowForm(){

        return "bmi-calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam int weight, @RequestParam int height, Model model){

        double bmi = ((double)weight / (double)(height * height)) * 10000;
        bmi = (double)Math.round(bmi*10)/10;

        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        model.addAttribute("bmi", bmi);

        return "/bmi-result";
    }
}
