package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.Element;
import edu.bsuir.elements.candidatepageelements.CandidatePageElements;
import edu.bsuir.helper.Helper;
import edu.bsuir.pages.CandidatePage;
import edu.bsuir.pages.LoginPage;
import edu.bsuir.pages.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
/*
* Следуюет протестировать поиск по каждой критерии, а также комбинации (?)
* Также, проверить действительно ли все данные из БД находятся по нужным притериям
*/
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
    public void checkTitles() throws InterruptedException {
        candidatePage.getFiltersTitles();
    }

    @Test
    public void checkSearchCandidateByWorkExperience() throws InterruptedException {
        candidatePage.searchCandidateByWorkExperience();
        Element searchTags = new Element("От 1 года", By.xpath("//*[@id=\"experience_filter-tag\"]"));
        Assert.assertTrue(searchTags.isElementPresent());
    }

    @Test
    public void checkVacancySearch()throws InterruptedException{
        candidatePage.vacancyMenu();
        Element searchVacancyByInput = new Element("Дизайнр", By.xpath("//*[@id=\"yui_patched_v3_11_0_3_1523163188287_2821\"]/li[2]/div/label"));
        Assert.assertEquals(searchVacancyByInput.getElementText(),"Дизайнер");
    }

    @Test
    public void checkSearchCandidatesByStatus() throws InterruptedException {
        candidatePage.checkStatusFilter();
        Thread.sleep(1000);
        Element searchStatusTags = new Element("Новый", By.xpath("//*[@id=\"status_New-tag\"]"));
        Assert.assertTrue(searchStatusTags.isElementPresent());
    }

    @Test // Проверка сообщения "Поиск не дал резузультатов" при поиске вакансии
    public void checkVacancySearchNoResults(){ }
    @Test // Проверка сообщения "Поиск не дал резузультатов" при поиске бразования
    public void checkEducationSearchNoResults(){ }
    @Test // Проверка сообщения "Поиск не дал резузультатов" при поиске компетенции
    public void checkCompetenceSearchNoResults(){ }
    @Test // Проверка сообщения "Поиск не дал резузультатов" при поиске университета
    public void checkUnversitySearchNoResults(){ }

    @Test
    public void checkRelocationCheckboxes() throws InterruptedException {
        candidatePage.relocationAvailable();
        Element relocationAvailableTag = new Element("возможен переезд", By.xpath("//*[@id=\"relocation_Available-tag\"]"));
        Assert.assertTrue(relocationAvailableTag.isElementPresent());
    }

    @Test
    public void findCandidateByName() throws InterruptedException {
        candidatePage.getCandidatesPage();
        Helper.wait(5);
        candidatePage.findCandidate("Иван");
        Helper.wait(3);
        Element resultFIO = new Element("FIO", CandidatePageElements.SEARCH_RESULT_FIO);
        Assert.assertEquals("Степанец Иван Олегович",resultFIO.getElementText());
    }

    @After
    public void closeTest() {
        WebDriverSingleton.destroyInstance();
    }
}
