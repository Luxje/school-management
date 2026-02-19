package project.schoolmanagement.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
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


    public Boolean roleValidate(String email) {
        Account account = repositoryAccount.findAccountByEmail(email);
        if(account.getEmail().equals("giang vien")) {
            return true;
        }else if(account.getEmail().equals("hoc sinh")) {
            return false;
        }
        return null;
    }

}
