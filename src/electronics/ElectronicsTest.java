package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 1.3 Verify the text “Cell phones”
        String actualText = "Cell phones";
        String expectedText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 2.3 Verify the text “Cell phones”
        String actualText = "Cell phones";
        String expectedText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText, actualText);
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        String actualNokia = "Nokia Lumia 1020";
        String expectedNokia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals(expectedNokia, actualNokia);
        Thread.sleep(1000);
        // 2.7 Verify the price “$349.00”
        String actualPrice = "$349.00";
        String expectedPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedPrice, actualPrice);
        // 2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        // clickOnElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[3]"));
        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(1000);
        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualPr = "The product has been added to your shopping cart";
        String expectedPr = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedPr, actualPr);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@title='Close']"));
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        mouseHoverAndClick(By.xpath("//*[@class='button-1 cart-button']"));

        // 2.12 Verify the message "Shopping cart"
        String actualPrs = "Shopping cart";
        String expectedPrs = getTextFromElement(By.xpath("//div[contains(@class,'page-title')]"));
        Assert.assertEquals(expectedPrs, actualPrs);
        // 2.13 Verify the quantity is 2    //input[@id='itemquantity11234']
//        String actualQty = "2";
//        String expectedQty = getTextFromElement(By.xpath("//td[@class='quantity']"));
//        Assert.assertEquals(expectedQty, actualQty);
        // 2.14 Verify the Total $698.00
        String actualTot = "$698.00";
        String expectedTot = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals(expectedTot, actualTot);
        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        String actualTxt = "Welcome, Please Sign In!";
        String expectedTxt = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedTxt, actualTxt);
        // 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        // 2.19 Verify the text “Register”
        String actualTxtt = "Register";
        String expectedTxtt = getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expectedTxtt, actualTxtt);
        // 2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Arjun");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Pandit");
        sendTextToElement(By.xpath("//input[@id='Email']"), "Pandit2212@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Pandit123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Pandit123");
        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        // 2.22 Verify the message “Your registration completed”
        String actualReg = "Your registration completed";
        String expectedReg = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedReg, actualReg);
        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 2.24 Verify the text “Shopping card”
        String actualA = "Shopping cart";
        String expectedA = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedA, actualA);
        // 2.25 click on checkbox “I agree with the terms of service”


    }
}
