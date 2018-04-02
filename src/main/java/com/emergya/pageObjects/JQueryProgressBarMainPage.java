package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JQueryProgressBarMainPage extends BasePageObject {

	static Logger log = Logger.getLogger(JQueryProgressBarMainPage.class);

	private static final String LOGO = "cabecera";
	private static final String BAR = "bar";
	private static final String BAR2 = "bar2";
	// WITHOUT PROPERTIES
	private static final String BUTTONRANDOM = "numButton";
	private static final String BUTTONCOLOR = "colorButton";

	public JQueryProgressBarMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isReadyLogoProgressBar() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isReadyLogoProgressBar method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isReadyLogoProgressBar method");

		return this.isElementVisibleById(LOGO);
	}

	public void evaluateProgressBar() {
		// Change to iframe
		String cssSelectorFrame = "#content > iframe";
		WebElement frame = driver.findElement(By.cssSelector(cssSelectorFrame));
		driver.switchTo().frame(frame);

		// press the random-value button
		driver.clickIfExists(By.id(BUTTONRANDOM));

		// obtain the progressbar id and select it.
		WebElement bar = this.getElementById(BAR);
		String numero = bar.getAttribute("aria-valuenow");

		driver.sleep(3);
		// go to the default page
		driver.switchTo().defaultContent();

		// do scroll page's top
		WebElement doUp = driver.findElement(By.tagName("header"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", doUp);
		driver.sleep(3);

		// show a popup with the charge's percentage
		js.executeScript("window.confirm(('The progress bar is ...'+" + numero + "+'%'));");
		driver.sleep(5);
		driver.switchTo().alert().accept();

	}

	public void randomColor() {
		// Change to iframe
		String cssSelectorFrame = "#content > iframe";

		WebElement frame = driver.findElement(By.cssSelector(cssSelectorFrame));
		driver.switchTo().frame(frame);

		// press the random-value button
		driver.clickIfExists(By.id(BUTTONCOLOR));

		// obtain the progressbar id and select it.
		WebElement bar = this.getElementByXPath(BAR2);
		String color = bar.getAttribute("style");
		System.err.println("el color es" + color);
		// String colorSplit = color.substring(24,43);


		driver.sleep(2);

		// go to the default page
		driver.switchTo().defaultContent();

		// do scroll page's top
		WebElement doUp = driver.findElement(By.tagName("header"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", doUp);
		driver.sleep(2);

		

	}



}
