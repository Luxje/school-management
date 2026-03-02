package project.schoolmanagement.schoolmanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.schoolmanagement.schoolmanagement.LoginCredentials.AccountLogin;
import project.schoolmanagement.schoolmanagement.entity.Account;
import project.schoolmanagement.schoolmanagement.entity.GiangVien;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryAccount;
import project.schoolmanagement.schoolmanagement.repository.RepositoryGiangVien;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;
import project.schoolmanagement.schoolmanagement.service.AccountService;

@Controller
@RequestMapping("/mainController")
public class MainController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RepositoryAccount repositoryAccount;

    @Autowired
    private RepositoryHocSinh repositoryHocSinh;

    @Autowired
    private RepositoryGiangVien repositoryGiangVien;

    @GetMapping("/loginDirect")
    public String loginDirect(Model model) {
        model.addAttribute("accountLogin", new AccountLogin());
        return "loginPage";
}

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession httpSession) {
        if (repositoryAccount.findAccountByEmail(email).getPosition().equals("hoc sinh")) {
            Account account = repositoryAccount.findAccountByEmail(email);
            httpSession.setAttribute("currentAccountId", account.getId());
            return "redirect:/hocSinh/hocSinhMainPage";
        } else if (repositoryAccount.findAccountByEmail(email).getPosition().equals("giang vien")) {
            Account account = repositoryAccount.findAccountByEmail(email);
            httpSession.setAttribute("currentAccountId", account.getId());
            return "redirect:/giangVien/giangVienMainPage";
        } else {
            model.addAttribute("error", "Invalid Email or password");
            return "loginPage";
        }
    }

}
