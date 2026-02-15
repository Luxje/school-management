package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;

public interface RepositoryHocSinh extends CrudRepository {
    public HocSinh findHocSinhById(Integer id);
}
