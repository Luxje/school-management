package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.Diem;

import java.util.List;

public interface RepositoryDiem extends CrudRepository<Diem, Integer> {
    List<Diem> findDiemByHocSinh_Id(Integer id);
}
