import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ValidateData implements ValidateDataUI {
	
	ValidateData(){};
	
 @Override
 public boolean validate(String email , String password, String fileName) throws IOException
	 {
	  boolean check = false; 
	  FileReader reader = new FileReader(fileName); 	 
	  BufferedReader file = null; 
	  ArrayList<String> ownerList = new ArrayList<>();
	  file = new BufferedReader(reader);
	  String line1 = file.readLine();
	  while(line1!=null)
	  {
	   ownerList.add(line1);
	   line1 = file.readLine(); 
	  }
	  file.close();
	  for(int i=0; i<ownerList.size(); i=i+2)
	  {
	   if (ownerList.get(i).equals(email) && ownerList.get(i+1).equals(password))	
	      check = true;    
	  }
	  return check;
	 }

}
