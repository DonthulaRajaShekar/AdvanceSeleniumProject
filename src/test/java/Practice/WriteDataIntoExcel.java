package Practice;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertyFilesVtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Contacts");
		Row rw = sh.getRow(6);
		Cell ce = rw.createCell(6);
		ce.setCellValue("ggghh");
		FileOutputStream  fos= new FileOutputStream(".\\src\\test\\resources\\propertyFilesVtiger.xlsx");
		wb.write(fos);
		System.out.println("data added");
	}

}
