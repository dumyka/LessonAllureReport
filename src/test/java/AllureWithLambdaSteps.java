import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureWithLambdaSteps {

  private static final String REPOSITORY = "selenide/selenide";
  private static final String TEXT =
      "Add conditions oneOfTexts, oneOfExactTexts, oneOfTextsCaseSensitive, oneOfExactTextsCaseSensitive";

  @Test
  @DisplayName("Проверка названия ISSUE в репозитории " + REPOSITORY)
  void testIssueSearchWithLambdaSteps() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
      open("https://github.com/");
    });

    step("Поиск репозитория" + REPOSITORY, () -> {
      $("[name=q]").setValue("selenide").pressEnter();
      $(".repo-list").shouldHave(text(REPOSITORY));
    });

    step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
      $(linkText("selenide/selenide")).click();
    });

    step("Открываем таб Issues", () -> {
      $("#issues-tab").click();
    });

    step("Проверяем наличие Issue с текстом" + TEXT, () -> {
      $("#issue_2130_link")
          .shouldHave(text(TEXT));
    });
  }
}
