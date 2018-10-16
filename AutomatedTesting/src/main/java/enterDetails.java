import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class enterDetails {

	@FindBy (xpath = "//*[@id=\"sb_form_q\"]")
	private WebElement searchbox;

	public void search (String text) {
		searchbox.sendKeys(text);
		searchbox.submit();
		
	}

	public Object getSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
