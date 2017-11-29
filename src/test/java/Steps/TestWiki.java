package Steps;
import Base.BaseUtile;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Pages.PageObjectsWiki;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by smrabet on 29/11/17.
 */
public class TestWiki extends BaseUtile {
    private BaseUtile base;

    public TestWiki(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;

    }
    @Given("^I'm in the wiki home page$")
    public void iMInTheWikiHomePage() throws Throwable {
        //Navigate to wikipedia
        this.driver.navigate().to("http://wikipedia.org");
        PageObjectsWiki PO = new PageObjectsWiki(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PO.ob1)));
        Assert.assertTrue(driver.getTitle().equals("Wikipedia"));
        System.out.println("Title Wikipedia exists");

    }


    @When("^I search ([^\"]*)$")
    public void iSearchWord(String Word) throws Throwable {

        PageObjectsWiki PO = new PageObjectsWiki(driver);
        PO.searchfld.clear();
        PO.searchfld.sendKeys(Word);
        PO.searchbtn.click();




    }




    @Then("^The result of the search displays$")
    public void theResultOfTheSearchDisplays() throws Throwable {

        PageObjectsWiki PO = new PageObjectsWiki(driver);
       //  ****************** Suggestion *************************
        System.out.println("begin "+PO.DidYouMeanfld.getText());
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PO.ob3)));
        Assert.assertTrue(PO.DidYouMeanfld.getText().contains("Did you mean: "));
        System.out.println("Did you mean appears");

        // ****************** 20 Results ***************************

        PO.Suggestionfld.click();
        List  Elts = driver.findElements(By.xpath("//div[@class='searchresult']"));
        Assert.assertEquals(Elts.size(),20);
        System.out.println("20 Results appears");

        // ******** Verify that the selected item displays correctly *
        PO.Suggestionitem.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PO.ob6)));
        Assert.assertFalse(PO.Titlesuggestion.getText().equals(""));
        System.out.println("The suggestion has a content table and a title");




    }


}
