package berberyan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadFile{

	public static Reader fileToReader(String path) throws FileNotFoundException{
		return new FileReader(path);
	}

}
