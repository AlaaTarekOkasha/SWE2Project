import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.LineNumberReader;

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
  int numberOfAccounts = 0;
  FileReader read = new FileReader("BuyerACCs.txt");
  BufferedReader file1 = null; 
  file1 = new BufferedReader(read);
  String line2 = file1.readLine();
  file1.close();
  numberOfAccounts = Integer.parseInt(line2);
  numberOfAccounts++;
  line2 = Integer.toString(numberOfAccounts);
  FileWriter w =new FileWriter("BuyerACCs.txt");
  BufferedWriter Write = new BufferedWriter(w);
  Write.write(line2);
  Write.close();	 
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
 
 public void buyProducts(String productName, String amount, String shippingAddress) throws IOException 
 { 
  FileReader read1 = new FileReader("ProductData.txt");
  BufferedReader file1 = null; 
  file1 = new BufferedReader(read1);
  String line1 = file1.readLine();
  ArrayList<String> buyProducts = new ArrayList<>();
  while(line1 != null)
  {
   buyProducts.add(line1);
   line1= file1.readLine(); 
  } 
  file1.close();
  FileReader read = new FileReader("amount.txt");
  BufferedReader file = null; 
  file = new BufferedReader(read);
  String line = file.readLine();
  ArrayList<String> amountFile = new ArrayList<>();
  while(line != null)
  {
  amountFile.add(line);
  line= file.readLine(); 
  } 
  file.close();
  int j=0;
  for (int i =0; i<buyProducts.size(); i=i+5)
  {	  
    if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j)))
    {
     FileWriter fw=new FileWriter("BuyProducts.txt",true);
     BufferedWriter fWrite = new BufferedWriter(fw);
     fWrite.newLine();
     fWrite.write(productName);
     fWrite.newLine();
     fWrite.write(amount);
     fWrite.newLine();
     fWrite.write(shippingAddress);
     fWrite.close();  
     int newAmount = Integer.parseInt(amountFile.get(i)) - Integer.parseInt(amount);
     String amountt = Integer.toString(newAmount);
     amountFile.set(i, amountt);
     fw = new FileWriter("amount.txt");
     fWrite = new BufferedWriter(fw);
     for(int k=0; k<amountFile.size(); k++)
     {
      fWrite.write(amountFile.get(k));
      fWrite.newLine();
     }
     fWrite.close(); 
     System.out.println("The Receipt of your Product is:"); 
     System.out.println("The Product's Name: "+productName+" The Product's Amount: "+amount+" The Shipping Address: "+shippingAddress);
     System.exit(1);
    }
    else {System.out.println("The Product is not found in the system :(");  System.exit(1);}
    j++;
  }
 }
 
}
