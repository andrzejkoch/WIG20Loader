package com.tomaszr.wig20loader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WIG20loader {
    public static void main(String[] args) {
        List<String> sharePriceList = new ArrayList<>();

        File file = new File("C:\\Users\\rozpet\\Documents\\java\\Projects\\WIG20Loader\\src\\main\\resources\\data\\ALIOR.prn");
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
                if (Integer.parseInt(shareDate)>=20180101){
                    System.out.println(shareDate+" "+shareHour+" "+sharePrice);
                    sharePriceList.add(rowFromFile);

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
    }

}
