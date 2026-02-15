package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;

import java.util.Optional;

public interface RepositoryHocSinh extends CrudRepository<HocSinh, Integer> {
    HocSinh findHocSinhByEmail(String email);
}
