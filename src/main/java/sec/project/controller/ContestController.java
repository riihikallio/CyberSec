package sec.project.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;
import sec.project.util.CurrentUser;

@Controller
public class ContestController {

    @Autowired
    SignupRepository signuprepo;

    @RequestMapping(value = "/contest", method = RequestMethod.GET)
    public String loadForm(Model model) {
        String user = CurrentUser.name();
        model.addAttribute("user", user);
        List<Signup> logos = signuprepo.findLogos(user);
        model.addAttribute("logos", logos);
        return "contest";
    }

    @RequestMapping(value = "/contest", method = RequestMethod.POST)
    public String submitForm(Model model, @RequestParam String logo) {
        String user = CurrentUser.name();
        if (user != null && logo != null && logo.length() > 0) {
            Signup account = signuprepo.findByName(user);
            account.setLogo(logo);
            signuprepo.save(account);
        }
        return "redirect:/contest";
    }

}
