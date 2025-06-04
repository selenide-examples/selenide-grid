package org.selenide.grid;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SimplePageObjectTest {
  @BeforeEach
  void setUp() {
    open("https://selenide.org/users.html");
  }

  @Test
  void showsAllKnownSelenideUsers() {
    SelenideUsersPage page = page();
    page.users().shouldHave(size(1));

    page.filterByTag("all");
    page.users().shouldHave(sizeGreaterThan(40));
  }

  @Test
  void canFilterByTag() {
    SelenideUsersPage page = page();
    page.filterByTag("usa");
    page.users().shouldHave(sizeLessThan(40));
  }

  private static class SelenideUsersPage {
    public ElementsCollection users() {
      return $$("#selenide-users .user:not(.hidden)");
    }

    public void filterByTag(String tag) {
      $("#user-tags").find(byText(tag)).click();
    }
  }
}
