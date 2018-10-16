import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class depTest {
	
public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchText	() throws InterruptedException  {
		driver.get("https://www.bing.com/");
		enterDetails bingPage = PageFactory.initElements(driver, enterDetails.class);
		//search bingSearchPage = PageFactory.initElements(driver, search.class);
		Thread.sleep(500);
		bingPage.search("Selenium");
//		assertEquals("Selenium", bingPage.getSearch());	
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
