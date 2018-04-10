package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.elements.Element;
import edu.bsuir.elements.candidatepageelements.CandidatePageElements;
import edu.bsuir.elements.candidatepageelements.CreateCandidatePageElements;
import edu.bsuir.helper.Helper;
import edu.bsuir.pages.CreateCandidatePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateCandidatePageUsingFailesTest extends LoginPageTest {
    private WebDriver driver = WebDriverSingleton.getInstance();
    CreateCandidatePage createCandidatePage = new CreateCandidatePage();
    private static final String ERROR_MESSAGE_CREATING = "Проверьте обязательные поля";

    @Before
    public void candidatesPreconditions() throws JAXBException {
        testLogin();
        createCandidatePage.openCreateCandidatePage();
    }

    @Test
    public void uploadFileProfileImageUsingSelenium() {
        final String noAvatar = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/no-avatar.jpg";

        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        driver.findElement(By.xpath("//input[@id='profileImage']")).sendKeys(getAbsolutePath("src/resources/human.png"));
        WebElement picture = driver.findElement(By.id("currentImage"));
        System.out.println(picture.getAttribute("src"));
        Assert.assertNotEquals(picture.getAttribute("src"), noAvatar);
    }

    @Test
    public void uploadFileUsingSelenium() {
        final String noAttachedFile = "//*[@id=\"attached-files\"]";

        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        driver.findElement(By.xpath("//*[@id=\"add-attachment\"]")).click();
        sendFile(getAbsolutePath("src/resources/human.png"));
        WebElement picture = driver.findElement(By.id("add-attachment"));
        System.out.println(picture.getAttribute("src"));
        Assert.assertNotEquals(picture.getAttribute("src"), noAttachedFile);
    }

    private String getAbsolutePath(String file) {
        Path path = Paths.get(file);
        return path.toAbsolutePath().toString();
    }

    private void sendFile(String path) {
        try {
            setClipboardData(path);
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    @Test
    public void uploadFileUsingSikuli() throws Exception {
        final String noAvatar = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/no-avatar.jpg";
        Pattern filePath = new Pattern("src/resources/FilePath.jpg");
        Pattern openButton = new Pattern("src/resources/OpenFile.jpg");

        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        driver.findElement(By.id("changeImgLink")).click();

        Screen screen = new Screen();
        screen.wait(filePath, 20);
        screen.type(filePath, getAbsolutePath("src/resources/human.png"));
        screen.click(openButton);
        Helper.wait(3);
        WebElement picture = driver.findElement(By.id("currentImage"));
        Assert.assertNotEquals(picture.getAttribute("src"), noAvatar);
    }

    @Test
    public void uploadResumeUsingInput() throws InterruptedException {
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        WebElement uploadButton = driver.findElement(By.id("profileCVInput"));
        uploadButton.sendKeys(getAbsolutePath("src/resources/EvseiIrina.docx"));
        Helper.wait(4);
        Assert.assertEquals( "Irina", CreateCandidatePageElements.NAME.getElement().getAttribute("value"));
        Assert.assertEquals( "Evsei", CreateCandidatePageElements.SURNAME.getElement().getAttribute("value"));
        Assert.assertEquals( "+375333496571", CreateCandidatePageElements.PHONE.getElement().getAttribute("value"));
        Assert.assertEquals( "Belarus", CreateCandidatePageElements.COUNTRY.getElement().getAttribute("value"));
        Assert.assertEquals( "Minsk", CreateCandidatePageElements.CITY.getElement().getAttribute("value"));
        Assert.assertEquals( "11", CreateCandidatePageElements.DATE_OF_BIRTH_DAY.getElement().getAttribute("value"));
        Assert.assertEquals( "4", CreateCandidatePageElements.DATE_OF_BIRTH_MONTH.getElement().getAttribute("value"));
        Assert.assertEquals( "1998", CreateCandidatePageElements.DATE_OF_BIRTH_YEAR.getElement().getAttribute("value"));
    }
    @Test
    public void uploadFileUsingRobot() throws InterruptedException {
        driver.get("http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile");
        createCandidatePage.uploadFileUsingRobot("EvseiIrina.docx");
        Helper.wait(3);
        Assert.assertEquals(CreateCandidatePageElements.ADDED_ATTACHMENT.getElement().getText(),"EvseiIrina.docx");
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
