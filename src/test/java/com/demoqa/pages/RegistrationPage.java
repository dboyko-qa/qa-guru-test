package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultModal;
import com.demoqa.tests.Student;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private CalendarComponent calendar = new CalendarComponent();
    private ResultModal resultModal = new ResultModal();
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement genderCheckbox = $("#genterWrapper");
    private SelenideElement hobbyCheckbox = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
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
        $("#dateOfBirthInput").click();
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
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit (){
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyResult(Student student) {
        resultModal.verifyAppears()
                .verifyResult("Student Name", student.firstName + " " + student.lastName)
                .verifyResult("Student Email", student.userEmail)
                .verifyResult("Gender", student.gender)
                .verifyResult("Mobile", student.userNumber)
                .verifyResult("Date of Birth", student.dateOfBirthFullFormat)
                .verifyResult("Subjects", student.subject)
                .verifyResult("Hobbies", student.hobby)
                .verifyResult("Picture", student.imgFileName)
                .verifyResult("Address", student.currentAddress)
                .verifyResult("State and City", student.state + " " + student.city);

        return this;
    }
}
