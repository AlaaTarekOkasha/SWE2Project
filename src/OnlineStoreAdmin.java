import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStoreAdmin extends User implements Validate
{
  public OnlineStoreAdmin(){}
	 
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
   if (iD.equals("StoreAdmin") && password.equals("20175021"))
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
  
  public void storeApproval() throws IOException
  {
   String check;	
   Scanner scan = new Scanner(System.in);
   FileReader reader = new FileReader("WaitingStore.txt"); 	 
   BufferedReader file = null; 
   ArrayList<String> newStoreList = new ArrayList<>();
   file = new BufferedReader(reader);
   String line1 = file.readLine();
   while(line1!=null)
   {
	newStoreList.add(line1);
	line1 = file.readLine(); 
   }
   file.close();
   for(int i=0; i<newStoreList.size(); i=i+3)
   {
	System.out.println("Enter 1 to Approve the "+newStoreList.get(i)+" Store");   
	check = scan.next();   
   if (check.equals("1"))
   {
    File fileStore = new File(newStoreList.get(i));
    fileStore.createNewFile();
    System.out.println("The Store Created and its Name Called "+newStoreList.get(i));
    FileWriter fw=new FileWriter("StoreNames.txt",true);
    BufferedWriter fWrite = new BufferedWriter(fw);
    fWrite.newLine();
    fWrite.write(newStoreList.get(i));
    fWrite.newLine();
    fWrite.write(newStoreList.get(i+1));
    fWrite.newLine();
    fWrite.write(newStoreList.get(i+2));
    fWrite.close();	  
   }
   }
   FileOutputStream writer = new FileOutputStream("WaitingStore.txt");
   writer.write(("").getBytes());
   writer.close();
  }
}
