package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    /// Elements
    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    userEmailInput = $("userEmail");

    /// ACTIONS
    public RegistrationPage openPage(String value) {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        titleLabel.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setdateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setdate("10", "05", "1999");
        return this;
    }



    public void clickFirstName() {
        firstNameInput.click();
    }
}
