package properties.tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Test;
import tests.RegistrationTestData;
import tests.TestBase;

public class SystemPropertiesTests extends TestBase {
    //
//    // Задаем значение
//    @Test
//    void systemPropertiesTest() {
//        System.setProperty("browser", "chrome");
//        String browser = System.getProperty("browser");
//        System.out.println(browser);
//    }
//
//    @Test
//    void systemProperties1Test() {
//        String browser = System.getProperty("browser", "mozilla");
//        System.out.println(browser);
//    }
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationTestData rtd = new RegistrationTestData();

    @Test
    @Tag("halfTest")
    void halfTest() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);


        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill for", () -> {
            registrationPage.setFirstName(rtd.firstName)
                    .setLastName(rtd.lastName)
                    .setEmail(rtd.email)
                    .setGender(rtd.gender)
                    .setPhoneNumber(rtd.phoneNumber)
                    .setDateOfBirth(rtd.birthDay, rtd.birthMonth, rtd.birthYear)
                    .setSubjects(rtd.subjects)
                    .setHobbies(rtd.hobbies)
                    .uploadPicture(rtd.picturePath)
                    .setCurrentAddress(rtd.currentAddress)
                    .setState(rtd.state)
                    .setCity(rtd.city)
                    .clickSubmit();
        });


    }
}



