package project.schoolmanagement.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mainController")
public class MainController {

    @GetMapping("/loginOption")
    public String directLoginOption() {
        return "loginOption";
    }

    @GetMapping("/hocSinhBangDiem")
    public String directHocSinhBangDiem() {
        return "hocSinhBangDiem";
    }
}
