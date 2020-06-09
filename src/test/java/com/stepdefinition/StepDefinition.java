package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pages.PojoClass;

import cucumber.api.java.en.*;


public class StepDefinition extends BaseClass {
	static PojoClass pojo;
	@Given("The user launches Chrome Browser")
	public void the_user_launches_Chrome_Browser() {
		launchBrowser();
	}

	@Given("Login screen of whatsapp web application is displayed")
	public void login_screen_of_whatsapp_web_application_is_displayed() {
		loadUrl("https://web.whatsapp.com/");
	}

	@When("User opens whatsapp web application in a new tab")
	public void user_opens_whatsapp_web_application_in_a_new_tab() {
		newWindow();
		loadUrl("https://web.whatsapp.com/");
	}

	@When("Switches back to previous tab")
	public void switches_back_to_previous_tab() {
		switchToWindow(0);
	}

	@Then("A popup with the message _Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ should be displayed with _CLOSE_ & _USE HERE_ options")
	public void a_popup_with_the_message__Whatsapp_is_open_in_another_window_Click__Use_Here__to_use_WhatsApp_in_this_window__should_be_displayed_with__CLOSE___USE_HERE__options() {
		pojo=new PojoClass();
		WebElement mess = pojo.getMess();
		boolean messCheck = mess.isDisplayed();
		if (messCheck == true) {
			System.out.println("First Scenario has passed. "+mess.getText());

		} else {
			System.out.println("First Scenario Failed. Message is not displayed.");
		}
		screensShot();
		Assert.assertTrue("To check whether the pop-up is displayed", messCheck);
		quitBrowser();
	}

	@Given("A popup with the message _ Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ is displayed")
	public void a_popup_with_the_message___Whatsapp_is_open_in_another_window_Click__Use_Here__to_use_WhatsApp_in_this_window__and_options__CLOSE___USE_HERE__is_displayed() {
		loadUrl("https://web.whatsapp.com/");
		newWindow();
		loadUrl("https://web.whatsapp.com/");
		switchToWindow(0);
	}

	@When("User clicks on _USE HERE_ option")
	public void user_clicks_on__USE_HERE__option() {
		pojo=new PojoClass();
		WebElement useHere = pojo.getUseHere();
		buttonClick(useHere);
	}

	@Then("Login page of whatsapp should get loaded")
	public void login_page_of_whatsapp_should_get_loaded() {
		
	}

	@Then("In the previous tab, popup with message  _Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ should be displayed")
	public void in_the_previous_tab_popup_with_message__Whatsapp_is_open_in_another_window_Click__Use_Here__to_use_WhatsApp_in_this_window__and_options__CLOSE___USE_HERE__should_be_displayed() {
		pojo=new PojoClass();
		switchToWindow(1);
		WebElement popUp = pojo.getMess();
		boolean messCheck = popUp.isDisplayed();
		if (messCheck == true) {
			System.out.println("Second Scenario has passed .");
		} else {
			System.out.println("Second Scenario. Message is not displayed.");
		}
		screensShot();
		Assert.assertTrue("To check whether the pop-up is displayed", messCheck);
		quitBrowser();
	}

	@Given("The popup with the message _ Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ is displayed")
	public void the_popup_with_the_message___Whatsapp_is_open_in_another_window_Click__Use_Here__to_use_WhatsApp_in_this_window__and_options__CLOSE___USE_HERE__is_displayed() {
		loadUrl("https://web.whatsapp.com/");
		newWindow();
		loadUrl("https://web.whatsapp.com/");
		switchToWindow(0);
	}

	@When("User clicks on _CLOSE_ option")
	public void user_clicks_on__CLOSE__option() {
		pojo=new PojoClass();
		WebElement close = pojo.getClose();
		buttonClick(close);
	}

	@Then("Whatsapp.com page should get loaded")
	public void whatsapp_com_page_should_get_loaded() {
		String title = driver.getTitle();
		if (title.equals("WhatsApp")) {
			System.out.println("Third Scenario has passed successfully.");
		} else {
			System.out.println("Third Scenario failed. It is not loaded");
		}
		screensShot();
		Assert.assertTrue("To verify that Whatsapp has loaded when user clicks on the close button",title.equals("WhatsApp"));
		quitBrowser();
	}
}
