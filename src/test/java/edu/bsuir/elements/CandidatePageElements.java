package edu.bsuir.elements;

import org.openqa.selenium.By;

public class CandidatePageElements {
    public static String URL = "http://testing.cld.iba.by/web/guest/recruiting/candidates";

    public static By FILTER_CLEAN = By.id("filter-clear-link");

    public static By WORK_EXPERIENCE_NO = By.xpath("//select[@id='experience']//option[@value='0']");
    public static By WORK_EXPERIENCE_FROM_ONE_YEAR = By.xpath("//select[@id='experience']//option[@value='12']");
    public static By WORK_EXPERIENCE_FROM_THREE_YEAR = By.xpath("//select[@id='experience']//option[@value='36']");
    public static By WORK_EXPERIENCE_FROM_FIVE_YEAR = By.xpath("//select[@id='experience']//option[@value='60']");

    public static By STATUS_NEW = By.xpath("//*[@id=\"status_New\"]");
    public static By STATUS_ON_APPROVAL = By.xpath("//*[@id=\"status_OnApprovalForTheVacancy\"]");
    public static By STATUS_AVAILABLE_FOR_APPROVAL = By.xpath("//*[@id=\"status_AvailableForApproval\"]");
    public static By STATUS_HIRED = By.xpath("//*[@id=\"status_Hired\"]");

    public static By VACANCY_SELECT = By.xpath("//*[@id=\"yui_patched_v3_11_0_3_1522839949782_832\"]");
    public static By VACANCY_SEARCH_INPUT_FIELD = By.id("searchInput");

}
