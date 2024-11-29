package lk.ijse.DAO.custom.impl;

import lk.ijse.DAO.custom.EnrollmentDAO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Enrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {





        @Override
        public String getCurrentId() {
            String lastRegisterId = null;

            try (Session session = FactoryConfiguration.getInstance().getSession()) {
                Transaction transaction = session.beginTransaction();

                // Query to get the last registration ID
                String hql = "SELECT registrationId FROM Enrollment ORDER BY registrationId DESC";
                Query<String> query = session.createQuery(hql, String.class);
                query.setMaxResults(1); // Limit the result to one record

                lastRegisterId = query.uniqueResult(); // Get the single result
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return lastRegisterId; // Return the last ID or null if no rows found
        }

    @Override
    public boolean register(Enrollment enrollment) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(enrollment);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Enrollment search(String registerId) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql =("from Enrollment where registrationId = :s_id");
        Query query = session.createQuery(hql);
        query.setParameter("s_id",registerId);

        List<Enrollment> paymentLis = query.list();


        Enrollment payDetails=null;
        for(Enrollment st : paymentLis){
//            System.out.println(st.getDownPayment()+ "awaa");
            payDetails= new Enrollment(st.getRegistrationId(),st.getRegistrationDate(),st.getDownPayment(),st.getBalance(),st.getFinalInstallment(),st.getFinalPaidDate());

        }

        transaction.commit();
        session.close();


        return payDetails;
    }

    @Override
    public boolean update(String registrationId, double finalInstallment, String finalPayDate) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(registrationId+"awooooo");
        String hql="UPDATE Enrollment SET finalInstallment = :fIns, finalPaidDate = :fDate WHERE registrationId= :rId";
        Query query = session.createQuery(hql);
        query.setParameter("rId",registrationId);
        query.setParameter("fIns",finalInstallment);
        query.setParameter("fDate",finalPayDate);

        query.executeUpdate();
        transaction.commit();
        session.close();

        return true;

    }

//    @Override
//    public Enrollment getStudent(String registerId) throws IOException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        String hql =("SELECT studentId FROM Enrollment WHERE registrationId = : rId");
//        Query query = session.createQuery(hql);
//        query.setParameter("rId",registerId);
//      Enrollment studentIds = (Enrollment) query.list();
//
//        transaction.commit();
//        session.close();
//        return studentIds;
//    }

//    @Override
//    public Enrollment getCourseId(String registerId) throws IOException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        String hql =("SELECT programId FROM Enrollment WHERE registrationId = : rId");
//        Query query = session.createQuery(hql);
//        query.setParameter("rId",registerId);
//        Enrollment courseList  = (Enrollment) query.list();
//        transaction.commit();
//        session.close();
//        return courseList;
//    }


    @Override
        public String getNextOrderId() {
            String currentId = getCurrentId();

            // If no ID exists, start with "REG-001"
            if (currentId == null) {
                return "REG-001";
            }

            // Extract the numeric part of the ID
            int numericPart = Integer.parseInt(currentId.split("-")[1]);

            // Increment the numeric part
            numericPart++;

            // Format the new ID with leading zeros
            return String.format("REG-%03d", numericPart);
        }
    }




