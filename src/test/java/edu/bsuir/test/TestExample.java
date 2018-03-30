package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestExample {

    private WebDriver driver = WebDriverSingleton.getInstance();

    @Before
    public void login() {
        driver.get("http://testing.cld.iba.by/");
        WebElement login = driver.findElement(By.id("_58_login")) ;
        WebElement password = driver.findElement(By.id("_58_password"));
        WebElement button = driver.findElement(By.xpath("//div[@class = 'button-holder ']//button"));

        login.sendKeys("kabanov@tc.by");
        password.sendKeys("welcome");
        button.click();

        WebElement userName = driver.findElement(By.xpath("//div[@class = 'float-box']//div//h3"));

        Assert.assertEquals("Александр Евгеньевич Кабанов", userName.getText());

    }

    @Test
    public void findApplication () {
        driver.get("http://testing.cld.iba.by/");
        WebElement cell = driver.findElement(By.xpath("//a[@href = 'http://testing.cld.iba.by/web/guest/recruiting']"));
        cell.click();
        Assert.assertEquals("Подбор и адаптация - Конструктор Талантов", driver.getTitle());
    }

    @Test
    public void createRequest(){
        driver.get("http://testing.cld.iba.by/web/guest/recruiting");
        WebElement request = driver.findElement(By.xpath("//*[@id=\"addRequest\"]/div[2]/div[2]/a"));
        request.click();
        Assert.assertEquals("Создание заявки на подбор персонала - Конструктор Талантов",driver.getTitle());
    }
}
