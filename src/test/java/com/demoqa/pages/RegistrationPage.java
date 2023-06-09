package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultModalComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private CalendarComponent calendar = new CalendarComponent();
    private ResultModalComponent resultModalComponent = new ResultModalComponent();
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement genderCheckbox = $("#genterWrapper");
    private SelenideElement hobbyCheckbox = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement submitButton =$("#submit");
    private SelenideElement stateInput = $("#state");
    private SelenideElement statesList =$("#stateCity-wrapper");
    private SelenideElement cityInput =$("#city");
    private SelenideElement citiesList =$("#stateCity-wrapper");


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        removeFooterBanner();
        return this;
    }

    public RegistrationPage removeFooterBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName (String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName (String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail (String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserNumber (String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setSubject (String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setGender (String value){
        genderCheckbox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setHobby (String value){
        hobbyCheckbox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture (String value){
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress (String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState (String value){
        stateInput.click();
        statesList.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value){
        cityInput.click();
        citiesList.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit (){
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyModalAppears(){
        resultModalComponent.verifyAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultModalComponent.verifyValueInTable(key, value);
        return this;
    }
}
