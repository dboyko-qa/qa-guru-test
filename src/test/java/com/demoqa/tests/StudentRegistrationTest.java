package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationTest extends TestBase {

    @Test
    void studentRegistrationTest(){

        //information about student
        String firstName = "Wednesday";
        String lastName = "Adams";
        String userEmail = "wedadams@nevermore.com";
        String gender = "Female";
        String userNumber = "1234567890";
        String dateOfBirthInput = "10.05.2007"; //MM.dd.yyy
        String dateOfBirthFullFormat = "05 October,2007";
        String subject = "Maths";
        String[] hobbies = {"Sports", "Reading"};
        String imgFileName = "pic.png";
        String currentAddress = "1 New York St";
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        open("/automation-practice-form");

        //remove banners and footer because Submit button is not visible under them
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");

        //fill in fields
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        $("#dateOfBirthInput").sendKeys(dateOfBirthInput);
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsInput").setValue(subject).pressEnter();

        for (String hobby: hobbies){
            $("#hobbiesWrapper").$(byText(hobby)).click();
        }

        $("#uploadPicture").uploadFromClasspath(imgFileName);

        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();

        $("#submit").click();

        //verify that output modal window contains all entered student's information
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName),
                text(lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text(dateOfBirthFullFormat),
                text(subject),
                text(hobbies[0]),
                text(hobbies[1]),
                text(imgFileName),
                text(currentAddress),
                text(city),
                text(state)
        );

    }
}
