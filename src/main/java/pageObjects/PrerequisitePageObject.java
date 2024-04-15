package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import reusableComponents.CommonMethods;
import testBase.TestBase;

import java.util.HashMap;
import java.util.List;

public class PrerequisitePageObject extends TestBase {

    @FindBy(className = "css-h4y409-MuiList-root")
    WebElement Menulist;

    @FindBy(xpath = "//button[normalize-space()='Add Prerequisite']")
    static WebElement addNewPrerequisite;

    @FindBy(className = "css-11u53oe-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input")
    static List <WebElement> Coursedropdown;

    @FindBy(id = "menu-")
    static WebElement dynaMenu;

    @FindBy(className = "css-kk1bwy-MuiButtonBase-root-MuiMenuItem-root")
    static List<WebElement> Selectdropdown;

    @FindBy(name= "prerequisite_name")
    WebElement fillPrerequisite;

    @FindBy(name = "content")
    WebElement fillContent;

    @FindBy(xpath = "//button[normalise-space() = 'UPLOAD PREREQUISITE']")
    WebElement btnUploadPrerequisite;

    @FindBy(className = "css-nxo287-MuiInputBase-input-MuiOutlinedInput-input")
    WebElement SearchPrerequisitebtn;

    @FindBy(className = "css-1fu7jd5-MuiButtonBase-root-MuiButton-root")
    WebElement UploadPrerequisitebtn;

    @FindBy(xpath = "//div[contains(text(),'You have successfully uploaded Prerequisite')]")
    WebElement successMsg;

    @FindBy(xpath = "//*[id= 'menu-']/div[3]/ul/li")
    List<WebElement> drp_ListOfCourses;

    //Prerequisite Courses
    public PrerequisitePageObject() {
        PageFactory.initElements(driver, this);
    }

public void addprereqdetails(HashMap<String, String> prtestdata) throws InterruptedException {

        WebElement AddPrerequisitebtn = Menulist.findElements(By.className("css-uxa1ks-MuiListItem-root")).get(6).findElement(By.className("css-1fqi8hc-MuiButtonBase-root-MuiListItemButton-root"));
        AddPrerequisitebtn.findElement(By.className("css-i4bv87-MuiSvgIcon-root")).click();
        Thread.sleep(5000);
        CommonMethods.click(addNewPrerequisite);
        CommonMethods.click(Coursedropdown.get(0));
        List<WebElement> courseListItems = dynaMenu.findElement(By.tagName("ul")).findElements(By.tagName("li"));
        //System.out.println("Input course: "+prtestdata.get("Course"));
        CommonMethods.click(courseListItems.stream().filter(
                webElement -> {
                   // System.out.println(webElement.getText());
                    return webElement.getText().equalsIgnoreCase(prtestdata.get("Course"));
                }
        ).findFirst().get());
        //CommonMethods.click(fillPrerequisite);
        CommonMethods.sendKeysToElement(fillPrerequisite, prtestdata.get("Prerequisite Details"));

        //CommonMethods.click(fillContent);
        CommonMethods.sendKeysToElement(fillContent, prtestdata.get("Content Details"));
    CommonMethods.click(UploadPrerequisitebtn);
    }

    }












