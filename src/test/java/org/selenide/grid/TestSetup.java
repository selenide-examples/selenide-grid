package org.selenide.grid;

import java.util.Map;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;

public class TestSetup implements BeforeAllCallback {
  @Override
  public void beforeAll(ExtensionContext context) {
    Configuration.remote = "http://localhost:4444/wd/hub";
    Configuration.proxyEnabled = true;
    Configuration.browserCapabilities = new ChromeOptions()
      .setEnableDownloads(true)
      .enableBiDi();
  }
}
