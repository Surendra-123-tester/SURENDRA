import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {
public String getdatafromexcel(String sheetname,int rownum,int cellnum)
{
	FileInputStream fis=new FileInputStream("C:/Users/MY PC/Documents/Book1ee.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	DataFormatter df=new DataFormatter();
	String celldata=df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
	
	return celldata;
	
}
}
