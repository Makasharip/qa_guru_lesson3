package properties.tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    // Задаем значение
    @Test
    void systemPropertiesTest() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemProperties1Test() {
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }
    @Test
    @Tag ("property")
    void systemProperties2Test() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
    }
}
