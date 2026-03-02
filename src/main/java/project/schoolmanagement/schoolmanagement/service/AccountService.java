package project.schoolmanagement.schoolmanagement.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.Account;
import project.schoolmanagement.schoolmanagement.entity.GiangVien;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryAccount;
import project.schoolmanagement.schoolmanagement.repository.RepositoryGiangVien;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;

@Service
public class AccountService {
    @Autowired
    RepositoryAccount repositoryAccount;

    @Autowired
    RepositoryGiangVien repositoryGiangVien;

    @Autowired
    RepositoryHocSinh repositoryHocSinh;



    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12) ;


    public HocSinh validateLoginHocSinh(String email, String password) {
        HocSinh hocSinh = repositoryHocSinh.findHocSinhByAccountEmail(email);
        if(hocSinh != null && hocSinh.getAccount().getPass().matches(password)) {

            return hocSinh;
        }
        return null;
    }

    public GiangVien validateLoginGiangVien(String email, String password) {
        GiangVien giangVien = repositoryGiangVien.findGiangVienByAccountEmail(email);
        if(giangVien != null && giangVien.getAccount().getPass().matches(password)) {

            return giangVien;
        }
        return null;
    }

//    public Boolean roleValidate(String email) {
//        Account account = repositoryAccount.findAccountByEmail(email);
//        if(account.getPosition().equals("giang vien")) {
//            return true;
//        }else if(account.getPosition().equals("hoc sinh")) {
//            return false;
//        }
//        return null;
//    }

    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
