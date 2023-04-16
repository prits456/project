package com.theagoraexchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Searching_ProductandVerify {
	WebDriver driver;

	By searchtext = By.xpath("//input[@placeholder=\"Search for brand or product\"]");
	By enter = By.xpath("//*[@id=\"app\"]/header/nav/div/form/button");

	public Searching_ProductandVerify(WebDriver driver) {
		this.driver = driver;
	}

	public void search_box() {
		driver.findElement(searchtext).sendKeys("Hand Bag");
	}

	public void enter() {
		driver.findElement(enter).click();
	}

}
