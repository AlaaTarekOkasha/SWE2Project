import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public String read(String fileName) throws IOException {
		FileReader read = new FileReader(fileName);
		BufferedReader file = null; 
	    file = new BufferedReader(read);
	    String line = file.readLine();
	    file.close();
	    return line;
	}

}
