package properties;

import com.codeborne.selenide.Configuration;

public class TestConfiguration {



    public static void applyConfig() {


        Configuration.pageLoadStrategy = "eager";

        Configuration.baseUrl = System.getProperty("baseURL", "https://demoqa.com");
        Configuration.remote = System.getProperty("webDriverHost");
        //String testBrowser = System.getProperty("browser", "chrome");
        Configuration.browser = System.getProperty("browser", "chrome");
        //String testVersion = System.getProperty("browserVersion", "113");
        Configuration.browserVersion = System.getProperty("browserVersion", "113");
       //String testWindowSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

//        //Configuration.browser = testBrowser;
//        Configuration.browserSize = testWindowSize;
//        Configuration.browserVersion = testVersion;
    }
}
