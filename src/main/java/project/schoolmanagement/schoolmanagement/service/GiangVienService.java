package project.schoolmanagement.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.GiangVien;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryGiangVien;

import java.util.List;

@Service
public class GiangVienService {

    @Autowired
    RepositoryGiangVien repositoryGiangVien;

    public List<GiangVien> getAll() {
        List<GiangVien> giangVienList = (List<GiangVien>) this.repositoryGiangVien.findAll();
        return giangVienList;
    }

    public GiangVien getGiangVienById(Integer id) {
        return repositoryGiangVien.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID:" + id));
    }

    public GiangVien validateLogin(String email, String password) {
        GiangVien giangVien = repositoryGiangVien.findGiangVienByAccountEmail(email);
        if(giangVien != null && giangVien.getAccount().getPass().equals(password)) {
            return giangVien;
        }else {
            return null;
        }
    }
}
