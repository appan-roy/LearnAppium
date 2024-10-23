package calculatorDemo;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class VerifyCalculatorAddition {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		
		try {
			
			openCalculator();
			
		} catch (Exception e) {
			
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		checkAddResult();
		
	}

	public static void openCalculator() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Device setup
		cap.setCapability("deviceName", "Moto E4 Plus");	//device model
		cap.setCapability("udid", "192.168.0.3:5555");	//cmd prompt --> adb devices -- WiFi connected
		cap.setCapability("platformName", "Android");	//device OS name
		cap.setCapability("platformVersion", "7.1.1");	//device OS version
		
		//App setup for Native Apps
		cap.setCapability("appPackage", "com.google.android.calculator");	//APK info app
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");	//APK info app
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Mobile calculator is up and running");
		
	}
	
	public static void checkAddResult() {
		
		MobileElement seven = driver.findElementById("com.google.android.calculator:id/digit_7");
		MobileElement plus = driver.findElementById("com.google.android.calculator:id/op_add");
		MobileElement five = driver.findElementById("com.google.android.calculator:id/digit_5");
		MobileElement equals = driver.findElementById("com.google.android.calculator:id/eq");
		
		seven.click();
		plus.click();
		five.click();
		equals.click();
		
		MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
		
		String addResult = result.getText();
		
		System.out.println("The add result of 7 and 5 is "+addResult);
		
		if(addResult.equalsIgnoreCase("12")) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		
		driver.quit();
		
	}
	
}
