package project.schoolmanagement.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grade")
@AllArgsConstructor
@NoArgsConstructor
public class Diem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;

    @Column(name = "ten_dau_diem")
    private String tenDauDiem;

    @Column(name = "trong_so")
    private Integer trongSo;

    @Column(name = "mon_hoc")
    private String monHoc;

    @Column(name = "diem")
    private double diem;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private HocSinh hocSinh;


}
