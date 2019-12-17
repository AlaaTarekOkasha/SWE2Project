import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Register implements Registrations{
	
	Collabrator collabrator; 
	
	Register(){}	
	@Override
	 public void register(String name , String email , String mobile , String password, String fileName) throws IOException
	 {	 
	  collabrator = new Collabrator();	
	  int numberOfAccounts = 0;
	  FileReader read = new FileReader("CollabratorACCs.txt");
	  BufferedReader file1 = null; 
	  file1 = new BufferedReader(read);
	  String line2 = file1.readLine();
	  file1.close();
	  numberOfAccounts = Integer.parseInt(line2);
	  numberOfAccounts++;
	  line2 = Integer.toString(numberOfAccounts);
	  FileWriter w =new FileWriter("CollabratorACCs.txt");
	  BufferedWriter Write = new BufferedWriter(w);
	  Write.write(line2);
	  Write.close();
	  collabrator.setEmail(email); collabrator.setPassword(password); collabrator.setName(name); collabrator.setMobile(mobile);
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
	   { System.out.println("The data that you entered is used before");
	   }
	  }
		FileWriter fw=new FileWriter(fileName,true);
		FileWriter f2w=new FileWriter("CollabratorRegister.txt",true);
		BufferedWriter fWrite = new BufferedWriter(fw);
		BufferedWriter f2Write = new BufferedWriter(f2w);
		fWrite.newLine();
		fWrite.write(collabrator.getEmail());
		fWrite.newLine();
		fWrite.write(collabrator.getPassword());
		f2Write.newLine();
		f2Write.write(collabrator.getName());
		f2Write.newLine();
		f2Write.write(collabrator.getMobile());
		fWrite.close();
		f2Write.close();
	 }

}
