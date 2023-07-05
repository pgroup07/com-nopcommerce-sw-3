package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // 1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // 1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        // 1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //driver.findElement(By.xpath("//select[@id='products-orderby']")).clear();
        // 1.4 Verify the Product will arrange in Descending order.



    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // 2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        // 2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        // 2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//*[@class='button-2 product-box-add-to-cart-button'])[1]"));

        // 2.5 Verify the Text "Build your own computer"
        String pageTitle = getPageTitle();
        String actualMessage = "nopCommerce demo store. Desktops";
        Assert.assertEquals(actualMessage, pageTitle);
        Thread.sleep(1000);
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);
        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        selectCheckBox(By.xpath("//*[@id='product_attribute_5_10']"));

        selectCheckBox(By.xpath("//*[@id='product_attribute_5_12']"));
        Thread.sleep(1000);
        // 2.11 Verify the price "$1,475.00"
        String actualPrice = "$1,475.00";
        String expectedPrice = driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
        Assert.assertEquals(expectedPrice, actualPrice);
        // 2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top
        String actualMessage1 = "The product has been added to your shopping cart";
        String expectedMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage1);
        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        mouseHoverAndClick(By.xpath("//button[normalize-space()='Go to cart']"));
        // 2.15 Verify the message "Shopping cart"
        String actual = "Shopping cart";
        String expected = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals(expected, actual);
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[contains(@id,'itemquantity')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'itemquantity')]")).sendKeys("2");
        driver.findElement(By.xpath("//button[@id='updatecart']")).click();
        // 2.17 Verify the Total"$2,950.00"
        String actualPric = "$2,950.00";
        String expectedPric = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals(expectedPric, actualPric);
        // 2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        // 2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        String actualTx = "Welcome, Please Sign In!";
        String expectedTx = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        // String expectedTx = driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals(expectedTx, actualTx);
        // 2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //driver.findElement(By.xpath("//button[normalize-space()='Checkout as Guest']")).click();
        // 2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Arjun");
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("Arjun");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Pandit");
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Pandit");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Pandit22@gmail.com");
        // driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("Pandit22@gmail.com");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Alabama");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "New York");
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("New York");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Lal Street");
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Lal Street");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "383536");
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("383536");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9876543210");
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9876543210");

        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.24 Click on Radio Button “Next Day Air($0.00)”  //input[@id='shippingoption_1']
        Thread.sleep(2000);


        // driver.findElement(By.id("")).clear();
        clickOnElement(By.xpath("//*[@id='shippingoption_1']"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);
        // 2.26 Select Radio Button “Credit Card”
        selectCheckBox(By.xpath("//input[@id='paymentmethod_1']"));

        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);
        // 2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        // 2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Arjun");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5573615091331588");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "04");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "436");
        // 2.29 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        String actualPayment = "Credit Card";
        String expectedPayment = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        Assert.assertEquals(expectedPayment, actualPayment);
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        String actualMet = "Next Day Air";
        String expectedMet = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        Assert.assertEquals(expectedMet, actualMet);
        // 2.33 Verify Total is “$2,950.00”
        String actualTotal = "$2,950.00";
        String expectedTotal = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals(expectedTotal, actualTotal);
        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // 2.35 Verify the Text “Thank You”
        String actualThank = "Thank you";
        String expectedThank = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedThank, actualThank);
        // 2.36 Verify the message “Your order has been successfully processed!”
        String actualSucc = "Your order has been successfully processed!";
        String expectedSucc = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedSucc, actualSucc);
        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // 2.37 Verify the text “Welcome to our store”
        Thread.sleep(1000);
        String actualStore = "Your order has been successfully processed!";
        String expectedStore = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedStore, actualStore);
    }

    @After
    public void tearDown() {
      //  closeBrowser();
    }
}
