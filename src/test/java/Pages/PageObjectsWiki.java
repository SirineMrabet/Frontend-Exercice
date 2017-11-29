package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by smrabet on 29/11/2017.
 */
public class PageObjectsWiki {

    public PageObjectsWiki (WebDriver driver)
    {

        PageFactory.initElements(driver, this);
    }



    //************************************** search btn ***********************************

    public static final String ob1 = "//button[@class='pure-button pure-button-primary-progressive']";
    @FindBy(how = How.XPATH, using = ob1)
    public WebElement searchbtn;


    //************************************** search field **********************************

    public static final String ob2 = "searchInput";
    @FindBy(how = How.ID, using = ob2)
    public WebElement searchfld;


    //************************************** did you mean field ****************************

    public static final String ob3 =   "//div[@class='searchdidyoumean']";
    @FindBy(how = How.XPATH, using = ob3)
    public WebElement DidYouMeanfld;

    //************************************** suggestion  ******* ****************************

    public static final String ob4 =   "mw-search-DYM-suggestion";
    @FindBy(how = How.ID, using = ob4)
    public WebElement Suggestionfld;

    //*********************************** first suggested item ******************************
    public static final String ob5 =   "//a[@data-serp-pos='0']";
    @FindBy(how = How.XPATH, using = ob5)
    public WebElement Suggestionitem;

    //*********************************** Content *******************************************
    public static final String ob6 = "toc";
    @FindBy(how = How.ID, using = ob6)
    public WebElement Content;

    //*********************************** Title Suggestion *******************************************
    public static final String ob7 =   "firstHeading";
    @FindBy(how = How.ID, using = ob7)
    public WebElement Titlesuggestion;










}
