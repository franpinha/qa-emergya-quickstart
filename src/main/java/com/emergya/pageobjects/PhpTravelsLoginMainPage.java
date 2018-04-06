package com.emergya.pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class PhpTravelsLoginMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(PhpTravelsLoginMainPage.class);

	private static final String LOGOLOGINPHP = "logologinphp";
	private static final String EMAIL = "inputemail";

	public PhpTravelsLoginMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isPhpTravelsLoginPageLogoDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isPhpTravelsLoginPageLogoDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isPhpTravelsLoginPageLogoDisplayed method");

		return this.isElementVisibleByXPath(LOGOLOGINPHP);
	}

	public void writeFields() throws IOException {
		
		if (this.isElementVisibleById(EMAIL)) {
			driver.findElementById("inputEmail").sendKeys("estoesdeprueba@yopmail.com");
			driver.findElementById("inputPassword").sendKeys(encriptPass("estoesdeprueba46"));

		}
	}

	public String encriptPass(String pass) throws IOException {
		String path = "/home/fjmartinez/Escritorio/almacenClaves.txt";
		File file = new File(path);
		String passMd5="";
		BufferedReader br = null ;
		try {
		
			if (file.exists()) {
			 br = new BufferedReader(new java.io.FileReader(file));

			pass = br.readLine();
		
			log.warn("The file already exists");

			passMd5 = DigestUtils.md5Hex(pass);
			log.info(passMd5);
			
		}
		
		}catch(Exception e2) {
			log.warn(e2.getMessage());
		
		}finally {
			br.close();
		}

		return pass;
	}

}
