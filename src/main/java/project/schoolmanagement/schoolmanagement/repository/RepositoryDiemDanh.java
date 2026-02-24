package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.DiemDanh;

import java.util.Date;
import java.util.List;

public interface RepositoryDiemDanh extends CrudRepository<DiemDanh, Integer> {
    public List<DiemDanh> findByHocSinh_Id(Integer id);

    public List<DiemDanh> findDiemDanhByNgayHoc(Date ngayHoc);

    public List<DiemDanh> findDiemDanhByTrangThai(Boolean trangThai);
}
