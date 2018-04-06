package com.emergya.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public  class MyBasePageObject extends BasePageObject{
	
	public MyBasePageObject(EmergyaWebDriver driver) {
		super(driver);
		
	}


	public static final String CONSTANTPAGEOBJECT=com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT;
	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(MyBasePageObject.class);
	/**
	    * This method will set any parameter string to the system's clipboard
	    * @param string is the path of the file
	    */
	   private void setClipboardData(String string) {
	       log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - Start setClipboardData method");

	       StringSelection stringSelection = new StringSelection(string);
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	       log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - End setClipboardData method");
	   }
	   
	   
	   /**
	    * Upload a image
	 * @throws AWTException 
	    */
	public void uploadArchive(String imageFile) throws AWTException {
	       log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start uploadArchive method");

	       File auxfile = new File("src/main/resources/files/" + imageFile);
	       String fileName = auxfile.getAbsolutePath();

	      
	           log.info("Uploading the image " + imageFile);
	           // Setting clipboard with file location
	           setClipboardData(fileName);

	           // Some sleep time to detect the window popup
	           driver.sleep(1);

	           Robot robot = new Robot();

	           // Delete the default string
	           robot.keyPress(KeyEvent.VK_SHIFT);
	           robot.keyPress(KeyEvent.VK_END);
	           robot.keyRelease(KeyEvent.VK_SHIFT);
	           robot.keyRelease(KeyEvent.VK_END);
	           robot.keyPress(KeyEvent.VK_BACK_SPACE);
	           robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	           

	           // Copy the path to the window popup
	           robot.keyPress(KeyEvent.VK_CONTROL);
	           robot.keyPress(KeyEvent.VK_V);
	           robot.keyRelease(KeyEvent.VK_V);
	           robot.keyRelease(KeyEvent.VK_CONTROL);
	           driver.sleep(2);

	           // Press enter to execute a file search
	           robot.keyPress(KeyEvent.VK_ENTER);
	           robot.keyRelease(KeyEvent.VK_ENTER);
	           robot.delay(500);

	     

	       log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - End uploadArchive method");
	   }


	@Override
	public boolean isReady() {
		
		return false;
	}

}
