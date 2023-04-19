package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcell {

	public static void main(String[] args) throws IOException {
		//Step1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertyFilesVtiger.xlsx");
		
		//Step2: Create a work book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Get control of Sheet
		Sheet sh = wb.getSheet("contacts");
		
		//Step4: Get control of Row
		Row rw = sh.getRow(4);
		
		//Step5: Get Control of Cell
		Cell ce = rw.getCell(2);
		
		//Step6: Read the data inside data
		String values = ce.getStringCellValue();
		System.out.println(values);
		
	}

}
