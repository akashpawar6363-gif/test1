package com.online.shop.project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OSproject {
	ExtentReports report;
	ExtentTest logger;
	WebDriver d;

   @Test (priority=0)
	public void verifyBlogTitle() throws InterruptedException, IOException
	{
	report=new ExtentReports("D:\\ExtendReport\\Online.html");
	logger=report.startTest("Online");

	WebDriverManager.chromedriver().setup();
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--remote-allow-origins=*");
	d= new ChromeDriver(opt);

	logger.log(LogStatus.INFO, "Browser Started");
	d.get("https://www.saucedemo.com");
	d.manage().window().maximize();

	logger.log(LogStatus.INFO, "Site Launch Successfully");
	
	WebElement u1=d.findElement(By.xpath("//*[@id=\'user-name\']"));
	u1.sendKeys("standard_user");
	WebElement p1=d.findElement(By.xpath("//*[@id=\'password\']"));
	p1.sendKeys("secret_sauce");
	logger.log(LogStatus.INFO, "Login Successfully");
 	Thread.sleep(5000);

	WebElement l1=d.findElement(By.xpath("//*[@id=\'login-button\']"));
 	l1.click();
 	WebElement l2=d.findElement(By.xpath("//*[@id=\'react-burger-menu-btn\']"));
 	l2.click();
 	WebElement l3=d.findElement(By.xpath("//*[@id=\'reset_sidebar_link\']"));
 	l3.click();
 	WebElement l4=d.findElement(By.xpath("//*[@id=\'about_sidebar_link\']"));
 	l4.click();
 	Thread.sleep(5000);
 	
 	String title=d.getTitle();
	
	Assert.assertTrue(title.contains("www.orangehrm.com"));
	logger.log(LogStatus.INFO, "Title checking done");
 	
	d.navigate().back();
	}
   
   @Test (priority=1)
   
   public void addCard() throws InterruptedException {
	
	WebElement c1=d.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']"));
 	c1.click();
 	WebElement c2=d.findElement(By.xpath("//*[@id=\'add-to-cart-test.allthethings()-t-shirt-(red)\']"));
 	c2.click();
 	WebElement c3=d.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-bolt-t-shirt\']"));
 	c3.click();
 	WebElement c4=d.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-bike-light\']"));
 	c4.click();
 	logger.log(LogStatus.INFO, "Items Added in Card Successfully");
 	Thread.sleep(5000);
 	
	WebElement c5=d.findElement(By.xpath("//*[@id=\'shopping_cart_container\']/a"));
 	c5.click();
 	WebElement c6=d.findElement(By.xpath("//*[@id=\'remove-sauce-labs-backpack\']"));
 	c6.click();
 	logger.log(LogStatus.INFO, "1 Items Added remove from Card Successfully");
 	
 	WebElement cu=d.findElement(By.xpath("//*[@id=\'checkout\']"));
 	cu.click();
 	
 	WebElement fn=d.findElement(By.xpath("//*[@id=\'first-name\']"));
	fn.sendKeys("Tingting");
	WebElement ln=d.findElement(By.xpath("//*[@id=\'last-name\']"));
	ln.sendKeys("Tiktok");
	WebElement zp=d.findElement(By.xpath("//*[@id=\'postal-code\']"));
	zp.sendKeys("456321");
	
	WebElement ca1=d.findElement(By.xpath("//*[@id=\'continue\']"));
	ca1.click();
	logger.log(LogStatus.INFO, "Order Successfully");
	WebElement f1=d.findElement(By.xpath("//*[@id=\'finish\']"));
	f1.click();
	WebElement ff=d.findElement(By.xpath("//*[@id=\'back-to-products\']"));
	ff.click();
 	Thread.sleep(5000);
 	WebElement lla=d.findElement(By.xpath("//*[@id=\'react-burger-menu-btn\']"));
	lla.click();
	}
   
	@Test (priority=2)
	
	public void logoutPage () throws InterruptedException {
	
	WebElement fll3=d.findElement(By.xpath("//*[@id=\'logout_sidebar_link\']"));
	fll3.click();
	
	logger.log(LogStatus.INFO, "Logout Successfully");
	}
   
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Verification failed");
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "Verification OK");
		}
	
	}
   @AfterTest
   public void EndTest()
   {
	   report.endTest(logger);
		report.flush();
			
			
		d.get("D:\\ExtendReport\\Online.html");	
   }
   }
 
