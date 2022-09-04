package Page_Object;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Test sitesine giderek calculater sayfasını açtım
//İki tane sayı girip random işlem seçtik(sayılar da random girilebilir )
//Gireceğimiz sayılar için bu projede scenario outline kullandım
//Sonra işlem yaptırıp işlem sonucunu int değerine çevirip yazdırdım

public class Calculater_page {
    public WebDriver driver;
    public Calculater_page()
    {
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "calculatetest")
    private WebElement calculatePageButton;
    public  void setCalculatePageButton()
    {
        calculatePageButton.click();
    }
    @FindBy(id="number1")
    private WebElement number1;
    public void setNumber1(String firstnumber)
    {
    number1.sendKeys(firstnumber);
    }

    @FindBy(id="number2")
    private WebElement number2;

    public void setNumber2(String secondnumber)
    {
        number2.sendKeys(secondnumber);
    }
    @FindBy(id = "function")
    private WebElement function;
    public void setFunction() throws InterruptedException {
        function.click();
        List<WebElement> functionelements=driver.findElements(By.cssSelector("#function > option"));
        Random rand = new Random();
            int randomIndex = rand.nextInt(functionelements.size());
            Select selectFunction=new Select(function);
            selectFunction.selectByIndex(randomIndex);
            Thread.sleep(2000);
    }
    @FindBy(id="calculate")
    private WebElement calculateButton;
    public void setClickButton()
    {
        calculateButton.click();
    }
    @FindBy(id="answer")
    private WebElement answer;
    public void setAnswer() throws InterruptedException {

        System.out.println("Answer: " + answer.getText());

        String ansWer=answer.getText();
        int EndAnswer=Integer.parseInt(ansWer);
        System.out.println("Integer answer: "+ EndAnswer);

       Assert.assertEquals(ansWer, answer.getText());
    }
}
