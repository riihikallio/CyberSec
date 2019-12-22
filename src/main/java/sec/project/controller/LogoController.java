package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class LogoController {

    @Autowired
    SignupRepository signuprepo;

    @RequestMapping(value = "/logo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String show(Model model, @PathVariable Long id) {
        Signup user = signuprepo.findById(id);
        String response = "Something went wrong!";
        if (user != null) {
            String logo = user.getLogo();
            if (logo != null) {
                response = "<html><head><title>Logo</title></head><body><svg width=\"100%\" height=\"100%\">";
                response += logo;
                response += "</svg></body></html>";
            }
        }
        return response;
    }
}
