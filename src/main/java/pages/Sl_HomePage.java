package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;


public class Sl_HomePage extends BaseClass {

    public Sl_HomePage(){
        initPageFactory(this);
    }

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement topHeader;

    //Assertion Usage
    public void validateLogin(){

        boolean isTopHeaderVisible = topHeader.isDisplayed();

        //Assert.assertTrue(condition, error message)
        //It is is hard assertion so, won't let execution futher w/o passing it

        Assert.assertTrue("Login Failed - Top Header not visible", isTopHeaderVisible);

        System.out.println("Login Is successful");


    }


}
