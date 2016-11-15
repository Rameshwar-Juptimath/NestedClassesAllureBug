
package org.cimm2touch.maincontroller;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.cimm2touch.utils.ApplicationSetUpPropertyFile;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.annotations.Attachment;

public class MainController implements IHookable {

	public static WebDriver driver;

	/*
	 * @author Hemanth.Sridhar
	 */
	public static String outputVideo = "";
	public static String outputFolder = "";
	private ScreenRecorder screenRecorder;
	public static String applicationSetUp = "resources/PropertyFiles/ApplicationSetUp.properties";
	public static String searchData = "resources/PropertyFiles/SearchData.properties";
	public static String TaxonomyData = "resources/PropertyFiles/TaxonomyData.properties";
	DesiredCapabilities caps = new DesiredCapabilities();


	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {

		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		@SuppressWarnings("unused")
		PageFactoryInitializer pageFactory = new PageFactoryInitializer();
		driver.get(setUp.getURL());
		driver.manage().deleteAllCookies();
	}


	@BeforeTest(alwaysRun = true)
	public void beforeTest() throws Exception {
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))

		{

			if (setUp.getBrowser().trim().equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "resources/drivers/Mac/chromedriver");
				driver = new ChromeDriver();

			} else if (setUp.getBrowser().trim().equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "resources/drivers/Mac/IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}

			else if (setUp.getBrowser().trim().equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			}

			else if (setUp.getBrowser().trim().equalsIgnoreCase("safari")) {
				driver = new SafariDriver();

			}

			else {
				System.out.println("cannot load driver");
			}
		}

		else if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
			if (setUp.getBrowser().trim().equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "resources/drivers/Windows/chromedriver.exe");
				driver = new ChromeDriver();

			} else if (setUp.getBrowser().trim().equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "resources/drivers/Windows/IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}

			else if (setUp.getBrowser().trim().equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else {
				System.out.println("cannot load driver");
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		callBack.runTestMethod(testResult);
		if (testResult.getThrowable() != null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				saveScreenshot(testResult.getName(), driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] saveScreenshot(String name, WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@AfterMethod(alwaysRun = true)
	public void callStopRecording() throws Exception {
		driver.manage().deleteAllCookies();
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		if (setUp.getVideoPermission().equalsIgnoreCase("yes")) {
			this.screenRecorder.stop();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		System.out.println("Ending Test Suite");
		driver.quit();

	}
}
