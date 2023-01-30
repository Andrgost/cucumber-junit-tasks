package com.cucumber.junit.steps;

import com.cucumber.junit.pages.ArticlePage;
import com.cucumber.junit.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuSteps {

    private static final String SEARCH_TERM = "Announces";
    private final HomePage homePage = new HomePage();
    private final ArticlePage articlePage = new ArticlePage();
    private String pageTitle;

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @And("the user click on the Allow all cookies button")
    public void theUserClickOnTheAllowAllCookiesButton() {
        homePage.allowAllCookiesButton().click();
    }

    @When("the user clicks on the Search icon")
    public void clickOnSearch() {
        homePage.searchIconHomePage().click();
    }

    @When("the user searches for Announces")
    public void searchForTerm() {
        homePage.searchInput().sendKeys(SEARCH_TERM);
        homePage.searchIconForm().click();
    }

    @When("the user filters search results by {string} param")
    public void filterSearchResults(String filterParam) {
        homePage.searchResultsFilter(filterParam).click();
    }

    @When("the user clicks the first search result")
    public void clickFirstSearchResult() {
        WebElement firstArticle = homePage.searchResults().stream().findFirst().get();
        pageTitle = firstArticle.getText();
        firstArticle.click();
    }

    @Then("page with title \"Article Name\" is displayed")
    public void verifyPageTitlePresence() {
        assertThat(articlePage.isPageWithTitleDisplayed(pageTitle))
                .overridingErrorMessage("Page with title '%s' is not displayed", pageTitle)
                .isTrue();
    }
}