package project.schoolmanagement.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.schoolmanagement.schoolmanagement.service.AccountService;

@Controller
@RequestMapping("/mainController")
public class MainController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/loginOption")
    public String directLoginOption() {
        String caiGiDay = "caigiday";
        System.out.println(accountService.encodePassword(caiGiDay));
        return "loginOption";
    }

    @GetMapping("/hocSinhBangDiem")
    public String directHocSinhBangDiem() {
        return "hocSinhBangDiem";
    }
}
