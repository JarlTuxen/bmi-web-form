package dk.kea.bmiwebform.service;

import org.springframework.stereotype.Service;

@Service
public class BeregningsService {

    public double bmiBeregner(double h, double w){
        return w/(h*h);
    }
}
