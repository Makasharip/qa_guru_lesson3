package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {


        registrationPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Black")
                    .setEmail("murtazaliev@mail.com")
                    .setGender("Male")
                    .setUserNumber("Black")
                    .setdateOfBirth("10", "05", "1999");





        $("#userNumber").setValue("7928502600");

        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/picture.jpg");
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
                text("img/picture.jpg"),
                text("Address"),
                text("NCR Delhi")
        );
    }
}





