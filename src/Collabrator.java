import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Collabrator extends User {
 private String name;
 private String mobile;	
 static int usersview = 0;
 static int numberOfUserView=0;
 static int numberOfUserBuy=0;
 Product product;
 Store store;
 ValidateData d;
 Register r;
 StoreOwner s;
 
 public Collabrator(){}
 
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
 
 public boolean validateLogin(String email , String password) throws IOException
 {
  boolean check; 
  d = new ValidateData();
  check = d.validate(email, password, "CollabratorData.txt");
  return check;
 }
 
 public void Register (String name , String email , String mobile , String password) throws IOException {
  r = new Register();	 
  r.register(name, email, mobile, password, "CollabratorData.txt"); 
 }
 
 @Override
 public void Login(String email , String password) throws IOException
 {
  this.setEmail(email); this.setPassword(password);
  boolean check = validateLogin(this.getEmail() ,this.getPassword());
  if (check == true)
   {System.out.println("You are Logged in Successfully");}
  else
   {System.out.println("Your data is not valid :("); System.exit(1);}
 }
 
 public void AddProductToStore (String serialNo, String brandName, String brandCategory) throws IOException{
	 s = new StoreOwner();
	 s.AddProductToStore(serialNo, brandName, brandCategory);
 }
 
 public void Report () throws IOException, InterruptedException{
	s = new StoreOwner();
	s.Report();
 }

 public void AddStore(String storeName, String storeLocation, String storeType) throws IOException{
	 s = new StoreOwner();
	 s.AddStore(storeName, storeLocation, storeType);
 }
}















