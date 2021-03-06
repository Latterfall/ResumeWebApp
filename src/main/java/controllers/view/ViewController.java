package controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class ViewController {
    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = "/messages")
    public String getMessagesPage() {
        return "messages";
    }

    @GetMapping(path = "/login")
    public String getLoginPage() {
        return "login";
    }
}
