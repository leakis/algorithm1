import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	
	public static List<String> getInput(String fileName){
		List<String> list=new ArrayList<String>();
		int total=0;
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;
            
            while ((tempString = reader.readLine()) != null) {
              
                //System.out.println(tempString);
                line++;
                if(line==1) {
                	 total=Integer.parseInt(tempString)+1;
                }
                else {
                	 list.add(tempString);
                }
                
            }
            reader.close();
            if(total!=line) {
            	 System.out.println("第一行的数值和实际总数量不同");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return list;
        
		
		
	}
	
}
