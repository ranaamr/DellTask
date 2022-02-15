package com.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Base.TestBase;

public class TestData extends TestBase {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	private static DataFormatter formatter = new DataFormatter();

	public static void OpenExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			// ExcelWSheet = ExcelWBook.getSheetAt(0);

		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}
	}

	// This method is to read the test data from exact Excel ROW to end of file.
	public static ArrayList<String> getALLExcelData(int RowNum) throws Exception {

	

		// To get the number of rows present in sheet
		int totalNoOfRows = ExcelWSheet.getLastRowNum();

		ArrayList<String> row = new ArrayList<String>();

		for (int i = RowNum; i <= totalNoOfRows; i++) {
			// get the total cell count in row[i]
			int cellcount = ExcelWSheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++) {
				// get cell value at the given position [i][j]
				String value = formatter.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
				row.add(value);
			}
		}
		return row;
	}

	// This method is to read the test data from exact Excel ROW.
	public static ArrayList<String> getRowData(int RowNum) throws Exception {

		
		Row = ExcelWSheet.getRow(RowNum);
		ArrayList<String> row = new ArrayList<String>();

		for (Cell cell : Row) {

			row.add(formatter.formatCellValue(cell));
		}
		return row;
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				
				return true;

			}
		}
		return false;
	}

	// DataProvider TCS
	public static Object[][] fetchData(String sTestCaseName) throws Exception

	{
		int iTestCaseRow;
		TestData.OpenExcelFile(System.getProperty("user.dir") + "\\src\\com\\TestData\\TestData.xlsx", "Sheet1");
		iTestCaseRow = TestData.getRowContains(sTestCaseName, 0);

		Object[][] testObjArray = TestData.getTableArray(
				System.getProperty("user.dir") + "\\src\\com\\TestData\\TestData.xlsx", "Sheet1", iTestCaseRow);

		return (testObjArray);

	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception

	{

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startCol = 1;

			int ci = 0, cj = 0;

			int totalRows = 1;

			int totalCols = ExcelWSheet.getRow(iTestCaseRow).getLastCellNum() - 1;

			tabArray = new String[totalRows][totalCols];

			for (int j = startCol; j <= totalCols; j++, cj++)

			{

				tabArray[ci][cj] = getCellData(iTestCaseRow, j);

			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	/*
	 * public static String getCellData(int RowNum, int ColNum) throws Exception{
	 * 
	 * try{
	 * 
	 * Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	 * 
	 * String CellData = Cell.getStringCellValue();
	 * 
	 * return CellData;
	 * 
	 * }catch (Exception e){
	 * 
	 * return"";
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public static String getTestCaseName(String sTestCase) throws Exception {
	 * 
	 * String value = sTestCase;
	 * 
	 * try {
	 * 
	 * int posi = value.indexOf("@");
	 * 
	 * value = value.substring(0, posi);
	 * 
	 * posi = value.lastIndexOf(".");
	 * 
	 * value = value.substring(posi + 1);
	 * 
	 * return value;
	 * 
	 * } catch (Exception e) {
	 * 
	 * throw (e);
	 * 
	 * }
	 * 
	 * }
	 */

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {

		int i;

		try {

			int rowCount = TestData.getRowUsed();

			for (i = 0; i < rowCount; i++) {

				if (TestData.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {

					break;

				}

			}

			return i;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static int getRowUsed() throws Exception {

		try {

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}
}
