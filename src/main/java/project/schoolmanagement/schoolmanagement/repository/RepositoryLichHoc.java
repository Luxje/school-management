package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.LichHoc;

import java.util.Date;
import java.util.List;

public interface RepositoryLichHoc extends CrudRepository<LichHoc, Integer> {
    public List<LichHoc> findLichHocByHocSinh_Id(Integer id);

    public List<LichHoc> findLichHocByNgayHocAndHocSinh_Id(Date ngayHoc, Integer id);
}
