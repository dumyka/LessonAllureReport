import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AllureNotSteps {

  @Test
  void testIssueSearch(){
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com/");
    $("[name=q]").setValue("selenide").pressEnter();
    $(".repo-list").shouldHave(text("selenide/selenide"));
    $(linkText("selenide/selenide")).click();

    $("#issues-tab").click();
    $("#issue_2130_link").shouldHave(text("Add conditions oneOfTexts, oneOfExactTexts, oneOfTextsCaseSensitive, oneOfExactTextsCaseSensitive"));
  }
}
