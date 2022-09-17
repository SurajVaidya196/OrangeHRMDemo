package orangehrmproject.testdata;


import java.io.IOException;
import org.testng.annotations.DataProvider;
import orangehrmproject.utilities.*;

public class DataProviderXL {
	
	
@DataProvider(name="loginData")
public	static Object [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ReadConfig.getXlPath();
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		Object logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

}
