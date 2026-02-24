package project.schoolmanagement.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.Account;
import project.schoolmanagement.schoolmanagement.repository.RepositoryAccount;

@Service
public class AccountService {
    @Autowired
    RepositoryAccount repositoryAccount;



//    public Boolean roleValidate(String email) {
//        Account account = repositoryAccount.findAccountByEmail(email);
//        if(account.getPosition().equals("giang vien")) {
//            return true;
//        }else if(account.getPosition().equals("hoc sinh")) {
//            return false;
//        }
//        return null;
//    }

}
