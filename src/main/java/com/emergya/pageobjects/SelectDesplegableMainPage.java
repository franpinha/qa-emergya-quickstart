package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SelectDesplegableMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(SelectDesplegableMainPage.class);
	// with properties
	private static final String LOGO = "nameandslogan";

	// without properties
	private static final String MULTISELECT = "//input[@class='select2-search__field']";
	private static final String TERRITORY = "//*[@id='select2-x01n-container']";

	public SelectDesplegableMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isSelectDesplegableLogoDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isSelectDesplegableLogoDisplayed method");

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isSelectDesplegableLogoDisplayed method");

		return this.isElementVisibleById(LOGO);

	}

	public void selectCountry() {
		Select dropdown = new Select(driver.findElement(By.id("country")));
		dropdown.selectByValue("United States of America");
		driver.sleep(2);
	}

	public void multiSelect() {

		if (driver.isElementDisplayed(By.xpath(MULTISELECT))) {
			driver.findElementByXPath(MULTISELECT).click();
			Select dropdownMultiple = new Select(driver
					.findElementByXPath(("//select[@class='js-example-basic-multiple select2-hidden-accessible']")));
			dropdownMultiple.selectByValue("DC");
			driver.sleep(2);
			dropdownMultiple.selectByValue("CT");
			driver.sleep(1);

		}

	}

	public void selectTerritories() {

		Select dropdownTerritory = new Select(
				driver.findElementByXPath("//select[@class='js-example-disabled-results select2-hidden-accessible']"));
		dropdownTerritory.selectByValue("MP");
		driver.sleep(2);
	}

	public void selectProgramming() {
		Select dropdownFile = new Select(driver.findElementById("files"));
		dropdownFile.selectByVisibleText("Java");
		driver.sleep(2);
	}
}
