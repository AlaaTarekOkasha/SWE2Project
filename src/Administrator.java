import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Administrator extends User implements Validate
{	
 Product product;	
 public Administrator(){}
 
 public void setID(String iD) 
 {this.iD = iD;}
 
 public void setPassword(String password) 
 {this.password = password;}
 
 public String getID()
 {return this.iD;}
 
 public String getPassword()
 {return this.password;}
 
 @Override
 public boolean validate(String iD , String password)
 {
  if (iD.equals("Admin") && password.equals("20175020"))
  {return true;}
  else return false;
 }
 
 @Override
 public void Login(String iD , String password)
 {
  this.setID(iD); this.setPassword(password);
  boolean check = validate(this.getID() ,this.getPassword());
  if (check == true)
  {System.out.println("You are Logged in Successfully");}
  else
  {System.out.println("Your data is not valid :("); System.exit(1);}
 }
 
 public void AddProductToSystem (String productName , String productCategory , String productType , String priceRange , String serialNo, String offer, String amount) throws IOException
 {
  product = new Product();
  product.addProduct(productName, productCategory, productType, priceRange, serialNo, offer, amount);
 }
 
 public void AddBrandsToSystem (String brandName, String brandCategory) throws IOException
 {
  product = new Product();
  product.addBrands(brandName, brandCategory);
 }
 
 public void adminStatisics() throws IOException 
 {
  int counter = 0;	 
  FileReader read = new FileReader("StoreOwnerACCs.txt");
  BufferedReader file = null; 
  file = new BufferedReader(read);
  String line = file.readLine();
  file.close();
  System.out.println("The Number of Accounts of Store Owner = "+line);
  FileReader read1 = new FileReader("BuyerACCs.txt");
  BufferedReader file1 = null; 
  file1 = new BufferedReader(read1);
  String line1 = file1.readLine();
  file1.close();
  System.out.println("The Number of Accounts of Buyer = "+line1);
  if (Integer.parseInt(line) >= Integer.parseInt(line1))
	    System.out.println("The Max Number of Accounts = "+line);
  else  System.out.println("The Max Number of Accounts = "+line1);
  System.out.println("_______________________________________________");
  read = new FileReader("ProductData.txt");
  file = null; 
  file = new BufferedReader(read);
  ArrayList<String> numbers = new ArrayList<>();
  line = file.readLine();
  while(line != null)
  {
   numbers.add(line);
   line= file.readLine(); 
  }
  file.close();
  System.out.print("Current Products: ");
  for(int i=0; i<numbers.size(); i=i+5)
  {
   counter++;
   System.out.print(numbers.get(i));
   System.out.print("|");
  }
  System.out.println("");
  System.out.println("The Total Number of the Current Products = "+counter);
  read = new FileReader("Offers.txt");
  file = null; 
  file = new BufferedReader(read);
  ArrayList<String> offers = new ArrayList<>();
  line = file.readLine();
  while(line != null)
  {
   offers.add(line);
   line= file.readLine(); 
  }
  System.out.println("_______________________________________________");
  file.close();
  int k =0;
  for (int i=0; i<offers.size(); i++)
  {
   System.out.println("Product Name: "+numbers.get(k)+ " has "+offers.get(i));
   System.out.println("_______________________________________________");
   k = k+5;
  }
 }
}

