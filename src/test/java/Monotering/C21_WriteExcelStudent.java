package Monotering;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C21_WriteExcelStudent {
    @Test
    void exceltest(){
         /*
Given: Save StudentScores.xlsx file into your project

When: In the grade column, write the letter grades (A, B, C, D, F) based on the score ranges:
A: 90-100
B: 80-89
C: 70-79
D: 60-69
F: below 60

Then: Assert that the grade of "Alice" is "A"
     */
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(new FileInputStream("src/test/resources/StudentScores.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet("Sheet1");
        int gradeColumnIndex = 2;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            Cell nameCell = row.getCell(0);
            Cell scoreCell = row.getCell(1);
            Cell gradeCell = row.getCell(gradeColumnIndex);

            if (gradeCell == null) gradeCell = row.createCell(gradeColumnIndex);

            double score = scoreCell.getNumericCellValue();
            String grade;

            if (score >= 90) grade = "A";
            else if (score >= 80) grade = "B";
            else if (score >= 70) grade = "C";
            else if (score >= 60) grade = "D";
            else grade = "F";

            gradeCell.setCellValue(grade);


            System.out.println(nameCell.getStringCellValue() + " || " +score+" || "+ grade);
        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell nameCell = row.getCell(0);
            Cell scoreCell = row.getCell(1);
            Cell gradeCell = row.getCell(gradeColumnIndex);
            if (nameCell.getStringCellValue().equals("Alice")) {
                System.out.println("Alice grade :  " + gradeCell.getStringCellValue());
                assertEquals("A", gradeCell.getStringCellValue());
            break;
            }
        }
    }
    }

