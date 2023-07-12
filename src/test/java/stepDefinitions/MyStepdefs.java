package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.OHB_SE_pages;
import utilities.BaseDriver;

import java.util.ArrayList;


public class MyStepdefs {

    OHB_SE_pages ohb_se_pages;
    WebDriver driver= BaseDriver.getDriver();
    ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());

    public MyStepdefs(OHB_SE_pages ohb_se_pages) {this.ohb_se_pages= ohb_se_pages;}

    @Given("^Navigate to OHB_SE Website$")
    public void navigate_to_OHB_SE_Website() {
        driver.get("https://www.ohb.de/en/");
        driver.manage().window().maximize();
    }

    @When("^Click to DIGITAL tab$")
    public void click_to_DIGITAL_tab() {
        ohb_se_pages.digital_Tab.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("digital"));
    }

    @Then("^Click OHB_Digital video_box and check youtube page and then close page$")
    public void click_OHB_Digital_video_box_and_check_youtube_page_and_then_close_page()  {

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        ohb_se_pages.videoOHBDigital_Button.click();
        ohb_se_pages.waitUntilClickable(ohb_se_pages.youtube_Watermark_logo);
        String youtubeLogo_Link = ohb_se_pages.youtube_Watermark_logo.getAttribute("href");
        ohb_se_pages.youtube_Watermark_logo.click();

        driver.switchTo().window(tabs.get(1));

        ohb_se_pages.waitUntilVisible(ohb_se_pages.youtubepage_actions);

        String youtubePage_url= driver.getCurrentUrl();

        Assert.assertEquals(youtubeLogo_Link,youtubePage_url);

        driver.close();

    }

    @Then("^Click OHB logo$")
    public void click_OHB_logo()  {
        ohb_se_pages.scrollToElement(ohb_se_pages.ohb_logo);
        ohb_se_pages.ohb_logo.click();
    }

    @Then("^Scroll down the page and click LinkedIN_logo$")
    public void scroll_down_the_page_and_click_LinkedIN_logo()  {
        ohb_se_pages.scrollToElement(ohb_se_pages.linkedIn_logo);
        ohb_se_pages.linkedIn_logo.click();
    }

    @Then("^Check linkedIn page$")
    public void check_linkedIn_page()  {
        driver.switchTo().window(tabs.get(1));

        Assert.assertTrue(driver.getCurrentUrl().contains("ohb-se"));

    }

}
