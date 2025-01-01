package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	public static WebDriver driver;
	private static Workbook workbook;
    private static Sheet sheet;

    public static void excelUtils(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Excel file: " + filePath);
        }
    }
// Get row data as a map
    public Map<String, String> getRowData(String testCaseName) {
        Map<String, String> rowData = new HashMap<>();
        Row headerRow = sheet.getRow(0); // First row contains headers

        for (Row row : sheet) {
            Cell testCaseCell = row.getCell(0); // First column has test case names
            if (testCaseCell != null && testCaseCell.getStringCellValue().equalsIgnoreCase(testCaseName)) {
                for (int i = 1; i < row.getLastCellNum(); i++) {
                    String header = headerRow.getCell(i).getStringCellValue();
                    Cell cell = row.getCell(i);
                    String value = getCellValueAsString(cell); // Convert cell value to string
                    rowData.put(header, value);
                }
                break;
            }
        }
        return rowData;
    }

    
 // Utility method to convert cell value to String
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // Format date if needed
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue()); // Convert to long for integers
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

   

    public void closeWorkbook() {
        try {
            if (workbook != null) workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	
  //to launch the browser
	public static void browserIntialization()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com");
	}
	//validate if the given URL Link is broken.

	public static void urlBrokenVerification()
	{
		String screenTitle=driver.getTitle();
		Assert.assertTrue(true,"URL is Not broken");
	}
	public static void excelUtils()
	{
		
	}
	public static void browserRefresh()
	{
		driver.navigate().refresh();
	}
	//for scrolldowon
	public static void scrollDown()
	{
		// Cast the WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to the bottom of the page
        js.executeScript("window.scrollTo(300, document.body.scrollHeight);");
	}
	public static void phoneError(String actualMessage,String expectedMessage)
	{
	Assert.assertTrue(actualMessage.equals(expectedMessage),"Expected error message: "+expectedMessage);
		
		
	}
}
