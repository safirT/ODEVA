import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;


public class CreatorMatrice {

	FileWriter userFile, categoryFile, MUTFile;
	String path;
	FileReader nativeFile;

	public CreatorMatrice(FileReader nativeFile, String path){
		this.path=path;

		this.nativeFile=nativeFile;

		try {
			userFile= new FileWriter(path+"userFile.txt");
			categoryFile= new FileWriter(path+"categoryFile.txt");
			MUTFile= new FileWriter(path+"MUTFile.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void writerTextUserCategory(){
		
		try {
			
			BufferedReader buffNative = new BufferedReader(nativeFile);
			
			
			BufferedWriter buffUser = new BufferedWriter(userFile);
			BufferedWriter buffcategory = new BufferedWriter(categoryFile);
			
			String data;
			String[] dataSplit;
			ArrayList dataUser = new ArrayList();
			ArrayList dataCategory = new ArrayList();
			
			while((data = buffNative.readLine())!=null){
				dataSplit = data.split(";");
				if(!dataUser.contains(dataSplit[1])){
					dataUser.add(dataSplit[1]);
					buffUser.write(dataSplit[1]+"\n");
				}
				if(!dataCategory.contains(dataSplit[2])){
					dataCategory.add(dataSplit[2]);
					buffcategory.write(dataSplit[2]+"\n");
				}
			}
			
			int[dataUser.size()][dataCategory.size()] matriceMUT;
			
			
			buffUser.close();
			buffcategory.close();
			buffNative.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public static void main(String[] args) {
		FileReader nativeFile;
		try {
			nativeFile = new FileReader("/home/m2eserv/talbi/Documents/ECLE/tp1/Log-clients-themes.txt");
			CreatorMatrice CM=new CreatorMatrice(nativeFile, "/home/m2eserv/talbi/Documents/ECLE/tp1/");
			CM.writerTextUserCategory();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
