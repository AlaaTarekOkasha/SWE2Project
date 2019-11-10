import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Store implements NewStore,ValidateNewStore
{
 private String storeName;
 private String storeLocation; 
 private String storeType; 
 
 public Store(){}
 
 public void setStroeName(String storeName)
 {this.storeName = storeName;}
 
 public void setStroeLocation(String storeLocation)
 {this.storeLocation = storeLocation;}
 
 public void setStroeType(String storeType)
 {this.storeType = storeType;}
 
 public String getStoreName()
 {return this.storeName;}
 
 public String getStoreLocation()
 {return this.storeLocation;}
 
 public String getStoreType()
 {return this.storeType;}
 
 @Override
 public boolean validateStore(String storeName) throws IOException
 {
  boolean check = false;	 
  FileReader reader = new FileReader("StoreNames.txt"); 	 
  BufferedReader file = null; 
  ArrayList<String> storeWaitingList = new ArrayList<>();
  file = new BufferedReader(reader); 
  String line1 = file.readLine();
  while(line1!=null)
  {
   storeWaitingList.add(line1);
   line1 = file.readLine(); 
  }
  file.close();
  for(int i=0; i<storeWaitingList.size(); i=i+3)
  {
   if (storeWaitingList.get(i).equals(this.getStoreName()))	
    check = true;  
  }
   return check;
 }
 
 @Override
 public void newStore (String storeName, String storeLocation, String storeType) throws IOException 
 {
  this.setStroeName(storeName);	 this.setStroeLocation(storeLocation); this.setStroeType(storeType);
  boolean check = validateStore(storeName);
  if (check == false)
  {
   FileWriter fw=new FileWriter("WaitingStore.txt",true);
   BufferedWriter fWrite = new BufferedWriter(fw);
   fWrite.newLine();
   fWrite.write(this.getStoreName());
   fWrite.newLine();
   fWrite.write(this.getStoreLocation());
   fWrite.newLine(); 
   fWrite.write(this.getStoreType());
   fWrite.close();
   System.out.println("Your Store added Successfully but waiting for Online Admin Approval");
  }
  else 
  {
   if (check == false)
   {System.out.println("The Store is already Exist in the System"); /*System.exit(1);*/}  
  }
 }
}
