package project.schoolmanagement.schoolmanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.schoolmanagement.schoolmanagement.LoginCredentials.AccountLogin;
import project.schoolmanagement.schoolmanagement.entity.GiangVien;
import project.schoolmanagement.schoolmanagement.service.GiangVienService;

@Controller
@RequestMapping("/giangVien")
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    @PostMapping("/giangVienLogin")
    public String giangVienLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession httpSession, Model model) {
        GiangVien giangVien = giangVienService.validateLogin(email, password);
        if (giangVien != null) {
            Integer idGiangVien = giangVien.getId();
            httpSession.setAttribute("currentGiangVienId", idGiangVien);
            return "redirect:/giangVien/giangVienMainPage";
        } else {
            model.addAttribute("error", "Sai thông tin đăng nhập");
            return "giangVienLogin";
        }
    }

    @GetMapping("/giangVienMainPage")
    public String directGiangVienPage() {
        return "giangVienMainPage";
    }

    @GetMapping("/giangVienLogin")
    private String directLogin(Model model) {
        model.addAttribute("giangVienLogin", new AccountLogin());
        return "giangVienLogin";
    }

}
