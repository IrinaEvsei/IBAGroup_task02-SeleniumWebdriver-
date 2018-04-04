package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.parser.Role;
import edu.bsuir.parser.RoleDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class LoginPageTest {
    LoginPage loginPage = new LoginPage();
    RoleDAO roleDAO = new RoleDAO();

    @Test
    public void testLogin() throws JAXBException {
        loginPage.getLoginPage();
        Role role = roleDAO.getRole("recruter");
        if (role != null){
            loginPage.typeLogin(role.getUsername());
            loginPage.typePassword(role.getPassword());
            loginPage.clickLoginButton();
            Assert.assertEquals("Главная - Конструктор Талантов", loginPage.getTitle());
        }
//        loginPage.typeLogin("kabanov@tc.by");
//        loginPage.typePassword("welcome");
//        loginPage.clickLoginButton();
//        Assert.assertEquals("Главная - Конструктор Талантов", loginPage.getTitle());
    }

    @After
    public void closeDriver(){
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }
}
