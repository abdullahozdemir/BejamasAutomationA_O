package com.Bejamas.pages;

import com.Bejamas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;


public class MainPage {

    public MainPage(){PageFactory.initElements(Driver.get(),this);}

    Actions actions = new Actions(Driver.get());



    @FindBy(xpath = "//button[@class=' css-47sehv']")
    public WebElement acceptCokies;

    @FindBy(xpath = "//span[@class='anchor_close']")
    public WebElement closeAdv;

    @FindBy(id = "wcag-h2")
    public WebElement timeInfoQM;

    @FindBy(id = "directCheckbox")
    public WebElement directCheckbox;

    @FindBy(id="wcag-h3")
    public WebElement connectionInfoQM;

    @FindBy(xpath = "//img[@alt='Select date']")
    public WebElement calenderInfo;

    @FindBy(xpath = "//img[@alt='Enter the time']")
    public WebElement timeInfo;

    @FindBy(xpath = "(//span[@class='ico-main-search-2 midpoint pover qhelp'])[1]")
    public WebElement addStationInfo;

    @FindBy(xpath = "(//img[@class='xs-pic'])[1]")
    public WebElement newQueryInfo;

    @FindBy(id = "hour")
    public WebElement timeInput;

    @FindBy(id = "from-station")
    public WebElement fromDataBox;

    @FindBy(id = "wcag-via")
    public WebElement addInterStation;

    @FindBy(id="to-station")
    public WebElement toDataBox;

    @FindBy(id="singlebutton")
    public WebElement searchButton;

    @FindBy(id = "odj")
    public WebElement departureRB;

    @FindBy(xpath = "(//ins[@class='iCheck-helper'])[2]")
    public WebElement arrivalRB;

    @FindBy(xpath = "//button[@class='right btn-pkp-reverse']")
    public WebElement nextDayArrow;

    @FindBy(xpath = "//span[@class='name-hour']")
    public WebElement verifyResultPage;

    /*
    This method verify the information of pup-up
     */
    public void verifyPupUp(){

        assertTrue("Clear the form".contains(newQueryInfo.getText()));
        assertTrue(("Option to add an intermediate station," +
                " i.e. you can plan your trip including e.g." +
                " stay in a specific town.").contains(addStationInfo.getAttribute("data-content")));
        assertTrue(("Selection of the date of departure or arrival of" +
                " the train").contains(calenderInfo.getText()));
        assertTrue(("Selection of the date of departure or arrival of" +
                " the train").contains(timeInfo.getText()));
        assertTrue(("Time may be entered with keyboard by clicking the" +
                " time field or changed with hour/minute arrows. Trip may" +
                " be planned by giving the time of departure from the departure" +
                " station or the time of arrival to the final station.").contains(timeInfoQM.getAttribute("data-content")));
        assertTrue(("Selection of additional connection options - additional options" +
                " allow you to better personalize you connection. You can select a direct " +
                "connection, a train with seats for persons with children and/or with bicycle" +
                " transport option, as well as choose a connection based on the type of" +
                " transport or carrier.").contains(connectionInfoQM.getAttribute("data-content")));
    }

    /*
    This method check the all sign information pup-up
     */
    public void checkInfoPupUpIsWorking(){

        actions.moveToElement(newQueryInfo).pause(1000).build().perform();
        actions.moveToElement(addStationInfo).pause(1000).build().perform();
        actions.moveToElement(calenderInfo).pause(1000).build().perform();
        actions.moveToElement(timeInfo).pause(1000).build().perform();
        actions.moveToElement(timeInfoQM).pause(1000).build().perform();
        actions.moveToElement(connectionInfoQM).pause(1000).build().perform();
    }

    }





