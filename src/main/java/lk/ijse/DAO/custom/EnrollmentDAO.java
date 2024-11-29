package lk.ijse.DAO.custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.entity.Enrollment;

import java.io.IOException;

public interface EnrollmentDAO extends SuperDAO {
    String getNextOrderId() throws IOException;

    String getCurrentId();

    boolean register(Enrollment enrollment) throws IOException;

    Enrollment search(String registerId) throws IOException;

    boolean update(String registrationId, double finalInstallment, String finalPayDate) throws IOException;

//    Enrollment getStudent(String registerId) throws IOException;

//    Enrollment getCourseId(String registerId) throws IOException;
}
