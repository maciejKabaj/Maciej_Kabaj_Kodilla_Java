package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//div[@role='none' and .//span[contains(text(),'Zezw')]]";
    public static final String XPATH_CREATE_ACCOUNT = "//a[contains(@data-testid, 'open-registration-form-button')]";
    public static final String XPATH_DAY = "//select[@name='birthday_day']";
    public static final String XPATH_MONTH = "//select[@name='birthday_month']";
    public static final String XPATH_YEAR = "//select[@name='birthday_year']";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement cookiesButton = driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES));
        cookiesButton.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccount.click();

        while (!driver.findElement(By.xpath(XPATH_DAY)).isDisplayed());

        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("15");

        WebElement month = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("maj");

        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1995");
    }
}