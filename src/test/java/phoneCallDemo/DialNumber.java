package phoneCallDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialNumber {

	static AppiumDriver<MobileElement> driver;
	static DesiredCapabilities cap;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		cap = new DesiredCapabilities();

		//Device setup
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		cap.setCapability(MobileCapabilityType.UDID, "192.168.0.3:5555");
		
		//App setup for Native Apps
		cap.setCapability("appPackage", "com.android.dialer");	//APK info app
		cap.setCapability("appActivity", "com.android.dialer.DialtactsActivity");	//APK info app
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		//Open Dialer App
		driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();
		
		Thread.sleep(2000);
		
		//Dial Number 9038183015
		driver.findElement(By.id("com.android.dialer:id/nine")).click();
		driver.findElement(By.id("com.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.android.dialer:id/three")).click();
		driver.findElement(By.id("com.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.android.dialer:id/one")).click();
		driver.findElement(By.id("com.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.android.dialer:id/three")).click();
		driver.findElement(By.id("com.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.android.dialer:id/one")).click();
		driver.findElement(By.id("com.android.dialer:id/five")).click();
		
		//Click on call button
		driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
		
		Thread.sleep(30000);
		
		driver.quit();
		
	}

}
