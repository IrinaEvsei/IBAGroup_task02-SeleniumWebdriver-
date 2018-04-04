package edu.bsuir.test.old;

import edu.bsuir.pages.old.ApplicationPage;
import org.junit.Test;

public class ApplicationPageTest extends LoginPageTest {
    ApplicationPage applicationPage = new ApplicationPage();

    @Test
    public void testCreationOfApplication() {
        loginPage.getLoginPage();
        loginPage.typeLogin("kabanov@tc.by");
        loginPage.typePassword("welcome");
        loginPage.clickLoginButton();

        applicationPage.getApplicationPage();
        applicationPage.setName("Дизайнер");
        applicationPage.setClosingDate("11.04.2018");
        applicationPage.setPriority("средний");
        applicationPage.setSalary("500");
        applicationPage.setSalaryType("USD");
        applicationPage.setContractType("Контракт");
        applicationPage.setScheduleType("Стажировка");
        applicationPage.setEmployees("Присутсвуют");
        applicationPage.setBusinessTrip("США, 3 месяца");
        applicationPage.setTimetable("40 часов");
        applicationPage.setProbationPeriod("2 месяца");
        applicationPage.setResponsibilities("WORK HARD,  PLAY HARD");
        applicationPage.setCreationReason("НАМ НУЖНЫ ДИЗАЙНЕРЫ !");
        applicationPage.setCandidateType("Внутренний");
        applicationPage.setEducationLevel("Не имеет значения");
        applicationPage.setEducationSpecialization("Студенты 3-4 курса приветствуются");
        applicationPage.setUndesirableWorkExperience("не имеет значения");
        applicationPage.setCompetences();
        applicationPage.saveApplication();
    }
}
