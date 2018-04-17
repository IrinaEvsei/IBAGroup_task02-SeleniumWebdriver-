package edu.bsuir.test;

import com.sun.org.glassfish.gmbal.Description;
import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.VacanciesPageElements;
import edu.bsuir.helper.Helper;
import edu.bsuir.pages.ApplicationPage;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.pages.MenuPage;
import edu.bsuir.pages.VacanciesPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class VacanciesPageTest {
    WebDriver driver = WebDriverSingleton.getInstance();
    private ApplicationPage applicationsPage = new ApplicationPage();
    private LoginPage lp = new LoginPage();
    private MenuPage mu = new MenuPage();
    private VacanciesPage vp = new VacanciesPage();

    @Before
    @Step("Авторизация")
    public void loginTest2(){
        lp.getLoginPage();
        lp.typeLogin("kabanov@tc.by");
        lp.typePassword("welcome");
        lp.clickLoginButton();
        Assert.assertEquals("Главная - Конструктор Талантов", lp.getTitle());
    }

    @Test
    @DisplayName("Создание вакансии")
    @Description("Переходим на страницу заявок, создаем вакансию, открываем её")
    @Feature("Вакансии")
    @Story("Сценарий - Создание и открытие вакансии")
    @Severity(SeverityLevel.BLOCKER)
    public void createVacancy() throws Exception {
       // login();
        Helper.wait(3);
//        mu.clickApplications();
        applicationsPage.application();
        Helper.wait(3);
        vp.createVacancy();
        vp.createVacancy();
        vp.openVacancy();
        Helper.wait(3);
        Assert.assertTrue(VacanciesPageElements.SUCCESS_OPENED.getElement().getText().equals("Вакансия была успешно открыта"));
    }
    @Test
    @DisplayName("Создание вакансии")
    @Description("Переходим на страницу вакансий, находим нужную, добавляем кандидата, добавляем вопросы")
    @Feature("Вакансии")
    @Story("Сценарий - Создание и открытие вакансии")
    @Severity(SeverityLevel.BLOCKER)
    public void editVacancyPage() throws InterruptedException {
        lp.getLoginPage();
        Helper.wait(3);
        mu.clickVacancies();
        vp.searchVacancy("Junior Java developer");
        vp.addVacancy("Иванов Иван Иванович");
        vp.addQuestions("Легко учишься?", "Да", "Обучаемость");
    }
}
