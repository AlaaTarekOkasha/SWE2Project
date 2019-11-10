import java.io.IOException;

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
 
 public void AddProductToSystem (String productName , String productCategory , String productType , String priceRange , String serialNo) throws IOException
 {
  product = new Product();
  product.addProduct(productName, productCategory, productType, priceRange, serialNo);
 }
 
 public void AddBrandsToSystem (String brandName, String brandCategory) throws IOException
 {
  product = new Product();
  product.addBrands(brandName, brandCategory);
 }
}
