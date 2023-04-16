package com.theagoraexchange.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static FileInputStream fis;
	ChromeOptions co=new ChromeOptions();
	EdgeOptions eo=new EdgeOptions();
	
@Parameters("browser")
	@BeforeTest
	public void open_Browser(String browser) {
	if(driver==null)

	//FileInputStream fis;
	try {
		fis = new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace3\\TheAgoraExchange\\connfig.properties");
		System.out.println("In side properties files");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		config.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
   if(config.getProperty("browser").equals("chrome"))
   {
	   WebDriverManager.chromedriver().setup();
	   System.setProperty("webdriver.chrome.driver", "E:\\HANA\\chromedriver.exe");
	   driver = new ChromeDriver();
	   System.out.println("Chromedriver started successfully");
	   
   }
   else if(config.getProperty("browser").equals("edge"))
   {
	   WebDriverManager.edgedriver().setup();
	   System.setProperty("webdriver.edge.driver", "C:\\Users\\msedgedriver.exe");
	   driver = new EdgeDriver();
	   System.out.println("EdgeDriver started successfully");
   }
		//System.out.println("In OpenBrowser Method under BeforeSuite");
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\msedgedriver.exe");
		//E:\HANA\chromedriver.exe
		//System.setProperty("webdriver.chrome.driver", "E:\\HANA\\chromedriver.exe");
	}

	@BeforeClass
	public void enter_ApplicationUrl() {
		// driver = new EdgeDriver();
		//driver = new ChromeDriver();
	      driver.get("https://theagoraexchange.net/");
	      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();

		System.out.println("This is Before Test");
		
	}

}
