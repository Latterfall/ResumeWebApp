package controllers.REST;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/locale")
public class LocaleController {
    @GetMapping
    public ResponseEntity<String> getUserLocale() {
        return new ResponseEntity<>(LocaleContextHolder.getLocale().toLanguageTag(), HttpStatus.OK);
    }
}
