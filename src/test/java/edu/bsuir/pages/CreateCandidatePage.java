package edu.bsuir.pages;

import com.sun.org.apache.bcel.internal.generic.Select;
import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.candidatepageelements.CreateCandidatePageElements;
import org.openqa.selenium.WebDriver;

public class CreateCandidatePage {
    WebDriver driver =  WebDriverSingleton.getInstance();

    public void goToCandidateCreationPage(){
        driver.get(CreateCandidatePageElements.URL);
    }

    //-----------------ButtonsBar---------------//
    public void clickBackToListLink(){
        CreateCandidatePageElements.BACK_TO_LIST.clickElement();
    }
    public void clickSaveButton(){
        CreateCandidatePageElements.SAVE_BUTTON.clickElement();
    }
    //------------//
    public void enterName(String argument){ CreateCandidatePageElements.NAME.typeText(argument); }
    public void enterSurname(String argument){ CreateCandidatePageElements.SURNAME.typeText(argument); }
    public void enterSecondName(String argument){ CreateCandidatePageElements.SECOND_NAME.typeText(argument); }
    public void enterCountry(String argument){ CreateCandidatePageElements.COUNTRY.typeText(argument); }
    public void enterCity(String argument){ CreateCandidatePageElements.CITY.typeText(argument); }
    public void enterPhone(String argument){ CreateCandidatePageElements.PHONE.typeText(argument); }
    public void enterEmail(String argument){ CreateCandidatePageElements.EMAIL.typeText(argument); }
    public void enterSkype(String argument){ CreateCandidatePageElements.SKYPE.typeText(argument); }
    public void clickRelocationCheckbox(){ CreateCandidatePageElements.RELOCATION_CHECKBOX.clickElement(); }
    public void enterBirthDay(String argument){ CreateCandidatePageElements.DATE_OF_BIRTH_DAY.typeText(argument); }
    public void enterBirthMonth(String argument){ CreateCandidatePageElements.DATE_OF_BIRTH_MONTH.typeText(argument); }
    public void enterBirthYear(String argument){ CreateCandidatePageElements.DATE_OF_BIRTH_YEAR.typeText(argument); }

    public void enterDesiredPosition(String argument){ CreateCandidatePageElements.DESIRED_POSITION.typeText(argument); }
    public void enterAdditionalInfo(String argument){ CreateCandidatePageElements.ADDITIONAL_INFO.typeText(argument); }
    public void enterEditCompetenceButton(){ CreateCandidatePageElements.EDIT_COMPETENCE_BUTTON.clickElement(); }


    public void clickCompetenceTab(){ CreateCandidatePageElements.COMPETENCE_TAB.clickElement(); }
    public void clickEducationTab(){ CreateCandidatePageElements.EDUCATION_TAB.clickElement(); }
    public void clickExperienceTab(){ CreateCandidatePageElements.EXPERIENCE_TAB.clickElement(); }
    public void clickMotivationTab(){ CreateCandidatePageElements.MOTIVATION_TAB.clickElement(); }
    public void clickRecommendationsTab(){ CreateCandidatePageElements.RECOMENDATIONS_TAB.clickElement(); }

    public void clickAddEducation(){ CreateCandidatePageElements.ADD_EDUCATION_INFO_BUTTON.clickElement(); }
    public void clickDeleteEducation(){ CreateCandidatePageElements.DELETE_EDUCATION_INFO_BUTTON.clickElement(); }
    public void enterUniversity(String argument){ CreateCandidatePageElements.UNIVERSITY_FIELD.typeText(argument); }
    public void enterFaculty(String argument){ CreateCandidatePageElements.FACULTY_FIELD.typeText(argument); }
    public void enterSpecialization(String argument){ CreateCandidatePageElements.SPECIALIZATION_FIELD.typeText(argument); }

    public void clickAddExperience(){ CreateCandidatePageElements.ADD_EXPERIENCE_INFO_BUTTON.clickElement(); }
    public void clickDeleteExperience(){ CreateCandidatePageElements.DELETE_EXPERIENCE_INFO_BUTTON.clickElement(); }
    public void enterPosition(String argument){ CreateCandidatePageElements.EXP_POSITION.typeText(argument); }
    public void enterCompany(String argument){ CreateCandidatePageElements.EXP_COMPANY.typeText(argument); }
    public void enterDescription(String argument){ CreateCandidatePageElements.EXP_DESCRIPTION.typeText(argument); }

    public void clickTillNowCheckbox(){ CreateCandidatePageElements.EXP_TILL_NOW_CHECKBOX.clickElement(); }


    public void clickAddRecommendation(){ CreateCandidatePageElements.ADD_RECOMENDATIONS_INFO_BUTTON.clickElement(); }
    public void clickDeleteRecommendation(){ CreateCandidatePageElements.DELETE_RECOMENDATIONS_INFO_BUTTON.clickElement(); }
    public void enterRecommendationName(String argument){ CreateCandidatePageElements.RECOMMENDATION_NAME.typeText(argument); }
    public void enterRecommendationPosition(String argument){ CreateCandidatePageElements.RECOMMENDATION_POSITION.typeText(argument); }
    public void enterRecommendationCompany(String argument){ CreateCandidatePageElements.RECOMMENDATION_COMPANY.typeText(argument); }
    public void enterRecommendationPhone(String argument){ CreateCandidatePageElements.RECOMMENDATION_PHONE.typeText(argument); }

    public String readErrorMessage(){ return CreateCandidatePageElements.ERROR_MESSAGE.getElementText(); }
    public String readWrongTelephone(){ return CreateCandidatePageElements.WRONG_TELEPHONE.getElementText();}
    public String readWrongEmail(){ return CreateCandidatePageElements.WRONG_EMAIL.getElementText();}
}
