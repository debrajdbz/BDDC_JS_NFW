package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BaseClass;

public class Sl_LoginPage extends BaseClass {


    //Constructor // make this method for each page class u make
    public Sl_LoginPage(){
        initPageFactory(this);
    }
    //To make the constructor, its name should be the same as the class name.
    // Constructor methods don't return anything

   /* new SL_LoginPage()
       ↓
    constructor runs
       ↓
   this = current SL_LoginPage object
       ↓
    initPageFactory(this)
       ↓
    page = SL_LoginPage object
       ↓
   PageFactory.initElements(driver, page)*/ //Flow

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement login_button;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    //To put Username
    public void FillUsername(String user){

        username.sendKeys(user);
    }

    //To put Password
    public void FillPassword(String pass){

        password.sendKeys(pass);
    }

    //To click on Login Button
    public void clickLoginbtn() throws InterruptedException {

        login_button.click();
        Thread.sleep(2000);
    }

    //To see error message displayed or not
    public boolean isErrorMessageDisplayed(){

        return errorMessage.isDisplayed();
    }






}
