package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillBox() {
        textBoxPage.openPage()
                .setFullName("Alex Volkanovsky")
                .setEmail("qwerty@mail.com")
                .setCurrentAddress("Las Vegas")
                .setPermanentAddress("Texas City")
                .submitButtonClick();


        textBoxPage.checkOutputVisible()
                .checkResult("Name:", "Alex   Volkanovsky")
                .checkResult("Email:", "qwerty@mail.com" )
                .checkResult("Current Address :", "Las Vegas")
                .checkResult("Permananet Address :", "Texas City");


    }


}
