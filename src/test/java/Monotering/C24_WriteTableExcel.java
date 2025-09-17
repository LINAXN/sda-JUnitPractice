package Monotering;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class C24_WriteTableExcel extends TestBase {

     /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    @Test
    void writeTableExcelTest() throws IOException {

        driver.get("https://claruswaysda.github.io/webTable.html");

        // Locate Table 1
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));

        // Get all rows
        List<WebElement> rows = table1.findElements(By.tagName("tr"));

        // Create Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");

        // Loop through rows and columns
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);

            List<WebElement> cells = rows.get(i).findElements(By.xpath("./th|./td"));

            for (int j = 0; j < cells.size(); j++) {
                Cell excelCell = excelRow.createCell(j);
                excelCell.setCellValue(cells.get(j).getText());
            }
        }

        // Save to file
        FileOutputStream fos = new FileOutputStream("Table1.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("✅ Table 1 written successfully to Table1.xlsx");
    }
}



