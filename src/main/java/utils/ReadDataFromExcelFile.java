package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public String readDataFromExcel(String sheetName, int rowNum, int celNum) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configFile\\Testdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);//int type
		Cell cel = row.getCell(celNum);//int type
		String value = cel.getStringCellValue(); //int type converting to String
		return value;
	}

	

	public static Object[][] readMultipleDataFromExcel(String sheetname) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configFile\\Testdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum();//since it is reading multiple, it will go to the last row
		int lastCel = sh.getRow(0).getLastCellNum();
		// coz it has to start reading from first cell,the index of which is 0
        // from that row till last cell num
		
		Object[][] data = new Object[lastRow][lastCel]; //creating 2 array one for ROW other for CELL

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCel; j++) {// iterate it till the last cell value is retrieved
				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
				//converting int type to string
	           //(i+1) coz, usually in that row all title names are given
			}
		}
		return data;
	}

}
// read multiple data from excel