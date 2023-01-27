import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureSteps {

  private static final String REPOSITORY = "selenide/selenide";
  private static final String TEXT =
      "Add conditions oneOfTexts, oneOfExactTexts, oneOfTextsCaseSensitive, oneOfExactTextsCaseSensitive";


  @Test
  @Owner("Dmitriy Golovanov")
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Проверка названия ISSUE в репозитории " + REPOSITORY)
  public void testAnnotatedStep() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();
    steps.openMainPage();
    steps.searchForRepository(REPOSITORY);
    steps.clickOnRepositoryLink(REPOSITORY);
    steps.openIssuesTab();
    steps.shouldSeeIssueWithNumber(TEXT);

  }
}
