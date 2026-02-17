package project.schoolmanagement.schoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class HocSinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "birthday")
    private Date birthDay;

    @Column(name = "class_name")
    private String className;


    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Account account;
}
