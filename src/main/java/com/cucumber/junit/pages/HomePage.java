package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final String ALLOW_ALL_COOKIES_XPATH = "//button[text()='Allow all cookies']";
    private static final String SEARCH_PATTERN = "//%s/*[contains(@class, 'fa-search')]";
    private static final String SEARCH_HOME_PAGE = "a";
    private static final String SEARCH_FORM = "div";
    private static final String SEARCH_INPUT = "//input[contains(@class, 'app-input-query')]";
    private static final String FILTER_TYPE_PATTERN = "//*[contains(@class, 'filter-item-name') and contains(text(), '%s')]";
    private static final String SEARCH_RESULTS = "//*[contains(@class, 'link-title')]";

    public void openCucumberWebsite() {
        driver.get(CUCUMBER_URL);
    }

    public WebElement allowAllCookiesButton() {
        return waitForElement(By.xpath(ALLOW_ALL_COOKIES_XPATH));
    }

    public WebElement searchIconHomePage() {
        return findElement(By.xpath(format(SEARCH_PATTERN, SEARCH_HOME_PAGE)));
    }

    public WebElement searchInput() {
        return findElement(By.xpath(SEARCH_INPUT));
    }

    public WebElement searchIconForm() {
        return findElement(By.xpath(format(SEARCH_PATTERN, SEARCH_FORM)));
    }

    public WebElement searchResultsFilter(String filterParam) {
        return findElement(By.xpath(format(FILTER_TYPE_PATTERN, filterParam)));
    }

    public List<WebElement> searchResults() {
        return findElements(By.xpath(SEARCH_RESULTS));
    }
}
