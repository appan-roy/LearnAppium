package calculatorDemo;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class OpenCalculatorTest {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		
		try {
			
			openCalculator();
			
		} catch (Exception e) {
			
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	public static void openCalculator() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Device setup
		cap.setCapability("deviceName", "Moto E4 Plus");	//device model
//		cap.setCapability("udid", "ZH33L2THP6");	//cmd prompt --> adb devices -- USB cable connected
		cap.setCapability("udid", "192.168.0.3:5555");	//cmd prompt --> adb devices -- WiFi connected
		cap.setCapability("platformName", "Android");	//device OS name
		cap.setCapability("platformVersion", "7.1.1");	//device OS version
		
		//App setup for Native Apps
		cap.setCapability("appPackage", "com.google.android.calculator");	//APK info app
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");	//APK info app
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Mobile calculator is up and running");
		
		driver.quit();
		
	}
	
}
