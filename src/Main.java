import java.io.IOException;
import java.util.Scanner;
public class Main 
{
 public static void main(String[] args) throws IOException, InterruptedException
 {
  String iD, email, password, mobile, name;
  String productName, brandName, brandCategory,productCategory, priceRange, productType, serialNo, storeName, storeLocation, storeType;
  String userType,adminActions,ownerActions,buyerActions,onlineAdminActions;
  Scanner scan = new Scanner(System.in);
  User admin = new Administrator(); 
  User owner = new StoreOwner();
  User buyer = new Buyer();
  User onlineAdmin = new OnlineStoreAdmin();
  Administrator adminPro = new Administrator();
  StoreOwner ownerRegist = new StoreOwner();
  Buyer buyerRegist = new Buyer();
  OnlineStoreAdmin onlineStoreAdmin = new OnlineStoreAdmin();
  Store s = new Store();
  System.out.println("Enter A to log in as an Administrator");
  System.out.println("Enter S to log in as a Store Owner");
  System.out.println("Enter B to log in as a a Buyer");
  System.out.println("Enter SR to Regist as a Store Owner");
  System.out.println("Enter BR to Regist as a Buyer");
  System.out.println("Enter OA to Regist as an OnlineStoreAdmin");
  System.out.println("Enter 0 to End the Program :)");
  userType = scan.next();
  while (true)
  {
  switch (userType)	 
  {
  //if (userType.equals("A"))
  case("A"): 
  {
   System.out.println("Enter Your ID and Password");
   iD = scan.next(); password = scan.next();
   admin.Login(iD , password);
   System.out.println("Enter 1 to add new Product to the System");
   System.out.println("Enter 4 to add new Brand to the System");
   adminActions = scan.next();
   if (adminActions.equals("1"))
   { 
	System.out.println("Enter the Product Name,Category,Type,Price and Serial Number Respectively");
	productName = scan.next(); productCategory = scan.next(); priceRange = scan.next(); productType = scan.next(); serialNo = scan.next();
    adminPro.AddProductToSystem(productName, productCategory, productType, priceRange, serialNo);
   }
   else if (adminActions.equals("4"))
   {
	System.out.println("Enter the Brand Name and Category Respectively");   
	brandName = scan.next();
	brandCategory = scan.next();
	adminPro.AddBrandsToSystem(brandName, brandCategory);
	}
   break;
  }
  //else if (userType.equals("S"))
  case("S"):
  {
   System.out.println("Enter Your Email and Password");
   email = scan.next(); password = scan.next();
   owner.Login(email , password);  
   System.out.println("Enter 2 to add new Product to the system");
   System.out.println("Enter 7 to add new Store to the system");
   System.out.println("Enter 8 to Display the Report of the Store Product");
   ownerActions = scan.next();
   if (ownerActions.equals("2"))
   {
	System.out.println("Enter the Serial Number, Brand Name and Brand Category of the product you want to add");  
    serialNo = scan.next(); 
    brandName = scan.next();
    brandCategory = scan.next();
    ownerRegist.AddProductToStore(serialNo , brandName, brandCategory);
   }
   else if (ownerActions.equals("7"))
   {
	System.out.println("Enter 1 to add Onsite Stores"); 
	System.out.println("Enter 2 to add Online Stores"); 
	ownerActions = scan.next();
    if(ownerActions.equals("1"))
    {
     System.out.println("Enter Store Name with .txt, Location, Type Respectively"); 	
     storeName = scan.next();
     storeLocation = scan.next();
     storeType = scan.next();
     //s.newStore(storeName, storeLocation, storeType);
     ownerRegist.AddStore(storeName, storeLocation, storeType);
    }
    else if(ownerActions.equals("2"))
    {
     System.out.println("Enter Store Name with .txt, Location, Type Respectively"); 	
     storeName = scan.next();
     storeLocation = scan.next();
     storeType = scan.next();
     //s.newStore(storeName, storeLocation, storeType);
     ownerRegist.AddStore(storeName, storeLocation, storeType);
    }
   }
   else if (ownerActions.equals("8"))
   {
	ownerRegist.Report();  
   }
   break;
  }
  //else if (userType.equals("B"))
  case("B"):
  {
   System.out.println("Enter Your Email and Password");
   email = scan.next(); password = scan.next();
   buyer.Login(email , password); 
   System.out.println("Enter 3 to Display the Whole Products");
   buyerActions = scan.next();
   if(buyerActions.equals("3")) 
   {
   buyerRegist.viewProduct();
   }
   break;
  }
  //else if (userType.equals("SR"))
  case("SR"):
  {
   System.out.println("Enter Your Name, Email, Mobile and Password respectively");
   name = scan.next(); email = scan.next(); mobile = scan.next(); password = scan.next();
   ownerRegist.Register(name, email, mobile, password);
   System.out.println("Now You Should Log In with your Account");
   break;
  }
  //else if (userType.equals("BR"))
  case("BR"):
  {
   System.out.println("Enter Your Name, Email, Mobile and Password respectively");
   name = scan.next(); email = scan.next(); mobile = scan.next(); password = scan.next();
   buyerRegist.Register(name, email, mobile, password);
   System.out.println("Now You Should Log In with your Account");
   break;
  }
  case("OA"):
  {
   System.out.println("Enter Your ID and Password");
   iD = scan.next(); password = scan.next();
   onlineAdmin.Login(iD , password);	
   System.out.println("Enter 6 to Make Your Approve on New Stores");
   onlineAdminActions = scan.next();
   if (onlineAdminActions.equals("6"))
   { 
	onlineStoreAdmin.storeApproval(); 
   }
   break;
  }
   default: 
   {System.out.println("The Program is Ended"); System.exit(1);}
  }
  System.out.println("Enter A to log in as an Administrator");
  System.out.println("Enter S to log in as a Store Owner");
  System.out.println("Enter B to log in as a a Buyer");
  System.out.println("Enter SR to Regist as a Store Owner");
  System.out.println("Enter BR to Regist as a a Buyer");
  System.out.println("Enter OA to Regist as an OnlineStoreAdmin");
  System.out.println("Enter 0 to End the Program :)");
  userType = scan.next();
 }
 }
}