package sec.project.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;
import sec.project.util.CurrentUser;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping(Model model) {
        String user = CurrentUser.name();
        if (user == null) {
            return "redirect:/form";
        }
        model.addAttribute("user", user);
        return "welcome";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm(Model model) {
        String user = CurrentUser.name();
        model.addAttribute("user", user);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(Model model, @RequestParam String name, @RequestParam String address, @RequestParam String passwd,
            HttpServletRequest request) {
        if (name.length() == 0 || address.length() == 0 || passwd.length() == 0) {
            return "redirect:/form";
        }
        signupRepository.save(new Signup(name, address, passwd));

        try {
            request.login(name, passwd);
        } catch (ServletException e) {
            System.out.println("Error while login " + e);
        }
        model.addAttribute("user", name);
        return "welcome";
    }
}
