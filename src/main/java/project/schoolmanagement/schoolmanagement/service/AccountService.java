package project.schoolmanagement.schoolmanagement.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.Account;
import project.schoolmanagement.schoolmanagement.repository.RepositoryAccount;

@Service
public class AccountService {
    @Autowired
    RepositoryAccount repositoryAccount;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12) ;


    public Boolean validateLogin(String email, String password) {
        Account account = repositoryAccount.findAccountByEmail(email);
        if(account != null && account.getPass().matches(password)) {
            return true;
        }
        return false;
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
