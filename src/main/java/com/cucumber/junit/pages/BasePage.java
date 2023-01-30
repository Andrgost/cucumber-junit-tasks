package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(60);
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }

    public WebElement waitForElement(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT).until(visibilityOfElementLocated(by));
    }
}
