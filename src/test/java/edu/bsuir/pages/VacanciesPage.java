package edu.bsuir.pages;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.VacanciesPageElements;
import edu.bsuir.helper.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class VacanciesPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Клик на 'создание вакансии' ")
    public void createVacancyBtn() {
        VacanciesPageElements.CREATE_VACANCY_BTN.clickElement();
    }

    @Step("Создание вакансии")
    public void createVacancy() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        Helper.wait(3);
        VacanciesPageElements.SAVE_BTN.clickElement();
    }

    @Step("Открытие вакансии")
    public void openVacancy() throws InterruptedException {
        Helper.wait(3);
        VacanciesPageElements.OPEN_VACANCY_BTN.clickElement();
    }

    @Step("Ищем вакансию и переходим на её страницу")
    public void searchVacancy(String name) throws InterruptedException {
        VacanciesPageElements.SEARCH_VACANCY.typeText(name);
        Helper.wait(3);
        VacanciesPageElements.VACANCY.clickElement();
    }

    @Step("Добавить кандидата в список")
    public void addVacancy(String name) {
        VacanciesPageElements.CANDIDATES_TAB.clickElement();
        VacanciesPageElements.ADD_CANDIDATE_BTN.clickElement();
        VacanciesPageElements.SEARCH_CANDIDATE.typeText(name);
        VacanciesPageElements.CANDIDATE.getElement().click();
        VacanciesPageElements.OK_BTN.getElement().click();
    }

    @Step("Добавить вопрос к интервью")
    public void addQuestions(String question, String answer, String competence) throws InterruptedException {
        VacanciesPageElements.INTERVIEW_PLAN_TAB.clickElement();
        VacanciesPageElements.ADD_QUESTION_BTN.clickElement();
        Helper.wait(3);
        VacanciesPageElements.PERSONAL_QUESTIONS.clickElement();
        VacanciesPageElements.ADD_QUESTION_BTN.clickElement();
        Helper.wait(3);
        VacanciesPageElements.QUESTION_INPUT.typeText(question);
        VacanciesPageElements.ANSWER_INPUT.typeText(answer);
        VacanciesPageElements.COMPETENCE_INPUT.typeText(competence);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).perform();
        actions.click(VacanciesPageElements.SAVE_QUESTION_BTN.getElement()).perform();
    }
}
