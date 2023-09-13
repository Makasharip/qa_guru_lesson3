import com.codeborne.selenide.Configuration;
import org.checkerframework.common.aliasing.qual.MaybeLeaked;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Макашарип");
        $("#lastName").setValue("Муртазалиев");
        $("#userEmail").setValue("murtazaliev@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7928502600");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("June")).click();
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(
                text("Макашарип Муртазалиев"),
                text("murtazaliev@mail.com"),
                text("Male"),
                text("7928502600"),
                text("19 June,1997"),
                text("Physics"),
                text("Reading"),
                text("picture.jpg"),
                text("Address"),
                text("NCR Delhi")
        );
    }
}





