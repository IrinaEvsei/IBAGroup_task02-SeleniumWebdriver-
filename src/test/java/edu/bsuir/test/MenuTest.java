package edu.bsuir.test;

import edu.bsuir.elements.Element;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.pages.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class MenuTest {
    LoginPage lp = new LoginPage();
    MenuPage mp = new MenuPage();

    @Before
    public void loginTest2(){
        lp.getLoginPage();
        lp.typeLogin("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
        //Element errorMessage = new Element("Ваш запрос завершился с ошибкой.", By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Главная - Конструктор Талантов", lp.getTitle());

    }

    @Test
    public void MenuTest(){
        mp.openSidebar();
        mp.clickRecruiting();
        Element errorMessage = new Element("Заявки",By.xpath("//*[@id=\"content\"]/div[1]"));
        Assert.assertTrue(errorMessage.isElementPresent());
    }
}
