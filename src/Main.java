import java.io.IOException;
import java.util.Scanner;
public class Main 
{
 public static void main(String[] args) throws IOException, InterruptedException
 {
  String iD, email, password, mobile, name;
  String productName, brandName, brandCategory,productCategory, priceRange, productType, serialNo, storeName, storeLocation, storeType, offer, amount, shippingAddress;
  String userType,adminActions,ownerActions,buyerActions,onlineAdminActions;
  Scanner scan = new Scanner(System.in);
  User admin = new Administrator(); 
  User owner = new StoreOwner();
  User buyer = new Buyer();
  User onlineAdmin = new OnlineStoreAdmin();
  Collabrator collabrator = new Collabrator();
  Administrator adminPro = new Administrator();
  StoreOwner ownerRegist = new StoreOwner();
  Buyer buyerRegist = new Buyer();
  OnlineStoreAdmin onlineStoreAdmin = new OnlineStoreAdmin();
  Store s = new Store();
  Product p;
  System.out.println("Enter A to log in as an Administrator");
  System.out.println("Enter S to log in as a Store Owner");
  System.out.println("Enter B to log in as a a Buyer");
  System.out.println("Enter C to log in as a a Collabrator");
  System.out.println("Enter SR to Regist as a Store Owner");
  System.out.println("Enter BR to Regist as a Buyer");
  System.out.println("Enter OA to Regist as an OnlineStoreAdmin");
  System.out.println("Enter 0 to End the Program :)");
  userType = scan.next();
  while (true)
  {
  switch (userType)	 
  {
  case("A"): 
  {
   System.out.println("Enter Your ID and Password");
   iD = scan.next(); password = scan.next();
   admin.Login(iD , password);
   System.out.println("Enter 1 to add new Product to the System");
   System.out.println("Enter 4 to add new Brand to the System");
   System.out.println("Enter 9 to see the statistics of the system");
   adminActions = scan.next();
   if (adminActions.equals("1"))
   { 
	System.out.println("Enter the Product Name,Category,Type,Price, Serial Number, (Offer or No Offer) and Amount Respectively");
	productName = scan.next(); productCategory = scan.next(); priceRange = scan.next(); productType = scan.next(); serialNo = scan.next(); offer = scan.next(); amount = scan.next();
	p = new Product();
	p.setProductName(productName); 
    p.setProductCategory(productCategory);
    p.setProductType(productType);
    p.setPriceRange(priceRange);
    p.setSerialNumber(serialNo);
    p.setOffer(offer);
    p.setAmount(amount);
    adminPro.AddProductToSystem(p);
   }
   else if (adminActions.equals("4"))
   {
	System.out.println("Enter the Brand Name and Category Respectively");   
	brandName = scan.next();
	brandCategory = scan.next();
	adminPro.AddBrandsToSystem(brandName, brandCategory);
   }
   else if (adminActions.equals("9"))
   {
	adminPro.adminStatisics();
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
   System.out.println("Enter 9 to Add New Collabrator");
   System.out.println("Enter 10 to Buy Product");
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
   else if (ownerActions.equals("9"))
   {
	System.out.println("Enter Your Name, Email, Mobile and Password respectively");
	name = scan.next(); email = scan.next(); mobile = scan.next(); password = scan.next();   
	ownerRegist.AddCollabrator(name, email, mobile, password); 
	System.out.println("Your Collabrator Added Successfully");
   }
   else if (ownerActions.equals("10"))
   {
	System.out.println("Enter The Product Name, Amount and Shiiping Address respectively");   
	productName = scan.next(); 
	amount = scan.next();
	shippingAddress = scan.next();
	ownerRegist.buyProductsBuyer(productName, amount, shippingAddress, email);
   }
   break;
  }
  //else if (userType.equals("B"))
  case("B"):
  {
   System.out.println("Enter Your Email and Password");
   email = scan.next(); password = scan.next();
   buyer.Login(email , password); 
   System.out.println("Enter 0 to Display the Whole Products or 1 to Buy Product");
   buyerActions = scan.next();
   if(buyerActions.equals("0")) 
   {
   buyerRegist.viewProduct();
   }
   else if (buyerActions.equals("1"))
   {
	System.out.println("Enter The Product Name, Amount and Shiiping Address respectively");   
	productName = scan.next(); 
	amount = scan.next();
	shippingAddress = scan.next();
	buyerRegist.buyProductsBuyer(productName, amount, shippingAddress, email);
   }
   break;
  }
  case("C"):
  {
   System.out.println("Enter Your Email and Password");
   email = scan.next(); password = scan.next();
   collabrator.Login(email , password);  
   System.out.println("Enter 1 to add new Product to the system");
   System.out.println("Enter 2 to add new Store to the system");
   System.out.println("Enter 3 to Display the Report of the Store Product");
   ownerActions = scan.next();
   if (ownerActions.equals("1"))
   {
	System.out.println("Enter the Serial Number, Brand Name and Brand Category of the product you want to add");  
	serialNo = scan.next(); 
	brandName = scan.next();
    brandCategory = scan.next();
    collabrator.AddProductToStore(serialNo , brandName, brandCategory);
   }
   else if (ownerActions.equals("2"))
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
     collabrator.AddStore(storeName, storeLocation, storeType);
	}
    else if(ownerActions.equals("2"))
    {
     System.out.println("Enter Store Name with .txt, Location, Type Respectively"); 	
     storeName = scan.next();
     storeLocation = scan.next();
     storeType = scan.next();
     collabrator.AddStore(storeName, storeLocation, storeType);
    }
   }
   else if (ownerActions.equals("3"))
   {
	collabrator.Report();  
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
  System.out.println("Enter C to log in as a a Collabrator");
  System.out.println("Enter SR to Regist as a Store Owner");
  System.out.println("Enter BR to Regist as a a Buyer");
  System.out.println("Enter OA to Regist as an OnlineStoreAdmin");
  System.out.println("Enter 0 to End the Program :)");
  userType = scan.next();
 }
 }
}