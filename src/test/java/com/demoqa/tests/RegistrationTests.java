package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    @Test
    public void successfulRegistrationTest() {

        Student student = new Student();
        RegistrationPage registrationPage = new RegistrationPage();

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
                .setCity(student.city)
                .submit();
        registrationPage.verifyModalAppears()
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

        sleep(5000);

    }
}
