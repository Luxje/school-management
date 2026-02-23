package project.schoolmanagement.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.Diem;
import project.schoolmanagement.schoolmanagement.entity.DiemDanh;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryDiem;
import project.schoolmanagement.schoolmanagement.repository.RepositoryDiemDanh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;

import java.util.List;

@Service
public class HocSinhService {

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

    public Boolean validateLogin(String email, String password) {
        HocSinh hocSinh = repositoryHocSinh.findHocSinhByAccountEmail(email);
        if(hocSinh != null && hocSinh.getAccount().getPass().equals(password)) {
            return true;
        }else {
            return false;
        }
    }

    public List<Diem> getAllDiemHocSinh(Integer id) {
        List<Diem> lstDiem = repositoryDiem.findDiemByHocSinh_Id(id);
        return lstDiem;
    }

    public List<DiemDanh> getAllDiemDanhById(Integer id) {
        List<DiemDanh> lstDiemDanh = repositoryDiemDanh.findByHocSinh_Id(id);
        return lstDiemDanh;
    }
}
