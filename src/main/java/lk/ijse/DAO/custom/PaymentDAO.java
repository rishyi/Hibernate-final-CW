package lk.ijse.DAO.custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Payement;

import java.io.IOException;
import java.util.ArrayList;

public interface PaymentDAO extends SuperDAO {
    boolean remove(String registrationId) throws IOException;

    ArrayList<Enrollment> getAll() throws IOException;

//    boolean save(PaymentDTO paymentDTO) throws IOException;
}
