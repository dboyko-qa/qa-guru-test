package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Student student = new Student();
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize = "1920x1080";
    }
}
