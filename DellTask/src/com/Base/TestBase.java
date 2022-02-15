package com.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

   public String URL = "https://phptravels.org/login";
  
	public TestBase()  {
	
			 
                //set the path of chrome driver
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver-1.exe");

				// Initialize browser
				driver = new ChromeDriver();

				// Open the URL
				driver.get(URL);
				driver.manage().window().maximize();
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("resolution", "1024x768");
			
			}
	public static void CloseBrowser() {
		
		try {
			driver.quit();
		
		} catch (Exception ex) {
	
		}

	}

}
