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

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hocSinh")
public class HocSinhController {


    @Autowired
    private HocSinhService hocSinhService;





    @GetMapping("hocSinhBangDiemPage")
    private String directHocSinhBangDiem() {
        return "hocSinhBangDiem";
    }

    @GetMapping("hocSinhDiemDanhPage")
    private String directHocSinhDiemDanh() {
        return "hocSinhDiemDanh";
    }

    @GetMapping("hocSinhLichHocPage")
    private String directHocSinhLichHoc() {
        return "hocSinhLichHoc";
    }

    @GetMapping("hocSinhHoSoPage")
    private String directHocSinhHoSo() {
        return "hocSinhHoSo";
    }

    @GetMapping("hocSinhKhenThuongPage")
    private String directHocSinhKhenThuong() {
        return "hocSinhKhenThuong";
    }

    @GetMapping("hocSinhViPage")
    private String directHocSinhVi() {
        return "hocSinhVi";
    }


    @GetMapping("/hocSinhMainPage")
    public String directHocSinhPage(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentAccountId");
        HocSinh hs = hocSinhService.getByAccountId(id);
        model.addAttribute("hocSinhFullName", hs.getFullName());
        model.addAttribute("hocSinh", hs);

        return "hocSinhMainPage";
    }


    @GetMapping("/hocSinhBangDiem")
    private String directHocSinhBangDiem(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentAccountId");
        HocSinh hs = hocSinhService.getByAccountId(id);
        List<Diem> lstDiem = hocSinhService.getAllDiemHocSinh(id) ;
        model.addAttribute("lstBangDiem", lstDiem);
        model.addAttribute("hocSinh", hs);

        return "hocSinhBangDiem";
    }

    @GetMapping("/hocSinhDiemDanh")
    private String directHocSinhDiemDanh(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentAccountId");
        List<DiemDanh> lstDiemDanh = hocSinhService.getAllDiemDanhById(id);
        model.addAttribute("lstDiemDanh", lstDiemDanh);

        return "hocSinhDiemDanh";
    }

    @GetMapping("/hocSinhLichHoc")
    private String directHocSinhLichHoc(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentAccountId");
        List<LichHoc> lstLichHoc = hocSinhService.getAllLichHocById(id);
        model.addAttribute("lstLichHoc", lstLichHoc);
        return "hocSinhLichHoc";
    }

    @GetMapping("/hocSinhFindLichHoc")
    private String lichHocSortByNgayHoc(HttpSession httpSession, Model model) {
        Integer id = (Integer) httpSession.getAttribute("currentAccountId");
        Date ngayHoc = (Date) model.getAttribute("ngayHoc");
        List<LichHoc> lstLichHoc = hocSinhService.getAllLichHocByNgayHocAndId(ngayHoc,id);
        model.addAttribute("lstLichHoc", lstLichHoc);
        return "hocSinhLichHoc";
    }


    @GetMapping("/hocSinhBoSungHoSo")
    private String directHocSinhBoSungHoSo() {
        return "hocSinhBoSungHoSo";
    }

}
