import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Product implements ValidateProduct, ValidateBrand
{
 private String productName;
 private String productCategory;
 private String priceRange;
 private String productType;
 private String serialNo;
 private String brandtName;
 private String brandCategory;
 private String offer;
 private String amount;
 private Writer write;
 private Reader read;
 
 public Product(){}
 
 public void setProductName(String productName)
 {this.productName = productName;}
 
 public void setProductCategory(String productCategory)
 {this.productCategory = productCategory;}
 
 public void setProductType(String productType)
 {this.productType = productType;}
 
 public void setPriceRange(String priceRange)
 {this.priceRange = priceRange;}
 
 public void setSerialNumber(String serialNo)
 {this.serialNo = serialNo;}
 
 public void setBrandName(String brandName)
 {this.brandtName = brandName;}
 
 public void setBrandCategory(String brandCategory)
 {this.brandCategory = brandCategory;}
 
 public void setOffer(String offer)
 {this.offer = offer;}
 
 public void setAmount(String amount)
 {this.amount = amount;}
 
 public String getAmount()
 {return this.amount;}
 
 public String getOffer()
 {return this.offer;}
 
 public String getProductName()
 {return this.productName;}
 
 public String getProductCategory()
 {return this.productCategory;}
 
 public String getProductType()
 {return this.productType;}
 
 public String getPriceRange()
 {return this.priceRange;}
 
 public String getSerialNumber()
 {return this.serialNo;}
 
 public String getBrandName()
 {return this.brandtName;}
 
 public String getBrandCategory()
 {return this.brandCategory;}
 
 @Override
 public boolean validateProduct (String serialNum) throws IOException
 {
  boolean check = false; 
  FileReader reader = new FileReader("ProductData.txt"); 	 
  BufferedReader file = null; 
  ArrayList<String> productList = new ArrayList<>();
  file = new BufferedReader(reader);
  String line1 = file.readLine();
  while(line1!=null)
  {
   productList.add(line1);
   line1 = file.readLine(); 
  }
  file.close();	 
  for(int i=5; i<productList.size(); i=i+5)
  {
   if (productList.get(i).equals(serialNum))	
      check = true;    
  }
  return check;
 }
 
 @Override
 public boolean validateBrand (String brandName , String brandCategory) throws IOException
 {
  boolean check = false; 
  FileReader reader = new FileReader("BrandData.txt"); 	 
  BufferedReader file = null; 
  ArrayList<String> brandList = new ArrayList<>();
  file = new BufferedReader(reader);
  String line1 = file.readLine();
  while(line1!=null)
  {
   brandList.add(line1);
   line1 = file.readLine(); 
  }
  file.close();	 
  for(int i=0; i<brandList.size(); i=i+2)
  {
   if (brandList.get(i).equals(brandName) && brandList.get(i+1).equals(brandCategory))	
      check = true;    
  }
  return check;
 }
 
 public void addProduct (Product p) throws IOException
 {
  boolean check = validateProduct (serialNo);
  if (check == false)
  {  write = new Writer();
   write.write(p.getProductCategory(), "ProductData.txt");	  
   write.write(p.getProductCategory(), "ProductData.txt");	  
   write.write(p.getProductType(), "ProductData.txt");	  
   write.write(p.getPriceRange(), "ProductData.txt");	  
   write.write(p.getSerialNumber(), "ProductData.txt");
   write.write(p.getOffer(), "Offers.txt");	  	 
   write.write(p.getAmount(), "amount.txt");	  
   System.out.println("The Product is added Successfully");
  }
 else
  {System.out.println("The Product is already exist in the system :(");}
 }
 
 public void addBrands(String brandName, String brandCategory) throws IOException
 {
  this.setBrandName(brandName); this.setBrandCategory(brandCategory);
  boolean check = validateBrand (this.getBrandName(),this.getBrandCategory());
  if (check == false)
  {  
   FileWriter fw=new FileWriter("BrandData.txt",true);
   BufferedWriter fWrite = new BufferedWriter(fw);
   fWrite.newLine();
   fWrite.write(this.getBrandName());
   fWrite.newLine();
   fWrite.write(this.getBrandCategory());
   fWrite.close();	  
   System.out.println("The Brand is added Successfully");
  }
  else
  {System.out.println("The Brand is already exist in the system :(");}
 }
}
