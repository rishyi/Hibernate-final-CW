package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.PaymentBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.PaymentDAO;
import lk.ijse.dto.PaymentDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Payement;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);


    @Override
    public boolean removeBalance(String registrationId) throws IOException {
        return paymentDAO.remove(registrationId);
    }

    @Override
    public ArrayList<PaymentDTO> loadAllPayment() throws IOException {
        ArrayList<PaymentDTO> allpayment = new ArrayList<>();
        ArrayList<Enrollment> all = paymentDAO.getAll();
        for(Enrollment s: all){
            allpayment.add(new PaymentDTO(s.getRegistrationId(),s.getDownPayment(),s.getBalance(),s.getFinalInstallment(),s.getFinalPaidDate()));
        }
        return allpayment;
    }
}

