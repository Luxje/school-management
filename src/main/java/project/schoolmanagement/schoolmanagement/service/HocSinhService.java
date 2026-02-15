package project.schoolmanagement.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.schoolmanagement.schoolmanagement.entity.HocSinh;
import project.schoolmanagement.schoolmanagement.repository.RepositoryHocSinh;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Service
public class HocSinhService {

    @Autowired
    private RepositoryHocSinh repositoryHocSinh;

    public List<HocSinh> getAll() {
        List<HocSinh> hocSinhList = (List<HocSinh>)this.repositoryHocSinh.findAll();
        return hocSinhList;
    }

    public HocSinh getById(Integer id) {
        return repositoryHocSinh.findById(id) // <--- Make sure (id) is right here
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

//    public Boolean validateLogin(String email, String password) {
//       HocSinh hocSinh = repositoryHocSinh.findHocSinhByEmail(email);
//    }

}
