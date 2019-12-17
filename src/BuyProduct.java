import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BuyProduct {
	public void buyProducts(String productName, String amount, String shippingAddress, String kindOfUser, String emailCheck) throws IOException {
		boolean checkForFirstTime = true;  
		FileReader read1 = new FileReader("ProductData.txt");
		BufferedReader file1 = null;
		file1 = new BufferedReader(read1);
		String line1 = file1.readLine();
		ArrayList<String> buyProducts = new ArrayList<>();
		while (line1 != null) {
			buyProducts.add(line1);
			line1 = file1.readLine();
		}
		file1.close();
		FileReader read = new FileReader("amount.txt");
		BufferedReader file = null;
		file = new BufferedReader(read);
		String line = file.readLine();
		ArrayList<String> amountFile = new ArrayList<>();
		while (line != null) {
			amountFile.add(line);
			line = file.readLine();
		}
		file.close();
		read = new FileReader("BuyProductUserData.txt");
		file = null;
		file = new BufferedReader(read);
		line = file.readLine();
		ArrayList<String> accFile = new ArrayList<>();
		while (line != null) {
			accFile.add(line);
			line = file.readLine();
		}
		if (kindOfUser.equals("Buyer")) {
			for(int i=0; i<accFile.size(); i++) {
				if(accFile.get(i).equals(emailCheck))
					checkForFirstTime = false;
			}
			if (Integer.parseInt(amount) == 2 && checkForFirstTime == true) {
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						fw = new FileWriter("BuyProductUserData.txt",true);
						fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(emailCheck);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter) + " The Price After Applying 15% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.15));
						//System.exit(1);
					} 
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			} else if (Integer.parseInt(amount) == 2){
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter)+" The Price After Applying 10% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.10));
						System.exit(1);
					}
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			}
			else if (Integer.parseInt(amount) != 2 && checkForFirstTime == true) {
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						fw = new FileWriter("BuyProductUserData.txt",true);
						fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(emailCheck);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter)+" The Price After Applying 5% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.05));
						System.exit(1);
					}
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			}
			else {
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter));
						System.exit(1);
					}
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			}
		}
		else {
			for(int i=0; i<accFile.size(); i++) {
				if(accFile.get(i).equals(emailCheck))
					checkForFirstTime = false;
			}
			if (Integer.parseInt(amount) == 2 && checkForFirstTime == true) {
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						fw = new FileWriter("BuyProductUserData.txt",true);
						fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(emailCheck);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter) + " The Price After Applying 30% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.30));
						System.exit(1);
					}
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			} else if (Integer.parseInt(amount) == 2){
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter)+" The Price After Applying 25% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.25));
						System.exit(1);
					}
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			}
			else if (Integer.parseInt(amount) != 2 && checkForFirstTime == true) {
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						fw = new FileWriter("BuyProductUserData.txt",true);
						fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(emailCheck);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter)+" The Price After Applying 20% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.20));
						System.exit(1);
					}
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			}
			else {
				int j = 0;
				int priceCounter = 3;
				for (int i = 0; i < buyProducts.size(); i = i + 5) {
					if (productName.equals(buyProducts.get(i)) && Integer.parseInt(amount) <= Integer.parseInt(amountFile.get(j))) {
						FileWriter fw = new FileWriter("BuyProducts.txt", true);
						BufferedWriter fWrite = new BufferedWriter(fw);
						fWrite.newLine();
						fWrite.write(productName);
						fWrite.newLine();
						fWrite.write(amount);
						fWrite.newLine();
						fWrite.write(shippingAddress);
						fWrite.close();
						int newAmount = Integer.parseInt(amountFile.get(j)) - Integer.parseInt(amount);
						String amountt = Integer.toString(newAmount);
						amountFile.set(j, amountt);
						fw = new FileWriter("amount.txt");
						fWrite = new BufferedWriter(fw);
						for (int k = 0; k < amountFile.size(); k++) {
							fWrite.write(amountFile.get(k));
							fWrite.newLine();
						}
						fWrite.close();
						System.out.println("The Receipt of your Product is:");
						System.out.println("The Product's Name: " + productName + " The Product's Amount: " + amount+ " The Shipping Address: " + shippingAddress + " The Original Price: "+ buyProducts.get(priceCounter)+" The Price After Applying 15% Discount: "+(Integer.parseInt(buyProducts.get(priceCounter))-Integer.parseInt(buyProducts.get(priceCounter)) * 0.15));
						System.exit(1);
					} 
					j++;
					priceCounter += 4;
				}
				System.out.println("The Product is not Found in the System :("); System.exit(1);
			}
		}
	}
}


