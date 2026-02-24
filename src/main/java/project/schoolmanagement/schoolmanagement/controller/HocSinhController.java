package project.schoolmanagement.schoolmanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.schoolmanagement.schoolmanagement.LoginCredentials.AccountLogin;
import project.schoolmanagement.schoolmanagement.entity.Diem;
import project.schoolmanagement.schoolmanagement.entity.DiemDanh;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.entity.LichHoc;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;
import project.schoolmanagement.schoolmanagement.service.HocSinhService;

import java.util.List;

@Controller
@RequestMapping("/hocSinh")
@SessionAttributes("idHocSinh")
public class HocSinhController {


    @Autowired
    private HocSinhService hocSinhService;

    @Autowired
    private RepositoryHocSinh repositoryHocSinh;



    @PostMapping("/hocSinhLogin")
    public String hocSinhLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession httpSession, Model model) {
        if(hocSinhService.validateLogin(email,password)) {
            HocSinh hs = repositoryHocSinh.findHocSinhByAccountEmail(email);
            Integer currentHocSinhId = hs.getId();
            httpSession.setAttribute("currentHocSinhId", currentHocSinhId);

            return "redirect:/hocSinh/hocSinhMainPage";
        }else {
            model.addAttribute("error", "Invalid Email or Password");
            return "hocSinhLogin";
        }
    }

    @GetMapping("/hocSinhLogin")
    private String directLogin(Model model) {
        model.addAttribute("hocSinhLogin", new AccountLogin());
        return "hocSinhLogin";
    }

    @GetMapping("/hocSinhMainPage")
    public String directHocSinhPage(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentHocSinhId");
        HocSinh hs = hocSinhService.getById(id);
        model.addAttribute("hocSinh", hs);

        return "hocSinhMainPage";
    }


    @GetMapping("/hocSinhBangDiem")
    private String directHocSinhBangDiem(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentHocSinhId");
        List<Diem> lstDiem = hocSinhService.getAllDiemHocSinh(id);
        model.addAttribute("lstBangDiem", lstDiem);

        return "hocSinhBangDiem";
    }

    @GetMapping("/hocSinhDiemDanh")
    private String directHocSinhDiemDanh(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentHocSinhId");
        List<DiemDanh> lstDiemDanh = hocSinhService.getAllDiemDanhById(id);
        model.addAttribute("lstDiemDanh", lstDiemDanh);

        return "hocSinhDiemDanh";
    }

    @GetMapping("/hocSinhLichHoc")
    private String directHocSinhLichHoc(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentHocSinhId");
        List<LichHoc> lstLichHoc = hocSinhService.getAllLichHocById(id);
        model.addAttribute("lstLichHoc", lstLichHoc);
         return "hocSinhLichHoc";
    }

    @GetMapping("/hocSinhBoSungHoSo")
    private String directHocSinhBoSungHoSo() {
        return "hocSinhBoSungHoSo";
    }
    
}
