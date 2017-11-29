package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by smrabet on 29/11/2017.
 */
public class PageObjectsTravelex {

    public PageObjectsTravelex(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    //************************************** slider1***********************************

    public static final String ot1 = "//div[@class='sliderdb slick-slide slick-active']";
    @FindBy(how = How.XPATH, using = ot1)
    public WebElement slider1;

  //************************************** slider2***********************************

    public static final String ot2 = "//div[@class='slidermb slick-slide slick-active']";
    @FindBy(how = How.XPATH, using = ot2)
    public WebElement slider2;




}

