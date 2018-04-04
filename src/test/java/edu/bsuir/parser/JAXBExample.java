package edu.bsuir.parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class JAXBExample {
    public static void main(String[] args) throws IOException, JAXBException {
//get file content in the form of string
        String xml = getFileContent("src/resources/data.xml");
//initialize a java.io.Reader object with xml content
        StringReader reader = new StringReader(xml);
//initialize jaxb classes
        JAXBContext context = JAXBContext.newInstance(User.class);
        Unmarshaller un = context.createUnmarshaller();
//convert to desired object
        User roleData = (User) un.unmarshal(reader);
        List user = roleData.getRole();
//iterate over object
        for (Role e : user) {
            System.out.println("username : " + e.getUsername());
            System.out.println("password : " + e.getPassword());
            System.out.println("--------------------------");
        }
    }
    static String getFileContent(String filePath) {
        FileReader fr = null;
        char[] buffer = new char[1024];
        StringBuffer fileContent = new StringBuffer();
        try {
            fr = new FileReader(filePath);
            int i = 0;
            while ((i = fr.read(buffer)) != -1) {
                fileContent.append(new String(buffer));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContent.toString();
    }
}
