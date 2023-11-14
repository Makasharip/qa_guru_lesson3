package pages;

import com.codeborne.selenide.Configuration;

public class TestConfiguration {



    public static void applyConfig() {

        //Configuration.baseUrl = "https://demoqa.com";
        String baseURL = com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.pageLoadStrategy = "eager";

        Configuration.baseUrl = System.getProperty("baseURL", "https://demoqa.com");
        Configuration.remote = System.getProperty("webDriverHost");
        String testBrowser = System.getProperty("browser", "chrome");
        String testVersion = System.getProperty("browserVersion", "113");
        String testWindowSize = System.getProperty("browserSize", "1920x1080");

        Configuration.browser = testBrowser;
        Configuration.browserSize = testWindowSize;
        Configuration.browserVersion = testVersion;
    }
}
