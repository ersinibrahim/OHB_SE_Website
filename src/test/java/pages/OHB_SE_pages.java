package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class OHB_SE_pages extends Parent{

    public OHB_SE_pages() {PageFactory.initElements(BaseDriver.getDriver(),this);}

    @FindBy(xpath = "(//ul[@class='navigation']/li[@class='navigation__item'])[1]")
    public WebElement digital_Tab;

    @FindBy(xpath = "(//i[@class='far fa-play-circle fa-2x loadButton'])[2]")
    public WebElement videoOHBDigital_Button;

    @FindBy(css = "a[class*='ytp-watermark-small']")
    public WebElement youtube_Watermark_logo;

    @FindBy(css = "div[id='actions']")
    public WebElement youtubepage_actions;

    @FindBy(xpath = "//nav[@class='header']/a")
    public WebElement ohb_logo;

    @FindBy(css = "i[class*='fa-linkedin']")
    public WebElement linkedIn_logo;

    @FindBy(css = "i[class='fab  fa-youtube']")
    public WebElement youtube_logo;



}
