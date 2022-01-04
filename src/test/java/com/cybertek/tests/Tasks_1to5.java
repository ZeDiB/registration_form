package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tasks_1to5 {

    WebDriver driver;   //declare our reference for the object


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome"); //create the object
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        WebElement registButton = driver.findElement(By.linkText("Registration Form"));
        registButton.click();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
    @Test
    public void dateOfBirth(){

        WebElement dobBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        dobBox.sendKeys("wrong_dob");

        String expected = "The date of birth is not valid";
        WebElement invalidText = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));

        String actual = invalidText.getText();

        Assert.assertEquals(actual,expected,"Verify warning message");

    }
    @Test
    public void programmingLanguage(){

        WebElement checkBox1 = driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));

        String expectedCheckBox1 = "C++";
        String actual1 = checkBox1.getText();
        Assert.assertEquals(actual1,expectedCheckBox1,"verify checkbox 1");

        String expectedCheckBox2 = "Java";
        String actual2 = checkBox2.getText();
        Assert.assertEquals(actual2,expectedCheckBox2,"verify checkbox 2");

        String expectedCheckBox3 = "JavaScript";
        String actual3 = checkBox3.getText();
        Assert.assertEquals(actual3,expectedCheckBox3,"verify checkbox 3");

    }

    @Test
    public void firstName() throws InterruptedException {

        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("a");

        Thread.sleep(2000);
        WebElement firstNameWarning = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = firstNameWarning.getText();

        Assert.assertEquals(actual,expected,"Verify that warning message is displayed");

    }

    @Test
    public void lastName() throws InterruptedException {

        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("a");

        Thread.sleep(2000);
        WebElement lastNameWarning = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = lastNameWarning.getText();

        Assert.assertEquals(actual,expected,"Verify that warning message is displayed");

    }

    @Test
    public void registrationForm() throws InterruptedException {

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameInput.sendKeys("Zeynep");

        WebElement lastNameInput= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameInput.sendKeys("Bakir");

        Thread.sleep(2000);

        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='username']"));
        userNameInput.sendKeys("zedibak");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("zedi@gmail.com");

        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("12345678");

        Thread.sleep(2000);

        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumberInput.sendKeys("123-456-6789");

        Thread.sleep(2000);

        WebElement genderSelect = driver.findElement(By.xpath("//input[@value='female']"));
        genderSelect.click();

        WebElement dobBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        dobBox.sendKeys("06/14/1991");

        Thread.sleep(2000);

        WebElement selectDepartment = driver.findElement(By.xpath("//select[@name='department']"));
        Select selectDropDown = new Select(selectDepartment);

        Thread.sleep(2000);
        selectDropDown.selectByVisibleText("Department of Engineering");

        WebElement selectJobTitle = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select selectjob = new Select(selectJobTitle);

        Thread.sleep(2000);
        selectjob.selectByVisibleText("SDET");

        WebElement programmingLAnguage = driver.findElement(By.id("inlineCheckbox2"));
        programmingLAnguage.click();

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        WebElement success = driver.findElement(By.xpath("//div[@role='alert']//p"));
        String expected = "You've successfully completed registration!";
        String actual = success.getText();

        Assert.assertEquals(actual,expected,"Verify that following success message is displayed");


    }



}
