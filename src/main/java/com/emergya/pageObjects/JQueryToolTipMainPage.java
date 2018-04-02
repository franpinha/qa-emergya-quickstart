package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JQueryToolTipMainPage extends BasePageObject {
	
	static Logger log = Logger.getLogger(JQueryToolTipMainPage.class);

	private static final String LOGO = "cabecera";
	
	private static final String OVERLABEL="#age";
	
	private static final String  TEXTEMERGENT="#content > div.view-source > div > div > table > tbody > tr > td.code > pre > div:nth-child(31) > div > code > span:nth-child(4) > span:nth-child(5)";

	private static final String OBTAINTEXTID="age";
	
	private static final String LABELSEARCH= "labelsearch";
	
	public JQueryToolTipMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isReadyLogoToolTip() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isReadyLogoToolTip method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isReadyLogoToolTip method");

		return this.isElementVisibleById(LOGO);
	}
	
	public void moveCopyAndPaste() {
		// Change to iframe
				String cssSelectorFrame = "#content > iframe";

				WebElement frame = driver.findElement(By.cssSelector(cssSelectorFrame));
				driver.switchTo().frame(frame);
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.cssSelector(OVERLABEL))).build().perform();
				driver.sleep(2);
				driver.moveMouseOverElement(By.cssSelector(OVERLABEL));
				driver.sleep(1);
				
				WebElement textoEmergente = this.getElementById(OBTAINTEXTID);
				String texto = textoEmergente.getAttribute("title");
				
				//return to default frame
				driver.switchTo().defaultContent();
				
				driver.clickIfExists(By.xpath(LABELSEARCH));
			
				this.getElementByXPath(LABELSEARCH).sendKeys(texto);
				
				
				//String titulo=driver.findElement(By.id("age")).getAttribute("title");
				System.err.println("el titulo es "+texto);
				
				driver.sleep(4);
		
	}

}
