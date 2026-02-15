package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.GiaoVienChuNhiem;

public interface RepositoryGiaoVienChuNhiem extends CrudRepository<GiaoVienChuNhiem, Integer> {
    public GiaoVienChuNhiem findGiaoVienChuNhiemById(Integer id);
}
