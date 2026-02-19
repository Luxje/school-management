package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.Account;

import java.util.List;

public interface RepositoryAccount extends CrudRepository<Account, Integer> {
    public List<Account> findAccountById(Integer id);

    public Account findAccountByEmail(String email);
}
