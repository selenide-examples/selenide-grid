package org.selenide.grid;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {
  @Test
  void search() {
    open("https://selenide.org");
    $(".main-menu-pages").find(byText("Users")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(size(1));

    $$("#user-tags .tag").shouldHave(sizeGreaterThan(8));
    $("#user-tags").find(byTagAndText("a", "all")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(sizeGreaterThan(80));

    $("#user-tags").find(byTagAndText("a", "ukraine")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(sizeLessThan(80));

    $("#user-tags").find(byTagAndText("a", "healthcare")).click();
    $$("#selenide-users .user:not(.hidden)").shouldHave(sizeLessThan(20));
  }
}
