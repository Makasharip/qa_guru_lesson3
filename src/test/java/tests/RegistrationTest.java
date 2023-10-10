package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {


        registrationPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Black")
                    .setEmail("sdfsdfdsfs@mail.com")
                    .setGender("Male")
                    .setUserNumber("7928502600")
                    .setDateOfBirth("10", "July", "1999")
                    .setSubjects("Arts")
                    .setHobby("Sports")
                    .uploadPicture("boris.jpg")
                    .setCurrentAddress("Kazan")
                    .setState("NCR")
                    .setCity("Delhi")
                    .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .checkTitle()
                .verifyResult("Student Name", "Alex Black")
                .verifyResult("Student Email", "sdfsdfdsfs@mail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "7928502600")
                .verifyResult("Date of Birth", "10 July,1999")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "boris.jpg")
                .verifyResult("Address", "Kazan")
                .verifyResult("State and City", "NCR Delhi");


    }
}





