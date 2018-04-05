package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.Element;
import edu.bsuir.pages.ApplicationPage;
import edu.bsuir.pages.CandidatePage;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.pages.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ApplicationPageTest {
    LoginPage lp3 = new LoginPage();
    MenuPage mp2 = new MenuPage();
    ApplicationPage applicationPage = new ApplicationPage();

    @Before
    public void loginTest3(){
        lp3.getLoginPage();
        lp3.typeLogin("kabanov@tc.by");
        lp3.typePassword("welcome");
        lp3.clickLoginButton();
        Assert.assertEquals("Главная - Конструктор Талантов", lp3.getTitle());
    }

    @Test
    public void menuTest3(){
        mp2.openSidebar();
        mp2.clickRecruiting();
        Element message = new Element("Кандидаты", By.xpath("//*[@id=\"content\"]/div[1]"));
        Assert.assertTrue(message.isElementPresent());
    }
    @Test
    public void createApplication() throws Exception {
        applicationPage.application();
    }

    @After
    public void closeTest() {
        WebDriverSingleton.destroyInstance();
    }
}
