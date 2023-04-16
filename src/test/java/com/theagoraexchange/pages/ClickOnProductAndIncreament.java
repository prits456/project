package com.theagoraexchange.pages;

import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickOnProductAndIncreament {
	WebDriver driver;

	By clickonproduct = By.xpath("//a[@target=\"_blank\"][1]");
	By increament = By.xpath("//button[@class=\"quantity-btn\"][2]");

	public ClickOnProductAndIncreament(WebDriver driver) {
		this.driver = driver;
	}

	public void click_onproduct() {
		driver.findElement(clickonproduct).click();
	}

	public void IncreamentProductIteams() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String pw = itr.next();
		String cw = itr.next();
		driver.switchTo().window(cw);
		driver.findElement(increament).click();

	}

}
