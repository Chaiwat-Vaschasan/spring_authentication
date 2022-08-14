package authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) Boolean error,Model model){
        model.addAttribute("error",error);
        return "login";
    }

    @GetMapping(value ="/login-error")
    public String loginError( Model model){
        model.addAttribute("error",true);
        return "login";
    }
}
