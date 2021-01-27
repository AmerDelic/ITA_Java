package exercises.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* Exercise 2:
 * 
 *  Create an application which take two files: 'fileOne' and 'fileTwo'
 *  and merges their data into 'fileThree'
 *  */

public class FileCombiner {
	private String first;
	private String second;
	private String newFile;
	
	public FileCombiner(String first, String second, String newFile) {
		this.first = first;
		this.second = second;
		this.newFile = newFile;
	}
	
	public File merge() {
		File result = new File(newFile);
		try {
			result.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try(BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(first)));
				BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(second)));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)))) {
			String line = null;
			while((line = br1.readLine()) != null) {
				bw.write(line + "\n");
			}
			while((line = br2.readLine()) != null) {
				bw.write(line + "\n");
			}
			return result;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
