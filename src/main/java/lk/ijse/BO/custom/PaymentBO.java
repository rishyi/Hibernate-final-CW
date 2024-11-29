package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.PaymentDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    boolean removeBalance(String registrationId) throws IOException;

    ArrayList<PaymentDTO> loadAllPayment() throws IOException;
//    boolean save(PaymentDTO paymentDTO) throws IOException;
}
