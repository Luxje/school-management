package project.schoolmanagement.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "student_attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiemDanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mon_hoc")
    private String monHoc;

    @Column(name = "ngay_hoc")
    private Date ngayHoc;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private HocSinh hocSinh;
}
