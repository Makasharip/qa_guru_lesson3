package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.ModalContentComponent;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    ResultsModal resultsModal = new ResultsModal();
    ModalContentComponent resultTable = new ModalContentComponent();


    /// Elements
    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    genderWrapper = $("#genterWrapper"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    phoneNumberInput = $("#userNumber"),
                    userEmailInput = $("#userEmail"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                    pictureInput = $("#uploadPicture"),
                    currentAddressInput = $("#currentAddress"),
                    stateInput = $("#state"),
                    cityInput = $("#city"),
                    stateAndCity = $("#stateCity-wrapper"),
                    submitButton = $("#submit");





    /// ACTIONS
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        removeBanner();
        return this;
    }

    private void removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage checkTitle() {
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
    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }



    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setdate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).sendKeys(Keys.ENTER);
        }
        return this;
    }
    public RegistrationPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateAndCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateAndCity.$(byText(value)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }
    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }


    public RegistrationPage checkResultModalTitleHaveMessage(String messages) {
        resultTable.checkTitleHaveMessage(messages);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }




}
