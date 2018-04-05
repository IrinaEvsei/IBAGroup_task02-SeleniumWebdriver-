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
        Element candidateVacancySearchInput = new Element("Поиск вакансия", CandidatePageElements.VACANCY_SEARCH_INPUT_FIELD);
        candidateVacancySearchInput.typeText("Дизанер");

        Element candidateRelocationAvailable = new Element("Возможен переезд", CandidatePageElements.RELOCATION_AVAILABLE);
        candidateRelocationAvailable.clickElement();

        Element candidateEducation = new Element("Образование", CandidatePageElements.EDUCATION_SELECT);
        candidateEducation.clickElement();
        Element candidateEducationHigher = new Element("БГУ", CandidatePageElements.EDUCATION_HIGHER);
        candidateEducationHigher.clickElement();

        Element candidateUniversity = new Element("Университет", CandidatePageElements.UNIVERSITY_SELECT);
        candidateUniversity.clickElement();
        Element candidateUniversityBSU = new Element("БГУ", CandidatePageElements.UNIVERSITY_BSU);
        candidateUniversityBSU.clickElement();

        Element  candidateCompetence = new Element("Компетенция", CandidatePageElements.COMPETENCE_SELECT);
        candidateCompetence.clickElement();
        Element candidateCompetenceEnglish = new Element("Английский язык", CandidatePageElements.COMPETENCE_ENGLISH);
        candidateCompetenceEnglish.clickElement();
    }
}
