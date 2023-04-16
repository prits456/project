package com.theagoraexchange.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.theagoraexchange.base.Base_Class;
import com.theagoraexchange.pages.AddToCartAndVerify;
import com.theagoraexchange.pages.ClickOnProductAndIncreament;
import com.theagoraexchange.pages.Invalid_LoginPage;
import com.theagoraexchange.pages.Login_WithValidDetails;
import com.theagoraexchange.pages.Searching_ProductandVerify;

public class Test extends Base_Class {

	@org.testng.annotations.Test(priority = 1)
	public void verify_LandingPage() throws InterruptedException {
		// Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "Home|AgoraExchange - AgoraExchangeFrontend";
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Verified lan	ding page suceessfully");
		System.out.println("Verified landing page suceessfully");

	}

	@org.testng.annotations.Test(priority = 2)
	public void verify_AlertMeassageWithInvalidCredentials() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Invalid_LoginPage lp = new Invalid_LoginPage(driver);
		lp.login_Click();
		lp.username();
		lp.password();
		lp.submit();
		// lp.getText();
		String actualmsg = driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"][1]")).getText();
		System.out.println(actualmsg);
		System.out.println(actualmsg);
		String expectedmsg = "These credentials do not match our records. Or your account is suspended.";
		Assert.assertEquals(actualmsg, expectedmsg);
		System.out.println("Verified alert message suceessfully");
		// Thread.sleep(5000);
		lp.closed();
		// Thread.sleep(3000);
		driver.navigate().refresh();
		// Thread.sleep(5000);

	}

	@org.testng.annotations.Test(priority = 3)
	public void verify_WithValidCredentials() throws InterruptedException {

		Login_WithValidDetails login = new Login_WithValidDetails(driver);
		login.login_Click();
		login.username();
		login.password();
		login.submit();
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"login\\\"]/div/div/div/form/div[4]/button")));
	}

	@org.testng.annotations.Test(priority = 4)
	public void verify_Dashboard() throws InterruptedException
	{
		
		String ActualTitle1 = driver.getTitle();
		String ExpectedTitle1 = "Seller Dashboard - AgoraExchangeFrontend";
		System.out.println(ActualTitle1);

		Assert.assertEquals(ActualTitle1, ExpectedTitle1);
		System.out.println("Verified Dashboard page suceessfully");
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@org.testng.annotations.Test(priority = 5)
	public void SearchandVerifyproduct() throws InterruptedException {
	
		Searching_ProductandVerify sp = new Searching_ProductandVerify(driver);
		
		sp.search_box();
		WebDriverWait wait = new WebDriverWait(driver,7);
		
		sp.enter();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/header/nav/div/form/button")));
		
		//Thread.sleep(7000);
		String ActualTitle2 = driver.getTitle();
		System.out.println(ActualTitle2);
		String ExpectedTitle2 = "Product Listing - AgoraExchangeFrontend";
		Assert.assertEquals(ActualTitle2, ExpectedTitle2);
		System.out.println("Verified the particular porduct selection");
		//Thread.sleep(3000);
	}

	@org.testng.annotations.Test(priority = 6)
	public void produtselectionandincreament() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ClickOnProductAndIncreament click = new ClickOnProductAndIncreament(driver);
		//Thread.sleep(3000);
		click.click_onproduct();
		//Thread.sleep(3000);
		click.IncreamentProductIteams();

	}

	@org.testng.annotations.Test(priority = 7)
	public void addToCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AddToCartAndVerify add = new AddToCartAndVerify(driver);
		add.AddToCart();

		String ActualTitle3 = driver.getTitle();
		System.out.println(ActualTitle3);
		String ExpectedTitle3 = "Product Details - AgoraExchangeFrontend";
		Assert.assertEquals(ActualTitle3, ExpectedTitle3);
		//driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/form/div/div[1]/div[2]/table/tbody/tr/td/div/button")).click();
		System.out.println("Verified the add to cart section");
		System.out.println("************************************************************");
		//driver.quit();
	
		

	}

}
