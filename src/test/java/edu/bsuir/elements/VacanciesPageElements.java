package edu.bsuir.elements;

import org.openqa.selenium.By;

public class VacanciesPageElements {
    public static final Element CREATE_VACANCY_BTN = new Element("Создать вакансию",
            By.xpath("//a[@id = 'createVacancyButton']"));
    public static final Element SAVE_BTN = new Element("Сохранить",
            By.xpath("//a[@id = 'saveButton']"));
    public static final Element OPEN_VACANCY_BTN = new Element("Открыть вакансию",
            By.xpath("//a[@id = 'openButton']"));
    public static final Element SUCCESS_OPENED = new Element("Успешно открыта",
            By.xpath("//div[@class = 'message']//span[@id = 'successMessage']"));
    public static final Element SEARCH_VACANCY = new Element("Поиск вакансии",
            By.xpath("//input[@id = 'searchVacancyInput']"));
    public static final Element VACANCY = new Element("Вакансия",
            By.xpath("//a[@href = 'http://testing.cld.iba.by/web/guest/recruiting/vacancies/-/vacancies/51']"));
    public static final Element CANDIDATES_TAB = new Element("Кандидаты",
            By.xpath("//a[@href = '#candidates']"));
    public static final Element ADD_CANDIDATE_BTN = new Element("Добавить киндадита",
            By.xpath("//button[@id = 'addCandidateForShortlistButton']"));
    public static final Element SEARCH_CANDIDATE = new Element("Поиск",
            By.xpath("//input[@id = 'searchCandidateForShortlist']"));
    public static final Element CANDIDATE = new Element("Кандидат",
            By.xpath("//input[@id = '642']"));
    public static final Element OK_BTN = new Element("Добавить",
            By.xpath("//button[@id = 'btn-ok']"));

    public static final Element INTERVIEW_PLAN_TAB = new Element("План интервью",
            By.xpath("//a[@href = '#interviewPlan']"));
    public static final Element ADD_QUESTION = new Element("Добавить вопрос",
            By.xpath("//a[@id = 'addQuestionButton']"));
    public static final Element QUESTION_INPUT = new Element("Текст вопроса",
            By.xpath("//textarea[@id = 'questionText']"));
    public static final Element ANSWER_INPUT = new Element("Текст ответа",
            By.xpath("//textarea[@id = 'questionAnswer']"));
    public static final Element COMPETENCE_INPUT = new Element("Компетенция",
            By.xpath("//input[@class = 'ui-widget-content ui-autocomplete-input']"));
    public static final Element SAVE_QUESTION_BTN = new Element("Сохранить",
            By.xpath("//a[@id = 'saveQuestionButton']"));
    public static final Element PERSONAL_QUESTIONS = new Element("Персональные вопросы",
            By.xpath("//li[@id = 'personalTab']"));
    public static final Element ADD_QUESTION_BTN = new Element("Добавить",
            By.xpath("//a[@id = 'addBtn']"));
}
