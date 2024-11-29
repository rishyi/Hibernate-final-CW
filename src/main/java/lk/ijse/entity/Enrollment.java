package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Enrollment {
    @Id
    private String registrationId;
    private String registrationDate;
    private double downPayment;
    private double balance;
    private double finalInstallment;
    private String finalPaidDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "programId")
    private Course course;

    public Enrollment(String registrationId, String registrationDate, double downPayment, double balance, double finalInstallment, String finalPaidDate) {
       this.registrationId=registrationId;
       this.registrationDate=registrationDate;
       this.downPayment=downPayment;
       this.balance=balance;
       this.finalInstallment=finalInstallment;
       this.finalPaidDate=finalPaidDate;
    }


//    public Enrollment(String registrationId, String registrationDate, double downPayment, double balance, Student student, Course course) {
//          this.registrationId =registrationId;
//          this.registrationDate =registrationDate;
//          this.downPayment =downPayment;
//          this.balance=balance;
//          this.student=student;
//          this.course=course;
//    }
}
