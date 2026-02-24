package project.schoolmanagement.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lich_hoc")
public class LichHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mon_hoc")
    private String monHoc;

    @Column(name = "ma_mon_hoc")
    private String maMonHoc;

    @Column(name = "ngay_hoc")
    private Date ngayHoc;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private HocSinh hocSinh;
}
