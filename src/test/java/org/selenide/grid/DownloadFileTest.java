package org.selenide.grid;

import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class DownloadFileTest {
  @ParameterizedTest
  @EnumSource(FileDownloadMode.class)
  void downloadFileWithCdp(FileDownloadMode method) {
    DownloadPage page = open("https://selenide.org/test-page/download.html", DownloadPage.class);

    File file = page.downloadFile("txt", "hello-world.txt", method);

    assertThat(file).hasName("hello-world.txt");
    assertThat(file).hasContent("Hello, world!");
  }
}
