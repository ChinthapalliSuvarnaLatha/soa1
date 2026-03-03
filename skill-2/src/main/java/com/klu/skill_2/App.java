package com.klu.skill_2;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

public class App {

    public static void main(String[] args) {

        StandardServiceRegistry ssr =
            new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();

        try {
            // CREATE
            Transaction t1 = s.beginTransaction();
            Product p = new Product("Laptop", "HP Laptop", 55000, 10);
            s.save(p);
            t1.commit();
            System.out.println("Inserted Successfully");

            int pid = p.getId();

            // READ
            Product p1 = s.get(Product.class, pid);
            System.out.println("Fetched Product: " + p1.getName());

            // UPDATE
            Transaction t2 = s.beginTransaction();
            p1.setPrice(60000);
            s.update(p1);
            t2.commit();
            System.out.println("Updated Successfully");

            // DELETE
            Transaction t3 = s.beginTransaction();
            s.delete(p1);
            t3.commit();
            System.out.println("Deleted Successfully");

            s.flush();
        }
        finally {
            s.close();
            sf.close();
        }
    }
}