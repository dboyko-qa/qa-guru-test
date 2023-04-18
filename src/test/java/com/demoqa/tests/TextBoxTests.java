package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {
        open("/text-box");

        Student student = new Student();
        textBoxPage.setUserName(student.lastName)
                .setUserEmail(student.userEmail)
                .setcurrentAddress(student.currentAddress)
                .setpermanentAddress(student.currentAddress)
                .submit();
        textBoxPage.verifyResult("name", student.lastName)
                .verifyResult("email", student.userEmail)
                .verifyResult("currentAddress", student.currentAddress)
                .verifyResult("permanentAddress", student.currentAddress);


    }
}
