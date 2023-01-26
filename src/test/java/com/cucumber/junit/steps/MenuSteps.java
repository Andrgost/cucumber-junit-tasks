package com.cucumber.junit.steps;

import com.cucumber.junit.driver.DriverManager;
import com.cucumber.junit.hooks.ScreenshotHook;
import com.cucumber.junit.pages.ArticlePage;
import com.cucumber.junit.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuSteps {

    private static final String SEARCH_TERM = "Announces";

    private HomePage homePage = new HomePage();
    private ArticlePage articlePage = new ArticlePage();

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @When("the user clicks on the \"Search\" icon")
    public void clickOnSearch() {
        homePage.searchHomePage().click();
    }

    @When("the user enter \"Announces\" in the \"Search\" field")
    public void searchForTerm() {
        homePage.searchInput().sendKeys(SEARCH_TERM);
        homePage.searchForm().click();
    }
    @When("the user filters search results by \"Blog\" param")
    public void filterSearchResults() {
        homePage.searchResultsFilter().click();
        homePage.viewMoreSearchResults();
    }
    @When("the user click the first search result link")
    public void clickFirstSearchResult() {
        homePage.searchResults().get(0).click();
    }

    @Then("page with title \"Article Name\" is displayed")
    public void verifyPageTitlePresence() {
        assertThat(articlePage.isPageWithTitleDisplayed("Announcing Cucumber-Ruby v3.0.2"))
                .overridingErrorMessage("Page with title '%s' is not displayed", "Announcing Cucumber-Ruby v3.0.2")
                .isTrue();
    }
}
