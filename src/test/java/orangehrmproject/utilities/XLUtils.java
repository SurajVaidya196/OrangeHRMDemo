package orangehrmproject.utilities;

import java.io.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtils {
	public static FileInputStream inst;
	public static FileOutputStream opst;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		inst=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(inst);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		inst.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		inst=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(inst);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		inst.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		inst=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(inst);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		inst.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		inst=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(inst);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		opst=new FileOutputStream(xlfile);
		workbook.write(opst);		
		workbook.close();
		inst.close();
		opst.close();
	}
}
