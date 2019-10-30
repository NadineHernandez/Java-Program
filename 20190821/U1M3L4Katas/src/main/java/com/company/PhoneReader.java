package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {
    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new XmlMapper();

            List<Phone> phoneList;

            phoneList = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>(){});

            for (Phone phone : phoneList) {
                System.out.println(phone.getBrand() + " " + phone.getModel() + " " + phone.getProcessor() + " " +
                        phone.getStorage() + " " + phone.getPrice());
            }

        } catch (IOException e) {
            System.out.println("ERROR encountered reading JSON file: " + e.getMessage());
        }
    }
}
