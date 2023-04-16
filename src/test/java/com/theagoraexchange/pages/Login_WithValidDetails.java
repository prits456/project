package com.theagoraexchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_WithValidDetails {
	WebDriver driver;

	By loginClick = By.xpath("//span[contains(text(),'Login')]");
	By username = By.xpath("//*[@id=\"login\"]/div/div/div/form/div[1]/div/input");
	By password = By.xpath("//*[@id=\"password\"]");
	By submitbutton = By.xpath("//*[@id=\"login\"]/div/div/div/form/div[4]/button");

	public Login_WithValidDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void login_Click() {
		driver.findElement(loginClick).click();
	}

	public void username() {
		driver.findElement(username).sendKeys("testharry@yopmail.com");
	}

	public void password() {
		driver.findElement(password).sendKeys("Testharry@123");
	}

	public void submit() {
		driver.findElement(submitbutton).click();
	}

}
