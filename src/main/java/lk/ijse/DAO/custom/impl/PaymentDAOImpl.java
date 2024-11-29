package lk.ijse.DAO.custom.impl;

import lk.ijse.DAO.custom.PaymentDAO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Enrollment;
import lk.ijse.entity.Payement;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean remove(String registrationId) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        double balance = 0.0;
        String hql = "UPDATE Enrollment SET balance = :bal WHERE registrationId= :rid";
        Query query = session.createQuery(hql);
        query.setParameter("bal",balance);
        query.setParameter("rid",registrationId);
        query.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Enrollment> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        List<Student> list = session.createQuery("from Student ", Student.class).list();

        String hql=("from Enrollment");
        Query query = session.createQuery(hql);
        ArrayList<Enrollment> payList = (ArrayList<Enrollment>) query.list();
        transaction.commit();
        session.close();
        return payList;
    }
//    @Override
//    public boolean save(Payement payement) throws IOException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.save(payement);
//        transaction.commit();
//        session.close();
//        return true;
//    }





}
