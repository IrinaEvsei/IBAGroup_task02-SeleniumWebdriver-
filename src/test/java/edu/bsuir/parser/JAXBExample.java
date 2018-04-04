package edu.bsuir.parser;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.List;

public class JAXBExample {

    public static void main(String[] args) throws IOException, JAXBException, SAXException {
        JAXBContext context = JAXBContext.newInstance(User.class);
        Unmarshaller un = context.createUnmarshaller();
        User user = (User) un.unmarshal(new File("src/resources/data.xml"));
        //return user;


        //User roleData = (User) jaxbUnmarshaller.unmarshal();
        List <Role> users = user.getRole();
//iterate over object
        for (Role e : users) {
            System.out.println("username : " + e.getUsername());
            System.out.println("password : " + e.getPassword());
            System.out.println("--------------------------");
        }
    }
//    static String getFileContent(String filePath) throws JAXBException, SAXException {
//
//    }
}
