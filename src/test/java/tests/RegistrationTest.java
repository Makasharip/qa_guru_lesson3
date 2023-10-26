package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

   private final RegistrationPage registrationPage = new RegistrationPage();
   private final RegistrationTestData rtd = new RegistrationTestData();

    @Test
    @Tag("OnlyTest")
    void fillFormTest() {


        registrationPage.openPage()
                .setFirstName(rtd.firstName)
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

        registrationPage.verifyRegistrationResultsModalAppears()
                .checkResultModalTitleHaveMessage(rtd.completeSubmitMessage)
                .checkResult("Student Name", rtd.firstName + " " + rtd.lastName)
                .checkResult("Student Email", rtd.email)
                .checkResult("Gender", rtd.gender)
                .checkResult("Mobile", rtd.phoneNumber)
                .checkResult("Date of Birth", rtd.dateOfBirth)
                .checkResult("Subjects", String.join(", ", rtd.subjects))
                .checkResult("Hobbies", String.join(", ", rtd.hobbies))
                .checkResult("Picture", rtd.pictureName)
                .checkResult("Address", rtd.currentAddress)
                .checkResult("State and City", rtd.state + " " + rtd.city);
    }
}





