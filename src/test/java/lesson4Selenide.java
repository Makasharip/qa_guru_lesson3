import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class lesson4Selenide {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void selenideTest() {
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
