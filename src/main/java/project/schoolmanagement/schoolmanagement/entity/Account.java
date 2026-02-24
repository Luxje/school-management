package project.schoolmanagement.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "pass")
    private String pass;
    private String position;

    @OneToOne(mappedBy = "account")
    private GiangVien teacher;

    @OneToOne(mappedBy = "account")
    private HocSinh student;

}
