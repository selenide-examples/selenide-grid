package org.selenide.grid;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;
import static com.codeborne.selenide.Selenide.open;

public class ClipboardTest {
  @Test
  @Disabled
  void canCheckClipboardContent() {
    open("https://selenide.org/test-page/clipboard.html");
    $("#text-input").val("Hello Selenium Grid!");
    $("#copy-button").click();
    clipboard().shouldHave(content("Hello Selenium Grid!"));
  }
}
