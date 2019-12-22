package sec.project.controller;

import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.repository.SignupRepository;
import java.sql.*;
import java.util.*;
import org.springframework.ui.Model;

@Controller
public class ContestController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping(value = "/contest", method = RequestMethod.GET)
    public String loadForm() {
        return "contest";
    }

    @RequestMapping(value = "/contest", method = RequestMethod.POST)
    public String submitForm(Model model, @RequestParam String name) {
        ArrayList<String> logos = new ArrayList<String>();

        model.addAttribute("logos", logos);
        return "search";
    }

}
