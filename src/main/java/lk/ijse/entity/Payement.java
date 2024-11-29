package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;


    private double downPayment;
    private double balance;
    private double finalInstallment;
    private String finalPaidDate;


    public Payement(String registrationId, double downPayment, double balance, double finalInstallment, String finalPaidDate) {

    }


}


