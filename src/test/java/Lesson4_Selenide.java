import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson4_Selenide {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void SelenideTest() {
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $(byText("Soft assertions")).shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();

        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).shouldHave(size(1));
        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).first().sibling(0).$("pre").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                 class Tests {
                                          @Test
                                          void test() {
                                            Configuration.assertionMode = SOFT;
                                            open("page.html");
                                                                
                                            $("#first").should(visible).click();
                                            $("#second").should(visible).click();
                                          }
                                        }
                                        """));
    }

}
