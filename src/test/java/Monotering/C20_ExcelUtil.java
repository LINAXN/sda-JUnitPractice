package Monotering;

import org.apache.poi.ss.usermodel.Cell;
import utillties.ExcelUtils;

public class C20_ExcelUtil {
    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/People.xlsx");
   Cell r3c5 = excelUtils.getcell("sheet3",2,4);
        System.out.println(r3c5);

    }
}
