package dhm.api_web.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InitialController {

    @GetMapping("/")
    public String index() {
        return "Ola";
    }
}
