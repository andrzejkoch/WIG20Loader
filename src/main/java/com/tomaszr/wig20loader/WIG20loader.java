package com.tomaszr.wig20loader;

import com.tomaszr.wig20loader.dto.HibernateUtil;
import com.tomaszr.wig20loader.dto.Wig20Entity;
import org.hibernate.classic.Session;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WIG20loader {
    public static void main(String[] args) {
//        List<String> sharePriceList = new ArrayList<>();

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Wig20Entity wig20 = new Wig20Entity();

        File file = new File("C:\\Users\\rozpet\\Documents\\java\\Projects\\WIG20Loader\\src\\main\\resources\\data\\PGNIG.prn");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String rowFromFile = null;

            while ((rowFromFile = reader.readLine()) != null) {
                String[] parts = rowFromFile.split(",");
                String shareName = parts[0];
                String shareDate = parts[2];
                String shareHour = parts[3];
                String sharePrice = parts[4];
                if (Integer.parseInt(shareDate) >= 20180101) {
                    System.out.println(shareDate + " " + shareHour + " " + sharePrice);
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    Wig20Entity wig20 = new Wig20Entity();

//                    sharePriceList.add(rowFromFile);
                    wig20.setName(shareName);
                    wig20.setDate(shareDate);
                    wig20.setHour(shareHour);
                    wig20.setPrice(Double.parseDouble(sharePrice));

                    //Save the employee in database
                    session.save(wig20);

                    //Commit the transaction
                    session.getTransaction().commit();
                    HibernateUtil.shutdown();


                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
//        System.out.println(sharePriceList);
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Wig20Entity wig20 = new Wig20Entity();

//        wig20.setId(9L);
//        wig20.setName("ALIOR");
//        wig20.setDate("20190312");
//        wig20.setHour("164951");
//        wig20.setPrice(12.11);

        //Save the employee in database
//        session.save(wig20);
//        session.getTransaction().commit();

        HibernateUtil.shutdown();

    }

}
