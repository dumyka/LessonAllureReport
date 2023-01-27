import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

import io.qameta.allure.Step;

public class WebSteps {

  @Step("Открываем главную страницу")
  public void openMainPage() {
    open("https://github.com");
  }

  @Step("Ищем репозиторий {repo}")
  public void searchForRepository(String repo) {
    $("[name=q]").setValue("selenide").pressEnter();
    $(".repo-list").shouldHave(text(repo));
  }

  @Step("Кликаем по ссылке репозитория {repo}")
  public void clickOnRepositoryLink(String repo) {
    $(linkText("selenide/selenide")).click();
  }

  @Step("Открываем таб Issues")
  public void openIssuesTab() {
    $("#issues-tab").click();
  }

  @Step("Проверяем наличие Issue с номером {issue}")
  public void shouldSeeIssueWithNumber(String issue) {
    $("#issue_2130_link")
        .shouldHave(text(issue));
  }
}

