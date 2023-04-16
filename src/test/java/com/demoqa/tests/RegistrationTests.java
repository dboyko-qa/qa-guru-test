package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    @Test
    public void successfulRegistrationTest() {

        Student student = new Student();

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
        registrationPage.verifyResult(student);
        sleep(5000);

    }
}
