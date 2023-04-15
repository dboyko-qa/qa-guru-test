package com.demoqa.pages.components;

import com.demoqa.tests.Student;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    public ResultModal verifyAppears(){
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public ResultModal verifyResult(String key, String value) {
        $(".table-responsive")
                .$(byText(key))
                .sibling(0)
                .shouldHave(exactText(value));

        return this;
    }
}
