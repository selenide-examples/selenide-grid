package org.selenide.grid;

import static com.codeborne.selenide.DownloadOptions.file;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import java.io.File;

import com.codeborne.selenide.FileDownloadMode;

class DownloadPage {
    public File downloadFile(String extension, String fileName, FileDownloadMode method) {
      return $(byText(fileName)).download(
        file().withMethod(method).withExtension(extension)
      );
    }
  }
