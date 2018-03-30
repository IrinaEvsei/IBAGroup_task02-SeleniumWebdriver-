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
import sun.awt.windows.WEmbeddedFrame;


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
    public void addApplication(){
        driver.get("http://testing.cld.iba.by/web/guest/recruiting");
        WebElement request = driver.findElement(By.xpath("//*[@id=\"addRequest\"]/div[2]/div[2]/a"));
        request.click();
        Assert.assertEquals("Создание заявки на подбор персонала - Конструктор Талантов",driver.getTitle());
    }

    @Test
    public void createApplication(){
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/applications/-/applications/createApplication");

        WebElement position = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        position.sendKeys("Дизайнер");

        WebElement plannedClosingDate = driver.findElement(By.xpath("//*[@id=\"plannedClosingDate\"]"));
        plannedClosingDate.sendKeys("11.04.2018");

        WebElement priorityRadioBtn = driver.findElement(By.xpath("//*[@id=\"priority-1\"]"));
        priorityRadioBtn.click();

        WebElement quantity = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
        quantity.sendKeys("2");

        WebElement creationReason = driver.findElement(By.xpath("//*[@id=\"creationReason\"]"));
        creationReason.sendKeys("НАМ НУЖНЫ ДИЗАЙНЕРЫ !");

        WebElement type = driver.findElement(By.xpath("//*[@id=\"contractType-2\"]"));
        type.click();

        WebElement salary = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        salary.sendKeys("500");

        WebElement employees = driver.findElement(By.xpath("//*[@id=\"employees\"]"));
        employees.sendKeys("Присутсвуют");

        WebElement businessTrip = driver.findElement(By.xpath("//*[@id=\"businessTrip\"]"));
        businessTrip.sendKeys("США, 3 месяца");

        WebElement timetable = driver.findElement(By.xpath("//*[@id=\"timetable\"]"));
        timetable.sendKeys("40 часов");

        WebElement probationPeriod = driver.findElement(By.xpath("//*[@id=\"probationPeriod\"]"));
        probationPeriod.sendKeys("2 месяца");

        WebElement responsibilities = driver.findElement(By.xpath("//*[@id=\"responsibilities\"]"));
        responsibilities.sendKeys("WORK HARD,  PLAY HARD");

        WebElement candidateType = driver.findElement(By.xpath("//*[@id=\"candidateTypeInternal\"]"));
        candidateType.click();

        WebElement educationSpecialization = driver.findElement(By.xpath("//*[@id=\"educationSpecialization\"]"));
        educationSpecialization.sendKeys("Студенты 3-4 курса приветствуются");

        WebElement priorityWorkingExperience = driver.findElement(By.xpath("//*[@id=\"priority.working.experience\"]"));
        priorityWorkingExperience.sendKeys("не имеет значения");

        WebElement undesirableWorkingExperience = driver.findElement(By.xpath("//*[@id=\"undesirableWorkingExperience\"]"));
        undesirableWorkingExperience.sendKeys("не имеет значения");

        WebElement editrequiredCompetence = driver.findElement(By.xpath("//*[@id=\"editrequiredCompetence\"]"));
        editrequiredCompetence.click();
        WebElement input = driver.findElement(By.xpath("//*[@id=\"searchCompetenceWord\"]"));
        input.sendKeys("Обучаемость");
        WebElement addCompetence = driver.findElement(By.cssSelector("//*[contains(@class, 'icon-arrow-right')]\n"));
        addCompetence.click();
//        WebElement basicCompetence = driver.findElement(By.xpath("//*[@id=\"category_22\"]"));
//        basicCompetence.click();
//        WebElement addCompetence = driver.findElement(By.xpath("//*[@id=\"yui_patched_v3_11_0_3_1522413201989_8743\"]"));
//        addCompetence.click();
        WebElement modalOkBtn = driver.findElement(By.xpath("//*[@id=\"yui_patched_v3_11_0_3_1522413201989_8910\"]"));
        modalOkBtn.click();

        WebElement comment = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
        comment.sendKeys("Нам нужны самые-самые! =)");

        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"save\"]"));
        saveBtn.click();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"successMessage\"]"));
        Assert.assertEquals("Заявка успешно сохранена",message.getText());
    }
}
