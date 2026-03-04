package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.*;

public class ReadXSLData {

    @DataProvider(name = "Credential")
    public Object[][] getCredentialData() throws IOException {
        String filePath = "/src/test/resources/TestData/TestData.xlsx";
        String sheetName = "Credential";

        File file = new File(System.getProperty("user.dir") + filePath); //Locating the Excel file
        // Check if file exists, throw meaningful error if not
        if (!file.exists()) {
            throw new FileNotFoundException("Test data file not found at: " + file.getAbsolutePath());
        }

        FileInputStream fileInputStream = new FileInputStream(file); //Creating file input stream to read the excel file
        Workbook workbook = WorkbookFactory.create(fileInputStream); //Creating workbook from the input stream
        Sheet sheet = workbook.getSheet(sheetName); //Getting Sheet by name
        // Check if sheet exists
        if (sheet == null) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in workbook");
        }

        int totalRows = sheet.getLastRowNum(); // Get the index of the last row (0-based)
        int totalCols = sheet.getRow(0).getLastCellNum(); // Get the number of columns from the header row

        DataFormatter formatter = new DataFormatter(); // Create a DataFormatter to convert cell values to String
        String[][] testData = new String[totalRows][totalCols]; // Initialize a 2D array to hold the test data

        for (int i = 1; i <= totalRows; i++) { // Start from 1 to skip header row
            Row row = sheet.getRow(i); // Get the current row
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = formatter.formatCellValue(row.getCell(j)); // Read cell value, format to String, and store in array
            }
        }
        workbook.close(); // Close the workbook to free resources
        fileInputStream.close(); // Close the file input stream
        return testData; // Return the populated test data array

    }

    @DataProvider(name = "InventoryData")
    public Object[][] getInventoryData() throws IOException {
        String filePath = "/src/test/resources/TestData/TestData.xlsx";
        String sheetName = "InventoryData";

        File file = new File(System.getProperty("user.dir") + filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("Test data file not found at: " + file.getAbsolutePath());
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        //check if sheet exists
        if (sheet == null) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in workbook");
        }

        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getLastCellNum();

        DataFormatter formatter = new DataFormatter();
        String[][] testData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }
        workbook.close();
        fileInputStream.close();
        return testData;
    }

    @DataProvider(name = "ExtraData")
    public Object[][] getExtraData() throws IOException {
        String filePath = "/src/test/resources/TestData/TestData.xlsx";
        String sheetName = "ExtraData";

        File file = new File(System.getProperty("user.dir") + filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("Test data file not found at: " + file.getAbsolutePath());
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        //check if sheet exists
        if (sheet == null) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in workbook");
        }

        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getLastCellNum();

        DataFormatter formatter = new DataFormatter();
        String[][] testData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }
        workbook.close();
        fileInputStream.close();
        return testData;
    }

}


