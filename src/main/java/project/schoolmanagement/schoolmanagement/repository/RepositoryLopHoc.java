package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.LopHoc;

public interface RepositoryLopHoc extends CrudRepository {
    public LopHoc findLopHocById(Integer id);
}
