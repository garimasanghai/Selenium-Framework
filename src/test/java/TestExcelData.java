import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestExcelData {

	public String readDataFromExcel(String sheetName, int rowNum, int celNum) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configFile\\Testdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce = rw.getCell(celNum);
		String value = ce.getStringCellValue();
		return value;
	}

	public Object[][] readMultipleDataFromExcel(String sheetname) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configFile\\Testdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRow][lastCel];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCel; j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();

			}
		}
		return data;
	}

	public static void main(String[] args) throws Exception {
		TestExcelData td = new TestExcelData();
		String val1 = td.readDataFromExcel("TestData1", 0, 0);
		System.out.println(val1);

		////////
		Object[][] testData = td.readMultipleDataFromExcel("TestData1");
		for (Object[] row : testData) {
			System.out.println(Arrays.toString(row));
		}

	}

}
