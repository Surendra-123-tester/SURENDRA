package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getdatafromexcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:/Users/MY PC/Documents/Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		DataFormatter df=new DataFormatter();
		String celldata=df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		
		return celldata;
		//public String getdatafromexcel(string sheetname, int rownum, int cellnum)
		//FileInputStream fis =new FileInputStream(" ");
		//Workbook book =WorkbookFactory.create(fis);
		//Sheet sh=book.getSheet(sheetname);
		//DataFormatter df=new DataFormatter();
		//String celldata=df.formatCellValue(sh.getRow(rownum).getCell(cellnum);
		//return  celldata;
		
	}
}
