package project.schoolmanagement.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.schoolmanagement.schoolmanagement.repository.RepositoryGiaoVienChuNhiem;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryLopHoc;

@Controller
@RequestMapping(name ="/hocSinh")
public class HocSinhController {

    @Autowired
    private RepositoryHocSinh repositoryHocSinh;

    @Autowired
    private RepositoryLopHoc repositoryLopHoc;

    @Autowired
    private RepositoryGiaoVienChuNhiem repositoryGiaoVienChuNhiem;


    @GetMapping("/login")
    public String dangNhap(){
        return "hocSinhDangNhap";
    }

//    @GetMapping("/logging")
//    public String
}
