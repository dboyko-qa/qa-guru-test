package com.demoqa.tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");

        Student student = new Student();
        textBoxPage.setUserName(student.lastName)
                .setUserEmail(student.userEmail)
                .setcurrentAddress(student.currentAddress)
                .setpermanentAddress(student.currentAddress)
                .submit();
        textBoxPage.verifyResult(student);

    }
}
