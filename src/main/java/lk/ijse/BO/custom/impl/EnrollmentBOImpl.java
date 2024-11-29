package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.EnrollmentBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.CourseDAO;
import lk.ijse.DAO.custom.EnrollmentDAO;
import lk.ijse.DAO.custom.StudentDAO;
import lk.ijse.dto.EnrollmentDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Course;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.util.ArrayList;

public class EnrollmentBOImpl implements EnrollmentBO {

    EnrollmentDAO enrollmentDAO = (EnrollmentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ENROLLMENT);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);



    @Override
    public String getCurrentId() throws IOException {
        return enrollmentDAO.getNextOrderId();
    }

    @Override
    public String generateNewRegisterId() {
        return enrollmentDAO.getCurrentId();


    }

    @Override
    public boolean registerStudent(EnrollmentDTO enrollmentDTO) throws IOException {
        Student student = studentDAO.findById(enrollmentDTO.getStudentId());
//        System.out.println(student + "stuuuuu123");
        Course course = courseDAO.findById(enrollmentDTO.getCourseId());

        return enrollmentDAO.register(new Enrollment(enrollmentDTO.getRegistrationId(),enrollmentDTO.getRegistrationDate(),enrollmentDTO.getDownPayment(),enrollmentDTO.getBalance(),enrollmentDTO.getFinalInstallment(),enrollmentDTO.getFinalPaidDate(),student,course));
    }

    @Override
    public EnrollmentDTO searchById(String registerId) throws IOException {
        Enrollment enrollment=   enrollmentDAO.search(registerId);
        return new EnrollmentDTO(enrollment.getRegistrationId(),enrollment.getDownPayment(),enrollment.getBalance());

    }

    @Override
    public boolean updateEnrollment(String registrationId, double finalInstallment, String finalPayDate) throws IOException {
        return enrollmentDAO.update(registrationId,finalInstallment,finalPayDate);
    }

//    @Override
//    public EnrollmentDTO searchById(String registerId) throws IOException {
//        Enrollment studentId = enrollmentDAO.getStudent(registerId);
//        Enrollment  courseId = enrollmentDAO.getCourseId(registerId);
////        System.out.println(courseId.getDownPayment());
////        System.out.println(student+"stuuuuuuuuuu");
//        Enrollment enrollment=   enrollmentDAO.search(registerId);
////        System.out.println("bo awooooo"+ enrollment.getDownPayment());
//        return new EnrollmentDTO(enrollment.getRegistrationId(),enrollment.getRegistrationDate(),enrollment.getDownPayment(),enrollment.getBalance(),studentId.getStudent(),courseId.getCourse());
//
//    }


}


