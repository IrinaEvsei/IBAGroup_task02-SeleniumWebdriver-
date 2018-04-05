package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.Element;
import edu.bsuir.pages.CandidatePage;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.pages.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class CandidatePageTest {
    LoginPage lp2 = new LoginPage();
    MenuPage mp1 = new MenuPage();
    CandidatePage candidatePage = new CandidatePage();

    @Before
    public void loginTest2(){
        lp2.getLoginPage();
        lp2.typeLogin("kabanov@tc.by");
        lp2.typePassword("welcome");
        lp2.clickLoginButton();
        Assert.assertEquals("Главная - Конструктор Талантов", lp2.getTitle());
    }

    @Test
    public void menuTest2(){
        mp1.openSidebar();
        mp1.clickCandidates();
        Element message = new Element("Кандидаты", By.xpath("//*[@id=\"content\"]/div[1]"));
        Assert.assertTrue(message.isElementPresent());
    }


    @Test
    public void searchCandidate() throws Exception {
        candidatePage.candidateFilter();
    }

    @After
    public void closeTest() {
        WebDriverSingleton.destroyInstance();
    }
}
