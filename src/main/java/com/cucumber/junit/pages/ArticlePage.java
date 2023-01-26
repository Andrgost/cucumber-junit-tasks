package com.cucumber.junit.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class ArticlePage extends BasePage {

    private static final String PAGE_TITLE_PATTERN = "//head[@id='head']/title[contains(text(), '%s')]";

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE_PATTERN, title)));
    }
}
