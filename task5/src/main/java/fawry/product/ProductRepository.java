package fawry.product;

import fawry.entity.Product;
import fawry.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ProductRepository {

    private static Session session;
    public static Product get(int id){
         session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Product.class , id);
    }

    public static List<Product> getProducts(){
        session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("from Product");
        return query.list();
    }

    public static void save(Product product){
        executeTransaction(session -> session.save(product));
    }

    public static void delete(Product product){
        executeTransaction(session-> session.remove(product));
    }

    public static void update(Product product){
        executeTransaction(session1 -> session1.update(product));
    }

    private static void executeTransaction(Consumer<Session> action){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction1 = session.beginTransaction();
        action.accept(session);
        transaction1.commit();
    }

}
