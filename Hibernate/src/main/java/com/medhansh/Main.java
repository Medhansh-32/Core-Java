package com.medhansh;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Student s1=new Student();
        s1.setId(103);
        s1.setName("Medhansh");
        s1.setTech("Spring_boot");

        System.out.println(s1);

        Configuration cfg=new Configuration();
        SessionFactory factory=new Configuration()
                .addAnnotatedClass(com.medhansh.Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();


        //session.save(s1); create Data
        //session.find(com.medhansh.Student.class, 101); retrieve data
        //session.merge(s1); update data
        //session.remove(s1); delete data


      Student student=  session.find(com.medhansh.Student.class, s1.getId());

      System.out.println(student);

        transaction.commit();

        session.close();
        factory.close();


    }
}