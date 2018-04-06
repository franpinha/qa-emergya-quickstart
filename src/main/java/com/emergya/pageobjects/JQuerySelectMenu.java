package com.emergya.pageobjects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JQuerySelectMenu extends BasePageObject {

	static Logger log = Logger.getLogger(JQuerySelectMenu.class);

	// WITH PROPERTIES
	private static final String LOGO = "cabecera";
	private static final String SPEED = "speed";
	private static final String SELECTFAST = "selectfast";

	public JQuerySelectMenu(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;

	}

	public boolean isJQueryLogoSelectMenuDisplayed() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isJQueryLogoSelectMenuDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isJQueryLogoSelectMenuDisplayed method");

		return this.isElementVisibleById(LOGO);

	}

	public CheckBoxMainPage clickAndSelectSpeed() {
		String ruta="/home/fjmartinez/Documentos/screenshot.png";
		String xpathLink = "//*[@id='content']/iframe";
		WebElement frame = driver.findElementByXPath(xpathLink);
		driver.switchTo().frame(frame);

		this.getElementById(SPEED).click();
		driver.sleep(2);
		this.getElementById(SELECTFAST).click();
		driver.sleep(2);

		driver.switchTo().defaultContent();

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			Path p = Paths.get(ruta);
			
			if (p.toFile().exists()) {
				
				Files.delete(p);
			}
			FileUtils.copyFile(srcFile, new File(ruta));

		} catch (IOException e) {
			
			log.warn(Level.WARNING, e);
		}
		String cssLinkCheck = "#sidebar > aside:nth-child(2) > ul > li:nth-child(4) > a";
		driver.clickIfExists(By.cssSelector(cssLinkCheck));

		return new CheckBoxMainPage(driver);

	}

}
