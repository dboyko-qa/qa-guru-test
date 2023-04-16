package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.tests.Student;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {

    public SelenideElement userNameInput =$("#userName"),
    userEmailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress");

    public TextBoxPage setUserName(String value){
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail (String value){
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setcurrentAddress (String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setpermanentAddress (String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit (){
        $("#submit").click();
        return this;
    }

    private void verifyResultLine(String key, String value){
        $("#output").$("#" + key).shouldHave(text(value));
    }

    public TextBoxPage verifyResult(Student student) {
        verifyResultLine("name", student.lastName);
        verifyResultLine("email", student.userEmail);
        verifyResultLine("currentAddress", student.currentAddress);
        verifyResultLine("permanentAddress", student.currentAddress);
        return this;
}

}
