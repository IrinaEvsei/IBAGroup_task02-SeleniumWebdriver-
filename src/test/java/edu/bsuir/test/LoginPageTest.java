package edu.bsuir.test;

import com.sun.org.glassfish.gmbal.Description;
import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.parser.Role;
import edu.bsuir.parser.RoleDAO;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.xml.bind.JAXBException;

public class LoginPageTest {
    private WebDriver driver = WebDriverSingleton.getInstance();

    LoginPage loginPage = new LoginPage();
    RoleDAO roleDAO = new RoleDAO();

    @Test
    @DisplayName("Авторизация")
    @Description("Вход в систему как рекрутер")
    @Feature("Конструктор талантов")
    @Story("Сценарий 1 - Вход")
    @Severity(SeverityLevel.BLOCKER)
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
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
