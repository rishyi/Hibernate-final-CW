package lk.ijse.dto;

import jakarta.persistence.*;
import lk.ijse.entity.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@Data
//@AllArgsConstructor
//public class PaymentDTO {
//
//
//    private String paymentId;
//    private String registrationId;
//    private double downPayment;
//    private double balance;
//    private double finalInstallment;
//    private String finalPaidDate;
//
//    public PaymentDTO(String registrationId, double downPayment, double balance, double finalInstallment, String finalPayDate) {
//     this.registrationId=registrationId;
//     this.downPayment=downPayment;
//     this.balance=balance;
//     this.finalInstallment=finalInstallment;
//     this.finalPaidDate=finalPayDate;
//    }
//
//    public PaymentDTO(EnrollmentDTO enrollment, double downPayment, double balance, double finalInstallment, String finalPayDate) {
//
//
//    }
//}

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentDTO {

    private String paymentId;
    private String registrationId;
    private double downPayment;
    private double balance;
    private double finalInstallment;
    private String finalPaidDate;

    // Constructor for PaymentDTO from EnrollmentDTO
    public PaymentDTO(String registrationId, double downPayment, double balance, double finalInstallment, String finalPayDate) {
        this.registrationId = registrationId;
        this.downPayment = downPayment;
        this.balance = balance;
        this.finalInstallment = finalInstallment;
        this.finalPaidDate = finalPayDate;
    }
}


