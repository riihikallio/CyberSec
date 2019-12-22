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
public class SearchController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String loadForm() {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String submitForm(Model model, @RequestParam String name) {
        String url = "jdbc:h2:mem:sec";
        ArrayList<String> buddies = new ArrayList<>();
        if (name != null & name.length() > 0) {
            try {
                Connection con = DriverManager.getConnection(url, "sa", "");
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("SELECT name, address FROM SignUp WHERE name LIKE '%" + name + "%'");
                while (rs.next()) {
                    buddies.add(rs.getString(1) + " (" + rs.getString(2) + ")");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + " " + ex);
            }
        }

        model.addAttribute("buddies", buddies);
        return "search";
    }

}
