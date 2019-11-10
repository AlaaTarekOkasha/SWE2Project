import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class StoreOwner extends User implements Validate , Registration 
{
 private String name;
 private String mobile;	
 static int usersview = 0;
 static int numberOfUserView=0;
 static int numberOfUserBuy=0;
 Product product;
 Store store;
 public StoreOwner(){}
	
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
   {System.out.println("Your data is not valid :("); System.exit(1);}
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
   { System.out.println("The data that you entered is used before");
   }
  }
	FileWriter fw=new FileWriter("StoreOwnerData.txt",true);
	FileWriter f2w=new FileWriter("StoreOwnerRegister.txt",true);
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
 
 public void AddProductToStore (String serialNo, String brandName, String brandCategory) throws IOException
 {
  boolean check = false;	 
  FileReader reader = new FileReader("ProductData.txt"); 	 
  BufferedReader file = null; 
  ArrayList<String> productList = new ArrayList<>();
  ArrayList<String> currentProduct = new ArrayList<>();
  file = new BufferedReader(reader);
  String line1 = file.readLine();
  while(line1!=null)
  {
   productList.add(line1);
   line1 = file.readLine(); 
  }
  file.close();
  for(int i=0; i<productList.size(); i++)
  {
   if (productList.get(i).equals(serialNo))	
   { 
	check = true;   
	for(int k=i-4; k<=i; k++)
	{
	 currentProduct.add(productList.get(k));	
	}
   }
  }
  if (check == false)
  {System.out.println("The Product is not Found in the System"); System.exit(1);}
  product = new Product();
  boolean checker = product.validateBrand(brandName, brandCategory);
  if (checker == true) 
  {
  FileWriter fw=new FileWriter("StoreData.txt",true);	
  BufferedWriter fWrite = new BufferedWriter(fw);
  fWrite.newLine();
  for(int i=0; i<currentProduct.size(); i++)
  {	  
   fWrite.write(currentProduct.get(i));
   fWrite.newLine();
  }
  fWrite.write(brandName);
  fWrite.newLine();
  fWrite.write("_____________________________________");
  System.out.println("The Product is added Successfully to your Store");
  fWrite.close();
  }
  else System.out.println("The Brand Name and Brand Category is not found in the system so we cannot add the product");
 }
 
 public void Report () throws IOException, InterruptedException
 {
  String numberOfUserView1;
  String numberOfUserBuy1;
  int Max=0;
  int Index=0;
  Random rand = new Random();
  int upperbound=20;
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
  for (int k=0; k<2; k++)
  {
  for (int i=0; i<storeList.size(); i=i+7)
  {
   numberOfUserView = numberOfUserView + numberOfUserBuy + rand.nextInt(upperbound);
   numberOfUserBuy = numberOfUserBuy +rand.nextInt(upperbound);
   numberOfUserView1 = Integer.toString(numberOfUserView);
   numberOfUserBuy1 = Integer.toString(numberOfUserBuy);
   System.out.println("Product Name : "+storeList.get(i));
   System.out.println("Number of users explore this product: "+numberOfUserView1);
   System.out.println("Number of user buy this product: "+numberOfUserBuy1);
   if(Max<numberOfUserBuy)
     {Max = numberOfUserBuy; Index =i;}
   System.out.println("____________________________________________________________________");
  }
  System.out.println("The most ordered product: "+storeList.get(Index));
  System.out.println("Wait for next refresh");
  System.out.println ("--------------------------------------------------------------------");
  TimeUnit.MINUTES.sleep(1);
  }
 }
 
 public void AddStore(String storeName, String storeLocation, String storeType) throws IOException
 {
  store = new Store();
  store.newStore(storeName, storeLocation, storeType);
 }
}
