package controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public String returnErrorPage() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
