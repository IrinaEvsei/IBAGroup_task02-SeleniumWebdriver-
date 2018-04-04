package edu.bsuir.pages;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.Element;
import edu.bsuir.elements.CandidatePageElements;

public class CandidatePage {
    public void candidateFilter() throws Exception {
        WebDriverSingleton.getInstance().get(CandidatePageElements.URL);

        Element candidateFilterClean = new Element("ФИЛЬТР", CandidatePageElements.FILTER_CLEAN);
        candidateFilterClean.clickElement();

        Element candidateWorkExperience = new Element("Опыт работы", CandidatePageElements.WORK_EXPERIENCE_NO);
        candidateWorkExperience.clickElement();

        Element candidateStatus = new Element("Статус", CandidatePageElements.STATUS_NEW);
        candidateStatus.clickElement();

        Element candidateVacancy = new Element("Вакансия", CandidatePageElements.VACANCY_SELECT);
        candidateVacancy.clickElement();

        Element candidateVacancySearchInput = new Element("Вакансия", CandidatePageElements.VACANCY_SEARCH_INPUT_FIELD);

    }
}
