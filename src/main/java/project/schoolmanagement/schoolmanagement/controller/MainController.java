package project.schoolmanagement.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.schoolmanagement.schoolmanagement.repository.RepositoryAccount;
import project.schoolmanagement.schoolmanagement.service.AccountService;

@Controller
@RequestMapping("/mainController")
public class MainController {

    @Autowired
    private AccountService accountService;



    @Autowired
    private RepositoryAccount repositoryAccount;

    @GetMapping("/loginDirect")
    public String loginDirect(Model model) {
        model.addAttribute("accountLogin", )
        return "loginPage";
}

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model ) {
        String position = repositoryAccount.findAccountByEmail(email).getPosition();
        if (accountService.validateLogin(email, password) && position.equals("giang vien")) {
            return "redirect:/giangVien/giangVienMainPage";
        }else if (accountService.validateLogin(email, password) && position.equals("hoc sinh")) {
            return "redirect:/hocSinh/hocSinhMainPage";
        }else {
            model.addAttribute("error", "Invalid information");
            return "loginPage";
        }
    }

}
