package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    final String FORM_HEADER = "Thanks for submitting the form";

    private SelenideElement modal = $(".modal-dialog"),
    title = $("#example-modal-sizes-title-lg"),
    table = $(".table-responsive");

    public ResultModal verifyAppears(){
        modal.should(appear);
        title.shouldHave(text(FORM_HEADER));

        return this;
    }

    public ResultModal verifyValueInTable(String key, String value) {
        table.$(byText(key)).sibling(0).shouldHave(exactText(value));

        return this;
    }
}
