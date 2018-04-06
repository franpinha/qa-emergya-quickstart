package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SelectMultipleMainPage extends BasePageObject {

	private static final String OPCION1 = "#HTMLFormElements > table > tbody > tr:nth-child(7) > td > select > option:nth-child(1)";
	private static final String OPCION2 = "#HTMLFormElements > table > tbody > tr:nth-child(7) > td > select > option:nth-child(2)";

	static Logger log = Logger.getLogger(SelectMultipleMainPage.class);

	public SelectMultipleMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public void multipleSelect() {

		driver.clickIfExists(By.cssSelector(OPCION1));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL);
		builder.build().perform();

		driver.clickIfExists(By.cssSelector(OPCION2));
		builder.keyUp(Keys.CONTROL);
		builder.build().perform();

	}

}
