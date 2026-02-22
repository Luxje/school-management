package project.schoolmanagement.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.schoolmanagement.schoolmanagement.LoginCredentials.AccountLogin;
import project.schoolmanagement.schoolmanagement.service.HocSinhService;

@Controller
@RequestMapping("/hocSinh")
public class HocSinhController {


    @Autowired
    private HocSinhService hocSinhService;

    @PostMapping("/hocSinhLogin")
    public String hocSinhLogin(@ModelAttribute("hocSinhLogin") AccountLogin accountLogin, Model model) {
        String email = accountLogin.getEmail();
        String password = accountLogin.getPassword();
        if(hocSinhService.validateLogin(email,password) == true) {
            return "redirect:/hocSinh/hocSinhMainPage";
        }else {
            model.addAttribute("error", "Invalid Email or Password");
            return "hocSinhLogin";
        }
    }

    @GetMapping("/hocSinhMainPage")
    public String directHocSinhPage() {
        return "hocSinhMainPage";
    }

    @GetMapping("/hocSinhLogin")
    private String directLogin(Model model) {
        model.addAttribute("hocSinhLogin", new AccountLogin());
        return "hocSinhLogin";
    }

    @GetMapping("/hocSinhBangDiem")
    private String directHocSinhBangDiem() {


        return "hocSinhBangDiem";
    }

    @GetMapping("/hocSinhDiemDanh")
    private String directHocSinhDiemDanh() {
        return "hocSinhDiemDanh";
    }

    @GetMapping("/hocSinhLichHoc")
    private String directHocSinhLichHoc() {
        return "hocSinhLichHoc";
    }

    
}
