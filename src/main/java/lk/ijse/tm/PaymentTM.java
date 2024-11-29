package lk.ijse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentTM {
    private String registrationId;
    private double downPayament;
    private double balance;
    private double firstInstallment;
    private String paidDate;
    private String status;

    public PaymentTM(String registrationId, double downPayment, double balance, double finalInstallment, String finalPaidDate) {
       this.registrationId=registrationId;
       this.downPayament=downPayment;
       this.balance=balance;
       this.firstInstallment=finalInstallment;
       this.paidDate=finalPaidDate;

    }
}
