import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	Writer(){}
  public void write(String word, String fileName) throws IOException {
	  FileWriter fw = new FileWriter(fileName,true);
	  BufferedWriter fWrite = new BufferedWriter(fw);
	  fWrite.newLine();
	  fWrite.write(word);
	  fWrite.close();
  }
}
