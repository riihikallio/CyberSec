package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.repository.SignupRepository;
import java.util.*;
import org.springframework.ui.Model;
import sec.project.domain.Signup;

@Controller
public class ContestController {

//    @Autowired
//    private SignupRepository signupRepository;

    @RequestMapping(value = "/contest", method = RequestMethod.GET)
    public String loadForm(Model model) {
//        ArrayList<Signup> logos = signupRepository.findLogos("Erkki");
//        model.addAttribute("logos", logos);
        return "contest";
    }

    @RequestMapping(value = "/contest", method = RequestMethod.POST)
    public String submitForm(Model model, @RequestParam String logo) {

        return "search";
    }

}
