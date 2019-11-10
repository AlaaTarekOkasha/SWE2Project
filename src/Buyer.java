import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Buyer extends User implements Validate , Registration
{
 private String name;
 private String mobile;	
 public Buyer(){}

 public void setName(String name) 
 {this.name = name;}
 
 public void setMobile(String mobile) 
 {this.mobile = mobile;}
 
 public void setEmail(String email) 
 {this.iD = email;}
		
 public void setPassword(String password) 
 {this.password = password;}
		 
 public String getEmail()
 {return this.iD;}
		 
 public String getPassword()
 {return this.password;}
		
 public String getMobile()
 {return this.mobile;}
 
 public String getName()
 {return this.name;}
 
 @Override
 public boolean validate(String email , String password) throws IOException
 {
  boolean check = false; 
  FileReader reader = new FileReader("BuyerData.txt"); 	 
  BufferedReader file = null; 
  ArrayList<String> buyerList = new ArrayList<>();
  file = new BufferedReader(reader);
  String line1 = file.readLine();
  while(line1!=null)
  {
   buyerList.add(line1);
   line1 = file.readLine(); 
  }
  file.close();
  for(int i=0; i<buyerList.size(); i=i+2)
  {
   if (buyerList.get(i).equals(email) && buyerList.get(i+1).equals(password))	
	  check = true;    
  }
  return check;
 }
		 
 @Override
 public void Login(String email , String password) throws IOException
 {
  this.setEmail(email); this.setPassword(password);
  boolean check = validate (this.getEmail() ,this.getPassword());
  if (check == true)
   {System.out.println("You are Logged in Successfully");}
  else
   {System.out.println("Your data is not valid :(");System.exit(1);}
 }
 
 @Override
 public void Register(String name , String email , String mobile , String password) throws IOException
 {	 
  this.setEmail(email); this.setPassword(password); this.setName(name); this.setMobile(mobile);
  FileReader reader = new FileReader("StoreOwnerData.txt"); 	 
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
   { 
	System.out.println("The data that you entered is used before");
   }
  }
	FileWriter fw=new FileWriter("BuyerData.txt",true);
	FileWriter f2w=new FileWriter("BuyerRegister.txt",true);
	BufferedWriter fWrite = new BufferedWriter(fw);
	BufferedWriter f2Write = new BufferedWriter(f2w);
	fWrite.newLine();
	fWrite.write(this.getEmail());
	fWrite.newLine();
	fWrite.write(this.getPassword());
	f2Write.newLine();
	f2Write.write(this.getName());
	f2Write.newLine();
	f2Write.write(this.getMobile());
	fWrite.close();
	f2Write.close();
	System.out.println("You are Registered Successfully");
 }
 
 public void viewProduct() throws IOException
 {
  FileReader reader = new FileReader("StoreData.txt");
  BufferedReader file = null; 
  ArrayList<String> storeList = new ArrayList<>();
  file = new BufferedReader(reader);
  String line1 = file.readLine();
  while(line1!=null)
  {
   storeList.add(line1);
   line1 = file.readLine(); 
  }
  file.close();
  System.out.println("The Products Menue");
  for(int i=0; i<storeList.size(); i++)
  {
   System.out.println(storeList.get(i));
  }
 }
}
