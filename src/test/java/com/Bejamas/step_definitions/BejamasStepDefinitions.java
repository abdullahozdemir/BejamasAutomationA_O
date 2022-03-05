package com.Bejamas.step_definitions;

import com.Bejamas.pages.MainPage;
import com.Bejamas.utilities.BrowserUtils;
import com.Bejamas.utilities.ConfigurationReader;
import com.Bejamas.utilities.Driver;
import static org.junit.Assert.*;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class BejamasStepDefinitions {

    MainPage mainPage = new MainPage();
    Actions actions = new Actions(Driver.get());
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();


    @Given("The user navigates to main page")
    public void the_user_navigates_to_main_page() {

        Driver.get().get(ConfigurationReader.get("url"));
        //Verify the correct page
        assertEquals("Verify the URL", "https://rozklad-pkp.pl/en", Driver.get().getCurrentUrl());

        //Handle the cookies
        mainPage.acceptCokies.click();

        //Handle the advirtisement with JS
        BrowserUtils.waitForClickablility(mainPage.closeAdv,10);
        js.executeScript("arguments[0].scrollIntoView(true);", mainPage.closeAdv);
        js.executeScript("arguments[0].click(true);", mainPage.closeAdv);




    }

    @When("The user hover over the module sign")
    public void the_user_hover_over_the_module_sign() {

        //Check all info pup-up working correctly
        mainPage.checkInfoPupUpIsWorking();

    }

    @Then("The user displays the related information")
    public void the_user_displays_the_related_information() {

        mainPage.verifyPupUp();

    }



    @When("The user enter {string} and {string} station")
    public void the_user_enter_and_station(String destination, String arrival) {

        mainPage.fromDataBox.sendKeys(destination);
        mainPage.toDataBox.sendKeys(arrival);

    }

    @When("The user selects the date and {string} as departure time")
    public void the_user_selects_the_date_and_as_departure_time(String time) {

        mainPage.nextDayArrow.click();
        mainPage.timeInput.sendKeys(time);

    }

    @When("Check the departure radio button is selected")
    public void check_the_departure_radio_button_is_selected() {

        assertTrue(mainPage.departureRB.isSelected());


    }

    @When("Click the Direct Connection check box")
    public void click_the_Direct_Connection_check_box() {

        mainPage.directCheckbox.sendKeys(Keys.SPACE);

    }

    @When("Click the search button")
    public void click_the_search_button() {

        mainPage.searchButton.click();


    }

    @Then("Check the result")
    public void check_the_result() {

        BrowserUtils.waitForPageToLoad(5);
        assertTrue(mainPage.verifyResultPage.getText().contains("DEPARTURE") || mainPage.verifyResultPage.getText().contains("ARRIVAL"));
        assertTrue(Driver.get().getCurrentUrl().contains("queryPageDisplayed"));


    }

    @When("The user enters {string},{string} and {string}")
    public void the_user_enters_and(String departure, String arrival, String addedStation) {

        js.executeScript("window.scrollBy(0,100)");

        mainPage.toDataBox.sendKeys(departure);
        mainPage.fromDataBox.sendKeys(arrival);
        mainPage.addStationInfo.click();
        BrowserUtils.waitForClickablility(mainPage.addInterStation,3);
        mainPage.addInterStation.sendKeys(addedStation);

    }


    @And("Click the arrival radio button and check it is selected")
    public void clickTheArrivalRadioButtonAndCheckItIsSelected() {

        js.executeScript("arguments[0].scrollIntoView(true);", mainPage.arrivalRB);
        js.executeScript("arguments[0].click(true);", mainPage.arrivalRB);


        BrowserUtils.waitFor(1);



    }
}
