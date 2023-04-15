package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    @Test
    public void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(student.firstName)
                .setLastName(student.lastName)
                .setUserEmail(student.userEmail)
                .setUserNumber(student.userNumber)
                .setSubject(student.subject)
                .setGender(student.gender)
                .setBirthDate(student.dateOfBirthDay, student.dateOfBirthMonth, student.dateOfBirthYear)
                .setHobby(student.hobby)
                .uploadPicture(student.imgFileName)
                .setCurrentAddress(student.currentAddress)
                .setState(student.state)
                .setCity(student.city);

        registrationPage.submit()
                .verifyResult(student);
        sleep(5000);

        /*
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
*/

//        $("#firstName").setValue("Alex");
//        $("#lastName").setValue("Egorov");
//        $("#userEmail").setValue("alex@egorov.com");
//        $("#genterWrapper").$(byText("Other")).click();
//        $("#userNumber").setValue("1234567890");
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $("#subjectsInput").setValue("Math").pressEnter();
//        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFromClasspath(student.imgFileName);
//        $("#currentAddress").setValue("Some address 1");
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Delhi")).click();
//        $("#submit").click();


//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//       $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
//                text("alex@egorov.com"), text("1234567890"));

    }
}
