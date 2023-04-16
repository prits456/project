package com.theagoraexchange.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartAndVerify {
	WebDriver driver;

	By addtocart = By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[2]/div/form/div[4]/button");

	public AddToCartAndVerify(WebDriver driver) {
		this.driver = driver;
	}

	public void AddToCart() {
		driver.findElement(addtocart).click();
	}

}
