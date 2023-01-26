package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final String SEARCH_PATTERN = "//%s/*[contains(@class, 'fa-search')]";
    private static final String SEARCH_HOME_PAGE = "a";
    private static final String SEARCH_FORM = "div";
    private static final String SEARCH_INPUT = "//input[contains(@class, 'app-input-query')]";
    private static final String FILTER_TYPE_PATTERN = "//*[contains(@class, 'filter-item-name') and contains(text(), '%s')]";
    private static final String FILTER_TYPE_BLOG = "Blog";
    private static final String SEARCH_RESULTS = "//*[contains(@class, 'link-title')]";
    private static final String VIEW_MORE_BLOG_RESULTS = "//*[contains(@class, 'view-more')]";

    public void openCucumberWebsite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement searchHomePage() {
        return findElement(By.xpath(format(SEARCH_PATTERN, SEARCH_HOME_PAGE)));
    }

    public WebElement searchInput() {
        return findElement(By.xpath(SEARCH_INPUT));
    }
    public WebElement searchForm() {
        return findElement(By.xpath(format(SEARCH_PATTERN, SEARCH_FORM)));
    }

    public WebElement searchResultsFilter() {
        return findElement(By.xpath(format(FILTER_TYPE_PATTERN, FILTER_TYPE_BLOG)));
    }

    public List<WebElement> searchResults() {
        return findElements(By.xpath(SEARCH_RESULTS));
    }

    public WebElement viewMoreSearchResults() {
        return findElement(By.xpath(VIEW_MORE_BLOG_RESULTS));
    }
}
