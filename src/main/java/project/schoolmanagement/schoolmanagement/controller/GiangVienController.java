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


    @GetMapping("/giangVienMainPage")
    public String directGiangVienPage() {
        return "giangVienMainPage";
    }

}
