package Homework.utils;

import Homework.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


    @DataProvider(name = "registrationData")
    public Iterator<Object[]> registrationData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registration.csv")));

        String line = reader.readLine();
        while (line!= null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3])});
        line = reader.readLine();
        }

        return list.iterator();
    }

}
