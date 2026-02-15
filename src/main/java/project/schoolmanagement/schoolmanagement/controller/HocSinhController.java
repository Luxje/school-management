package project.schoolmanagement.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.schoolmanagement.schoolmanagement.LoginCredentials.HocSinhLogin;
import project.schoolmanagement.schoolmanagement.service.HocSinhService;

@Controller
@RequestMapping(name ="/hocSinh")
public class HocSinhController {

    private String email;

    @Autowired
    private HocSinhService hocSinhService;

//    @PostMapping("/hocSinhLogin")
//    public String hocSinhLogin(@ModelAttribute("hocSinhLogin") HocSinhLogin hocSinhLogin, Model model) {
//        email = hocSinhLogin.getEmail();
//        String password = hocSinhLogin.getMatKhau();
//    }

}
