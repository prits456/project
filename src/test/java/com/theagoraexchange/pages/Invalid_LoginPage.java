package com.theagoraexchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Invalid_LoginPage {

	WebDriver driver;

	By loginClick = By.xpath("//span[contains(text(),'Login')]");
	By username = By.xpath("//*[@id=\"login\"]/div/div/div/form/div[1]/div/input");
	By password = By.xpath("//input[@type=\"password\"]");
	By submitbutton = By.xpath("//button[@type=\"submit\"][1]");
	By text = By.xpath("//*[@id=\"login\"]/div/div/div/form/div[1]");
	By cancel = By.xpath("//button[@type='button' and @class ='btn-close' ][1]");

	public Invalid_LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login_Click() {
		driver.findElement(loginClick).click();
	}

	public void username() {
		driver.findElement(username).sendKeys("abc@yopmail.com");
	}

	public void password() {
		driver.findElement(password).sendKeys("Abc@123");
	}

	public void submit() {
		driver.findElement(submitbutton).click();
	}

	public void getText() {
		String actualmsg = driver.findElement(text).getText();
		System.out.println(actualmsg);
		String expectedmsg = "These credentials do not match our records. Or your account is suspended.";
		Assert.assertEquals(actualmsg, expectedmsg);
		System.out.println("Verified alert message suceessfully");
	}

	public void closed() {
		driver.findElement(cancel).click();
	}

}
