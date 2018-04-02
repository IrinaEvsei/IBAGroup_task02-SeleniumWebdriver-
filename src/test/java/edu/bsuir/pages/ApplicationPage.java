package edu.bsuir.pages;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.ApplicationPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ApplicationPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void setName(String name) {
        WebElement element = driver.findElement(ApplicationPageElements.NAME);
        element.sendKeys(name);
    }

    public void setClosingDate(String date) {
        WebElement element = driver.findElement(ApplicationPageElements.PLANNED_CLOSING_DATE);
        element.sendKeys(date);

    }

    public void setPriority(String priority) {
        if (priority == "низкий") {
            WebElement element = driver.findElement(ApplicationPageElements.PRIORITY_LOW);
            element.click();
        }
        if (priority == "средний") {
            WebElement element = driver.findElement(ApplicationPageElements.PRIORITY_MIDDLE);
            element.click();
        }
        if (priority == "высокий") {
            WebElement element = driver.findElement(ApplicationPageElements.PRIORITY_HIGH);
            element.click();
        }

    }

    public void setSalary(String salary) {
        WebElement element = driver.findElement(ApplicationPageElements.SALARY);
        element.sendKeys(salary);
    }

    public void setSalaryType(String salaryType) {
        if (salaryType == "BEL") {
            WebElement element = driver.findElement(ApplicationPageElements.SALARY_TYPE_BEL);
            element.click();
        }
        if (salaryType == "RUS") {
            WebElement element = driver.findElement(ApplicationPageElements.SALARY_TYPE_RUS);
            element.click();
        }
        if (salaryType == "USD") {
            WebElement element = driver.findElement(ApplicationPageElements.SALARY_TYPE_USD);
            element.click();
        }
        if (salaryType == "EUR") {
            WebElement element = driver.findElement(ApplicationPageElements.SALARY_TYPE_EUR);
            element.click();
        }
    }

    public void setContractType(String contractType) {
        if (contractType == "Трудовой договор") {
            WebElement element = driver.findElement(ApplicationPageElements.CONTRACT_TYPE_0);
            element.click();
        }
        if (contractType == "Договор подряда") {
            WebElement element = driver.findElement(ApplicationPageElements.CONTRACT_TYPE_1);
            element.click();
        }
        if (contractType == "Контракт") {
            WebElement element = driver.findElement(ApplicationPageElements.CONTRACT_TYPE_2);
            element.click();
        }
    }

    public void setScheduleType(String scheduleType) {
        if (scheduleType == "Полная занятость") {
            WebElement element = driver.findElement(ApplicationPageElements.SCHEDULE_TYPE_1);
            element.click();
        }
        if (scheduleType == "Частичная занятость") {
            WebElement element = driver.findElement(ApplicationPageElements.SCHEDULE_TYPE_2);
            element.click();
        }
        if (scheduleType == "Проектная занятость") {
            WebElement element = driver.findElement(ApplicationPageElements.SCHEDULE_TYPE_3);
            element.click();
        }
        if (scheduleType == "Стажировка") {
            WebElement element = driver.findElement(ApplicationPageElements.SCHEDULE_TYPE_4);
            element.click();
        }
    }

    public void setEmployees(String employees) {
        WebElement element = driver.findElement(ApplicationPageElements.EMPLOYEES);
        element.sendKeys(employees);
    }

    public void setBusinessTrip(String businessTrip) {
        WebElement element = driver.findElement(ApplicationPageElements.BUSINESS_TRIP);
        element.sendKeys(businessTrip);
    }

    public void setTimetable(String timetable) {
        WebElement element = driver.findElement(ApplicationPageElements.TIMETABLE);
        element.sendKeys(timetable);
    }

    public void setProbationPeriod(String probationPeriod) {
        WebElement element = driver.findElement(ApplicationPageElements.PROBATION_PERIOD);
        element.sendKeys(probationPeriod);

    }

    public void setResponsibilities(String responsibilities) {
        WebElement element = driver.findElement(ApplicationPageElements.RESPONSIBILITIES);
        element.sendKeys(responsibilities);

    }

    public void setCreationReason(String reason) {
        WebElement element = driver.findElement(ApplicationPageElements.CREATION_REASON);
        element.sendKeys(reason);

    }

    public void setCandidateType(String candidateType) {
        if (candidateType == "Внешний") {
            WebElement element = driver.findElement(By.id("candidateTypeInternal"));
            element.click();
        } else if (candidateType == "Внутренний") {
            WebElement element = driver.findElement(ApplicationPageElements.CANDIDATE_TYPE_INTERNAL);
            element.click();
        }
    }

    public void setEducationLevel(String educationLevel) {
        if (educationLevel == "Не имеет значения") {
            WebElement element = driver.findElement(ApplicationPageElements.EDUCATION_LEVEL_NO);
            element.click();
        }
        if (educationLevel == "Общеее среднее") {
            WebElement element = driver.findElement(ApplicationPageElements.EDUCATION_LEVEL_1);
            element.click();
        }
        if (educationLevel == "Проефессионально-техническое") {
            WebElement element = driver.findElement(ApplicationPageElements.EDUCATION_LEVEL_2);
            element.click();
        }
        if (educationLevel == "Среднее специальное") {
            WebElement element = driver.findElement(ApplicationPageElements.EDUCATION_LEVEL_3);
            element.click();
        }

        if (educationLevel == "Высшее") {
            WebElement element = driver.findElement(ApplicationPageElements.EDUCATION_LEVEL_4);
            element.click();
        }
    }

    public void setEducationSpecialization(String educationSpecialization) {
        WebElement element = driver.findElement(ApplicationPageElements.EDUCATION_SPECIALIZATION);
        element.sendKeys(educationSpecialization);
    }
    public void setUndesirableWorkExperience(String undesirableWorkExperience) {
        WebElement element = driver.findElement(ApplicationPageElements.UNDESIRABLE_WORKING_EXPERIENCE);
        element.sendKeys(undesirableWorkExperience);

    }
    public void setCompetences() {
        WebElement element = driver.findElement(ApplicationPageElements.EDIT_REQUIRED_COMPETENCE_BUTTON);
        element.click();
        WebElement element1 = driver.findElement(ApplicationPageElements.MS_OFFICE);
        element1.click();
        WebElement element2 = driver.findElement(ApplicationPageElements.MS_EXCEL);
        WebElement okButton = driver.findElement(By.xpath("//button[text() = 'OK']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element2);
        actions.click(okButton);
        actions.perform();
    }
    public void saveApplication() {
        WebElement element = driver.findElement(ApplicationPageElements.SAVE_BUTTON);
        Actions actions = new Actions(driver);
        actions.doubleClick(element);
        actions.perform();
    }
    public void getApplicationPage() {
        driver.get(ApplicationPageElements.URL);
    }
}
