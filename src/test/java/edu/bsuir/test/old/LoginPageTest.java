package edu.bsuir.test.old;

import edu.bsuir.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void testLogin() {
        loginPage.getLoginPage();
        loginPage.typeLogin("kabanov@tc.by");
        loginPage.typePassword("welcome");
        loginPage.clickLoginButton();
        Assert.assertEquals("Главная - Конструктор Талантов", loginPage.getTitle());
    }
}
