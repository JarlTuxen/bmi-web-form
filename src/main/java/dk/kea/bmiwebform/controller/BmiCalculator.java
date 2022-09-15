package dk.kea.bmiwebform.controller;

import dk.kea.bmiwebform.service.BeregningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BmiCalculator {
    @Autowired
    BeregningsService beregningsService;

    /*BmiCalculator(){
        beregningsService = new BeregningsService();
    }*/

    /*BmiCalculator(BeregningsService beregningsService){
        this.beregningsService = beregningsService;
    }*/

    @GetMapping("/")
    public String ShowForm(){

        return "bmi-calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam int weight, @RequestParam int height, RedirectAttributes attributes){

        //dårligt design at have udregning i controller - kunne være i modelklasse eller serviceklasse
        //double bmi = ((double)weight / (double)(height * height)) * 10000;
        //bmi = (double)Math.round(bmi*10)/10;

        double bmi = beregningsService.bmiBeregner(((double) height)/100, (double) weight);
        attributes.addAttribute("weight", weight);
        attributes.addAttribute("height", height);
        attributes.addAttribute("bmi", bmi);

        return "redirect:/bmi-result";
    }

    @GetMapping("/bmi-result")
    public String calculate(@RequestParam int weight, @RequestParam int height, @RequestParam double bmi, Model model){
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        model.addAttribute("bmi", bmi);

        return "/bmi-result";
    }
}
