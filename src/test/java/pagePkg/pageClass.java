package pagePkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePkg.baseClass;

public class pageClass extends baseClass {

	@FindBy(xpath = "//input[@id=':re:']")
	WebElement location; // to clear current destination

	@FindBy(xpath = "//*[@id=\"autocomplete-result-0\"]/div/div/div/div[1]")
	WebElement munnar;

	@FindBy(xpath = "//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[2]/div")
	WebElement datePicker;

	@FindBy(xpath = "//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/h3")
	WebElement expectedMnthTitle;

	@FindBy(xpath = "//*[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 f671049264 deab83296e f4552b6561 dc72a8413c f073249358']")
	WebElement rightArrow;

	@FindBy(xpath = "//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr/td/span/span")
	List<WebElement> dates;

	@FindBy(xpath = "//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[3]")
	WebElement personalDetails;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[2]")
	WebElement addAdults;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[2]/div[2]/button[2]")
	WebElement addChildern;

	@FindBy(xpath = "//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[5]/div[2]/button[2]")
	WebElement addRooms;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/button")
	WebElement doneBtn;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/form/div[1]/div[4]/button")
	WebElement searchBtn;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[3]/div")
	WebElement ageDropDown;

	@FindBy(xpath = "//*[@name='age']")
	WebElement kidsAge;

	public pageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void destination() {
		location.click();
		munnar.click();
	}

	public void checkinoutDetails() {
		datePickerMethod("December 2023", "10");
		datePickerMethod("January 2024", "4");
	}

	private void datePickerMethod(String expMonth, String expDate) {

		while (true) {
			String month = expectedMnthTitle.getText();

			if (month.equals(expMonth)) {
				System.out.println("month " + month);
				break;
			} else {

				rightArrow.click();
			}

		}

		List<WebElement> allDates = dates;
		for (WebElement dateElement : allDates) {
			String date = dateElement.getText();
			if (date.equals(expDate)) {
				dateElement.click();
				break;
			}
		}

	}

	public void personalData() {
		personalDetails.click();
		addAdults.click();
		addChildern.click();

		ageDropDown.click();

		Select age = new Select(kidsAge);
		age.selectByValue("7");

		addRooms.click();
		doneBtn.click();

	}

	public void search() {
		searchBtn.click();
	}

}
