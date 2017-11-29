package Steps;

import Base.BaseUtile;
import Pages.PageObjectsTravelex;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by smrabet on 29/11/17.
 */
public class TestResize extends BaseUtile {
    private BaseUtile base;

    public TestResize(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;

    }

    @Given("^I'm on the Travelex website$")
    public void iMOnTheTravelexWebsite() throws Throwable {
        this.driver.navigate().to("http://travelex.co.uk");
        Assert.assertEquals(this.driver.getCurrentUrl(),"https://www.travelex.co.uk/");

    }
    @When("^I resize the window$")
    public void iResizeTheWindow() throws Throwable {
       this.driver.manage().window().setSize(new Dimension(550,550));
    }

    @And("^I Swipe left on the slider$")
    public void iSwipeLeftOnTheSlider() throws Throwable {
        PageObjectsTravelex PT= new PageObjectsTravelex(driver);
       /////////////////////////////Scroll to the element to be visible /////////////////////////
        int startY = PT.slider1.getLocation().getY() + (PT.slider1.getSize().getHeight() / 2);
        int scrollPos = startY-(PT.slider1.getSize().getHeight() / 2);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, "+scrollPos+");");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjectsTravelex.ot1)));
        //swipe two times left on the sider
        PT.slider1.sendKeys(Keys.ARROW_RIGHT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjectsTravelex.ot2)));
        PT.slider2.sendKeys(Keys.ARROW_RIGHT);

    }



    @Then("^The displayed item is the third one$")
    public void theDisplayedItemIsTheThirdOne() throws Throwable {
        PageObjectsTravelex PT= new PageObjectsTravelex(driver);
        Assert.assertTrue(PT.slider1.getText().contains("Buy foreign currency"));
        Assert.assertTrue(PT.slider1.getAttribute("index").equals("2"));

    }



}
