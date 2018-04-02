package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class TestingMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(TestingMainPage.class);

	/**
	 * Items keys selectors from properties.
	 */

	private static final String LOGO = "logotesting";
	private static final String IMAGEMOVE = "imagemove";
	private static final String IFRAME_XPATH = "iframe";
	private static final String LOGOQUERY = "logoquery";
	private static final String ZONEDROP = "//*[@id='content']/iframe";
	private static final String RESIZABLE = " //*[@id='resizable']/div[3]";
	private static final String FRAME = "//*[@id='content']/iframe";
	private static final String FRAMEDROPPABLE = "//*[@id='content']/iframe";
	private static final String DRAGGABLE = "draggable";
	private static final String DROPAREA = "droppable";
	/**
	 * START SELECTORS REGISTER Items key selectors without properties for the
	 * register
	 */
	private static final String CAMPONAME = "#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input";
	private static final String CAMPOLASTNAME = " #basicBootstrapForm > div:nth-child(1) > div:nth-child(3) > input";
	private static final String CAMPOADDRESS = "#basicBootstrapForm > div:nth-child(2) > div > textarea";
	private static final String CAMPOEMAIL = "#eid > input";
	private static final String CAMPOPHONE = "#basicBootstrapForm > div:nth-child(4) > div > input";
	private static final String CAMPOGENDER = "#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1) > input";
	private static final String CAMPOHOBBIE = "#checkbox2";
	// Items for select Language
	private static final String CAMPOLANGUAGE = "#msdd";
	private static final String CAMPOCLICKENGLISH = "#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li:nth-child(8) > a";
	private static final String CAMPOCLICKFUERA = "#section > div > div";
	// Items for select Skills
	private static final String CAMPOSKILLS = "#Skills";
	private static final String CAMPOANDROID = "#Skills > option:nth-child(5)";
	// Items for select Country
	private static final String CAMPOCOUNTRY = "#countries";
	private static final String CAMPOCOUNTRYDJIBOUTI = "#countries > option:nth-child(65)";
	// Items for select Country2
	private static final String CAMPOCOUNTRY2 = "#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span";
	private static final String CAMPOCOUNTRY2UNITED = "#country > option:nth-child(11)";
	// Items for Date of Birth
	private static final String CAMPOYEAR = "#yearbox";
	private static final String CAMPOYEAR1928 = "#yearbox > option:nth-child(14)";
	private static final String CAMPOMONTH = "#basicBootstrapForm > div:nth-child(11) > div:nth-child(3) > select";
	private static final String CAMPOMONTH9 = "#basicBootstrapForm > div:nth-child(11) > div:nth-child(3) > select > option:nth-child(10)";
	private static final String CAMPODAY = "#daybox";
	private static final String CAMPODAY3 = "#daybox > option:nth-child(4)";
	// Items for Password and ConfirmPassword
	private static final String CAMPOPASSWORD = "#firstpassword";
	private static final String CAMPOCONFIRMPASSWORD = "#secondpassword";
	// Item for Confirm Button
	private static final String BOTONSUBMIT = "#submitbtn";

	/**
	 * END SELECTORS REGISTER
	 */

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public TestingMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	/**
	 * Checks that the PO is ready
	 * 
	 * @param pageObject
	 *            page object to be used
	 */
	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = driver.isElementDisplayed(By.xpath(LOGO));

		if (driver.isElementDisplayed(By.xpath("//*[@id='header']/div/div/div/div[2]"))) {
			System.err.println("se ve por xpath");
		} else {

			System.err.println("no se ve por xpath");
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;

	}

	public boolean isTestingPageDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isTestingPageDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isTestingPageDisplayed method");

		// return this.isElementVisibleByXPath(LOGO);
		return this.isElementVisibleByXPath(LOGOQUERY);
	}

	public boolean writeName(String name) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPONAME))) {
			log.info("The field Name is  visible");
			driver.findElement(By.cssSelector(CAMPONAME)).sendKeys(name);
			status = true;
		} else {
			log.error("The field Name is not visible");
		}

		return status;
	}

	public boolean writeLastName(String lastName) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOLASTNAME))) {
			log.info("The field Last Name is  visible");
			driver.findElement(By.cssSelector(CAMPOLASTNAME)).sendKeys(lastName);
			status = true;
		} else {
			log.error("The field Last Name is not visible");
		}
		return status;
	}

	public boolean writeAddress(String address) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOADDRESS))) {
			log.info("The field Address is  visible");
			driver.findElement(By.cssSelector(CAMPOADDRESS)).sendKeys(address);
			status = true;
		} else {
			log.error("The field Address is not visible");
		}
		return status;
	}

	public boolean writeEmail(String email) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOEMAIL))) {
			log.info("The field Email is  visible");
			driver.findElement(By.cssSelector(CAMPOEMAIL)).sendKeys(email);
			status = true;
		} else {
			log.error("The field Email is not visible");
		}
		return status;
	}

	public boolean writePhone(String phone) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOPHONE))) {
			log.info("The field Phone is  visible");
			driver.findElement(By.cssSelector(CAMPOPHONE)).sendKeys(phone);
			status = true;
		} else {
			log.error("The field Phone is not visible");
		}
		return status;
	}

	public boolean selectGender() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOGENDER))) {
			log.info("The field Gender is  visible");
			driver.findElement(By.cssSelector(CAMPOGENDER)).click();
			status = true;
		} else {
			log.error("The field Gender is not visible");
		}
		return status;
	}

	public boolean selectHobbies() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOHOBBIE))) {
			log.info("The field Hobbies is  visible");
			driver.findElement(By.cssSelector(CAMPOHOBBIE)).click();
			status = true;
		} else {
			log.error("The field Hobbies is not visible");
		}
		return status;
	}

	public boolean selectLanguages() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOLANGUAGE))) {
			try {
				log.info("The field Languages is  visible");
				driver.findElement(By.cssSelector(CAMPOLANGUAGE)).click();
				// Thread.sleep(1000);

				driver.findElement(By.cssSelector(CAMPOCLICKENGLISH)).click();
				Thread.sleep(1000);
				log.info("The language selected is English");

				driver.findElement(By.cssSelector(CAMPOCLICKFUERA)).click();

				status = true;
			} catch (InterruptedException ie) {
				log.warn(ie.getMessage());
			}
		} else {
			log.error("The field Languages is not visible");
		}
		return status;
	}

	public boolean selectSkills() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOSKILLS))) {
			try {
				log.info("The field Skills is  visible");

				driver.findElement(By.cssSelector(CAMPOANDROID)).click();
				Thread.sleep(5000);
				log.info("The skill selected is Android");

				status = true;
			} catch (InterruptedException ie) {
				log.warn(ie.getMessage());
			}
		} else {
			log.error("The field Skills is not visible");
		}
		return status;
	}

	public boolean selectCountry() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOCOUNTRY))) {
			try {
				log.info("The field Country is  visible");

				driver.findElement(By.cssSelector(CAMPOCOUNTRYDJIBOUTI)).click();
				Thread.sleep(5000);
				log.info("The country selected is Djibouti");

				status = true;
			} catch (InterruptedException ie) {
				log.warn(ie.getMessage());
			}
		} else {
			log.error("The field Country is not visible");
		}
		return status;
	}

	public boolean selectCountry2() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOCOUNTRY2))) {
			try {
				log.info("The field Select Country is  visible");

				driver.findElement(By.cssSelector(CAMPOCOUNTRY2UNITED)).click();
				Thread.sleep(4000);
				log.info("The country selected is United States");

				status = true;
			} catch (InterruptedException ie) {
				log.warn(ie.getMessage());
			}
		} else {
			log.error("The field Select Country is not visible");
		}
		return status;
	}

	public boolean selectDateOfBirth() {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOYEAR))
				&& driver.isElementDisplayed(By.cssSelector(CAMPOMONTH))
				&& driver.isElementDisplayed(By.cssSelector(CAMPODAY))) {
			try {
				log.info("The field Year, Month and Day are visible");

				driver.findElement(By.cssSelector(CAMPOYEAR1928)).click();
				Thread.sleep(1000);
				log.info("The Year is selected");

				driver.findElement(By.cssSelector(CAMPOMONTH9)).click();
				Thread.sleep(1000);
				log.info("The Month is selected");

				driver.findElement(By.cssSelector(CAMPODAY3)).click();
				log.info("The Day is selected");

				status = true;
			} catch (InterruptedException ie) {
				log.warn(ie.getMessage());
			}
		} else {
			log.error("The field Select Country is not visible");
		}
		return status;
	}

	public boolean writePassword(String password) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOPASSWORD))) {
			log.info("The field Password is  visible");
			driver.findElement(By.cssSelector(CAMPOPASSWORD)).sendKeys(password);
			status = true;
		} else {
			log.error("The field Password is not visible");
		}
		return status;
	}

	public boolean writeConfirmPassword(String password) {
		boolean status = false;
		if (driver.isElementDisplayed(By.cssSelector(CAMPOCONFIRMPASSWORD))) {
			log.info("The field Confirm Password is  visible");
			driver.findElement(By.cssSelector(CAMPOCONFIRMPASSWORD)).sendKeys(password);
			status = true;
		} else {
			log.error("The field Confirm Password is not visible");
		}
		return status;
	}

	/**
	 * This method click on COnfirm button
	 * 
	 * @return
	 */
	public TestingWebMainPage clickOnSubmitButton() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");

		if (driver.isElementDisplayed(By.cssSelector(BOTONSUBMIT))) {
			log.info("The button Submit is  visible");
			driver.findElement(By.cssSelector(BOTONSUBMIT)).click();

		} else {
			log.error("The field Confirm Password is not visible");
		}

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new TestingWebMainPage(driver);

	}

	public void dragAndDrop() {

		try {
			Actions action = new Actions(driver);
			action.clickAndHold(driver.findElementById("angular")).moveToElement(driver.findElementById("droparea"))
					.release().build().perform();
			// Thread.sleep(3000);

			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public boolean dragTheItemByActions() throws InterruptedException {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start dragTheItem method");

		Actions action = new Actions(driver);

		WebElement frame = this.getElementByXPath(IFRAME_XPATH);
		driver.switchTo().frame(frame);
		WebElement draggableItem = driver.findElementById("draggable");
		// WebElement zoneDrop = driver.findElementByXPath(ZONEDROP);

		action.clickAndHold(draggableItem).moveByOffset(100, 100).release().build().perform();
		Thread.sleep(5000);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End dragTheItem method");
		return status;
	}

	public boolean resizableItemByActions() throws InterruptedException {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start resizableItemByActions method");

		Actions action = new Actions(driver);
		WebElement frame = driver.findElementByXPath(FRAME);
		driver.switchTo().frame(frame);
		WebElement resizable = driver.findElementByXPath(RESIZABLE);

		action.clickAndHold(resizable).moveByOffset(300, 300).release().build().perform();
		Thread.sleep(5000);

		// action.clickAndHold(draggableItem).moveToElement(zoneDrop)
		// .release().build().perform();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End resizableItemByActions method");
		return status;
	}

	public boolean droppableItemByActions() throws InterruptedException {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start droppableItemByActions method");

		Actions action = new Actions(driver);
		WebElement frame = driver.findElementByXPath(FRAMEDROPPABLE);
		driver.switchTo().frame(frame);
		WebElement draggable = driver.findElementById(DRAGGABLE);
		WebElement drop = driver.findElementById(DROPAREA);

		action.clickAndHold(draggable).moveToElement(drop).release().build().perform();
		Thread.sleep(5000);

		// action.clickAndHold(draggableItem).moveToElement(zoneDrop)
		// .release().build().perform();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End droppableItemByActions method");
		return status;
	}

	public void doAll() {
		try {
			writeName("Juan");
			writeLastName("Martinez");
			writeAddress("C/falsa , 123");
			writeEmail("juan@prueba.es");
			writePhone("9564781235");
			selectGender();
			selectHobbies();
			selectLanguages();
			selectSkills();
			selectCountry();
			selectCountry2();
			selectDateOfBirth();
			writePassword("Hola123h");
			writeConfirmPassword("Hola123h");

			Thread.sleep(3000);

			clickOnSubmitButton();
		} catch (InterruptedException ie) {

			log.warn(ie.getMessage());
		}
		
	}

}
