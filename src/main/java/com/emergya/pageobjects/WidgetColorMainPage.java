package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class WidgetColorMainPage extends BasePageObject {

	static Logger log = Logger.getLogger(WidgetColorMainPage.class);

	private static final String LOGO = "cabecera";
	private static final String BUTTONTOGGLE = "buttontoggle";
	private static final String BUTTONGREEN = "buttongreen";
	private static final String BUTTONTOPCOLOR = "#my-widget1 > button";

	public WidgetColorMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isReadyWidgetColorLogo() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start isReadyWidgetColor method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isReadyWidgetColor method");

		return this.isElementVisibleById(LOGO);
	}

	public void changeFrame() {
		// Change to iframe
		String cssSelectorFrame = "#content > iframe";
		WebElement frame = driver.findElement(By.cssSelector(cssSelectorFrame));
		driver.switchTo().frame(frame);
	}

	public void changeColor() {

		if (driver.isElementDisplayed(By.cssSelector(BUTTONTOPCOLOR))) {

			driver.clickIfExists(By.cssSelector(BUTTONTOPCOLOR));

		}

	}

	public void disableButton() {

		if (this.isElementVisibleById(BUTTONTOGGLE)) {
			this.getElementById(BUTTONTOGGLE).click();

			driver.sleep(2);
			changeColor();
			driver.sleep(1);

		}
	}

	public void changeAllGreen() {
		if (this.isElementVisibleById(BUTTONGREEN)) {

			this.getElementById(BUTTONGREEN).click();

		}

	}

	public void showPopupGreen() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.confirm(('All boxes are green ...'));");

		driver.sleep(5);
		driver.switchTo().alert().accept();

	}

	public void doAll() {
		changeFrame();
		changeColor();
		driver.sleep(2);
		disableButton();

		changeAllGreen();
		driver.sleep(2);
		showPopupGreen();
		// go to the default page
		driver.switchTo().defaultContent();

		// do scroll page's top
		WebElement doUp = driver.findElement(By.tagName("header"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", doUp);
		driver.sleep(2);
	}
}
