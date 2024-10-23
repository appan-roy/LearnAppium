package appInstallationDemo;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallAPK {

	static AppiumDriver<MobileElement> driver;
	static DesiredCapabilities cap;
	
	public static void main(String[] args) throws MalformedURLException {
		
		cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		cap.setCapability(MobileCapabilityType.UDID, "192.168.0.3:5555");
		
		//Relative path of the apk directory doesn't work. Need to provide absolute path.
		cap.setCapability(MobileCapabilityType.APP, "E:\\Softwares\\My PC Apps\\Appium\\Workspace\\LearnAppium\\APK Files\\API Demos.apk");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		driver.quit();
		
	}
	
}
