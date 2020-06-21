package OrangeHRMTest;

import OrangeHRMPages.EmployeeLeaveProcessPage;
import Utility.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public static Properties prop, genericProp;
    String cmd;
    String filePath, chromePath, runningOS, folderPath;

    public EmployeeLeaveProcessPage employeeLeaveProcessPage;
    public String allurePathWin = "C:/allure-2.6.0/bin/allure.bat";

    public String allurePathLinux = "/var/lib/jenkins/tools/ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation/default/bin/allure";

    /**
     * Reading Data from Property File
     */
    public void property() {

        if (this.getClass().getCanonicalName().contains("EmployeeLeaveProcessTest")) {
            filePath = System.getProperty("user.dir") + "/src/main/resources/employeeLeaveProcess.properties";
        }

        try {
            prop = new Properties();
            FileInputStream fip = new FileInputStream(filePath);
            try {
                prop.load(fip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Browser Configuration
     */
    @BeforeSuite
    public void setUp() throws InterruptedException {

        emptyResults();
        genericProperty();
        property();
        if (genericProp.getProperty("browser").equalsIgnoreCase("chrome")) {

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setJavascriptEnabled(true);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            chromePath = System.getProperty("user.dir") + prop.getProperty("chromeDriverPath");
            System.setProperty("webdriver.chrome.driver", chromePath);
            options.addArguments("--start-maximized");
//            options.addArguments("--headless");
//            options.addArguments("--window-size=1366,768");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.get(genericProp.getProperty("base_url"));
            Thread.sleep(1000);

            System.out.println("Start Time: " + Utilities.getUtilities().getDateTime());
        }
        employeeLeaveProcessPage = PageFactory.initElements(driver, EmployeeLeaveProcessPage.class);
    }

    public void genericProperty() {
        filePath = System.getProperty("user.dir") + "/src/main/resources/generic.properties";
        genericProp = new Properties();
        try {
            FileInputStream fip = new FileInputStream(filePath);
            try {
                genericProp.load(fip);
                String urlEnv = getURLFromEnv();
                if (urlEnv != null && !urlEnv.isEmpty()) {
                    genericProp.setProperty("base_url", urlEnv);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fetch 'URL' from System Property which is supplied with the -D flag on CLI.
     *
     * @return URL
     */
    private String getURLFromEnv() {
        String urlEnv = System.getProperty("base_url");
        return urlEnv;
    }

    public void emptyResults() {
        try {
            for (File file : new java.io.File(System.getProperty("user.dir") + "/allure-results").listFiles())
                if (!file.isDirectory()) {
                    file.delete();
                }
        } catch (Exception E) {

        }
    }

    @AfterSuite
    public void tearDown() throws IOException, InterruptedException {

        runningOS = System.getProperty("os.name").toLowerCase();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss");

        String currentDateTime = format.format(date);

        if (getClass().getCanonicalName().contains("EmployeeLeaveProcessTest")) {
            folderPath = System.getProperty("user.dir") + "/allure-results/Reports/EmployeeLeaveProcess/" + "__" + currentDateTime;
        } 

        File theDir = new File(folderPath);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try {

                theDir.mkdirs();
                result = true;
            } catch (SecurityException se) {
                // handle it
                System.out.println(se.getMessage());
            }
            if (result) {
                System.out.println("Folder created");
            }
        } else if (theDir.exists()) {
            System.out.println("Folder exist");

        }

        if (getClass().getCanonicalName().contains("EmployeeLeaveProcessTest")) {
            if (runningOS.contains("linux")) {
                cmd = allurePathLinux + " generate" + " " + System.getProperty("user.dir") + "/allure-results -o" + " " + System.getProperty("user.dir") + "/allure-results/Reports/EmployeeLeaveProcess/" + theDir.getName();
            } else {
                cmd = allurePathWin + " generate" + " " + System.getProperty("user.dir") + "/allure-results -o" + " " + System.getProperty("user.dir") + "\\allure-results\\Reports\\EmployeeLeaveProcess" +
                        "\\" + theDir.getName();
            }
        }

        System.out.println("Before Report Process");
        System.out.println("This is CMD : " + cmd);
        Process process = Runtime.getRuntime().exec(cmd);

        Thread.sleep(10000);
        System.out.println("Generating Report");
        process.waitFor(60, TimeUnit.SECONDS);
        System.out.println("After Report Process");
        Thread.sleep(10000);
        //  driver.quit();
        // System.out.println("End Time: " + Utilities.getUtilities().getDateTime());
        killChromeDriver();

    }

    public void killChromeDriver() {
        String cmd = "taskkill /f /t /IM chromedriver.exe";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End Time: " + Utilities.getUtilities().getDateTime());
    }

    /**
     * Kill chrome driver for linux.
     *
     * @throws InterruptedException
     * @throws IOException
     */
    public void killChromeDriverForLinux() throws InterruptedException, IOException {
        String cmd = "sudo killall chromedriver";
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        System.out.println("End Time: " + Utilities.getUtilities().getDateTime());
    }


}
