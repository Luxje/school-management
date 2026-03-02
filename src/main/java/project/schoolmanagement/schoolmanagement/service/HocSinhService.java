package project.schoolmanagement.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.Diem;
import project.schoolmanagement.schoolmanagement.entity.DiemDanh;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.entity.LichHoc;
import project.schoolmanagement.schoolmanagement.repository.RepositoryDiem;
import project.schoolmanagement.schoolmanagement.repository.RepositoryDiemDanh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryLichHoc;

import java.util.Date;
import java.util.List;

@Service
public class HocSinhService {

    @Autowired
    private RepositoryLichHoc repositoryLichHoc;

    @Autowired
    private RepositoryHocSinh repositoryHocSinh;

    @Autowired
    private RepositoryDiem repositoryDiem;

    @Autowired
    private RepositoryDiemDanh repositoryDiemDanh;

    public List<HocSinh> getAll() {
        List<HocSinh> hocSinhList = (List<HocSinh>)this.repositoryHocSinh.findAll();
        return hocSinhList;
    }

    public HocSinh getById(Integer id) {
        return repositoryHocSinh.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    public HocSinh getByAccountId(Integer id) {
        return repositoryHocSinh.findHocSinhByAccount_Id(id);
    }

    public List<Diem> getAllDiemHocSinh(Integer id) {
        HocSinh hocSinh = repositoryHocSinh.findHocSinhByAccount_Id(id);
        List<Diem> lstDiem = repositoryDiem.findDiemByHocSinh_Id(hocSinh.getId());
        return lstDiem;
    }

    public List<DiemDanh> getAllDiemDanhById(Integer id) {
        List<DiemDanh> lstDiemDanh = repositoryDiemDanh.findByHocSinh_Id(id);
        return lstDiemDanh;
    }

    public List<LichHoc> getAllLichHocById(Integer id) {
        List<LichHoc> lstLichHoc = repositoryLichHoc.findLichHocByHocSinh_Id(id);
        return lstLichHoc;
    }

    public List<LichHoc> getAllLichHocByNgayHocAndId(Date ngayHoc, Integer id) {
        List<LichHoc> lstLichHoc = repositoryLichHoc.findLichHocByNgayHocAndHocSinh_Id(ngayHoc, id);
        return lstLichHoc;
    }
}
