package entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentId;
    private String studentName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_laptop_details",
            joinColumns = @JoinColumn(name = "stu_id"),
            inverseJoinColumns = @JoinColumn(name ="lap_id")
    )
    private List<Laptop> laptops;

    public Student(long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Student() {
    }

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptop(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
