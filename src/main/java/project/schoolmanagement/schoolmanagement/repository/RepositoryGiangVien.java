package project.schoolmanagement.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import project.schoolmanagement.schoolmanagement.entity.GiangVien;

public interface RepositoryGiangVien extends CrudRepository<GiangVien, Integer> {
    GiangVien findGiangVienByAccountEmail(String email);
}
