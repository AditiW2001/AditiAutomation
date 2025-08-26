package Test1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File -->Workbook -->Sheets -->Rows --> Cells

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		//open excel in reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Data.xlsx");
		
		//Get the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//Get the sheet from workbook
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		 
		 int rows =sheet.getLastRowNum();
		 
		 int totalcells = sheet.getRow(1).getLastCellNum();
		 
		 System.out.println("number of rows:"+rows);//5 --> rows are counted from 0.
		 System.out.println("number of cells:"+totalcells);//4  -->cells are counted from 1.

		 
		 /*for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			    XSSFRow currentRow = sheet.getRow(i);
			    if (currentRow != null) {
			        for (int j = 0; j < currentRow.getLastCellNum(); j++) {
			            System.out.print(currentRow.getCell(j) + "\t");
			        }
			        System.out.println();
			    }
			}*/

		 for(int r=0;r<=rows;r++) 
		 {
			 XSSFRow currentRow =sheet.getRow(r);
			 
			 for(int c=0;c<totalcells;c++)
			 {
				 XSSFCell cell= currentRow.getCell(c);
				 System.out.print(cell.toString()+"\t");
			 }
			 System.out.println();

		 }
		 
		 workbook.close();
		 file.close();
	}

}
