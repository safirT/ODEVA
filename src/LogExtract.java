import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LogExtract {
	
	static ArrayList<String> users, themes;
	static String[][] mut;
	static String filename = "log-reco.txt";
	
	public static boolean keyIsPresent(String key){
		for (int i=0; i < mut.length; i++){
			if (mut[i][0].contains(key) || mut[0][i].contains(key)) 
				return true;
		}
		return false;
	}
	
	public static void remplirTables() throws IOException{
		users = new ArrayList<String>();
		themes = new ArrayList<String>();
		
		//Lecture fichier txt
		FileReader input = new FileReader(filename);
		BufferedReader bufRead = new BufferedReader(input);
		String myLine;

		//Remplissage des tables
		while ((myLine = bufRead.readLine()) != null){ 
			if (!myLine.isEmpty()) {
				String[] ligne = myLine.split(";");
				users.add(ligne[1]);
				themes.add(ligne[2]);
			}
		}
		bufRead.close();
	}

	public static void main(String args[]){
		try {
			remplirTables();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//Construction matrice
		for (int i=0; i < users.size(); i++){
			String u = users.get(i);
			String t = themes.get(i);
			int cptu = 0, cptt = 0;
			if (mut[i][0].contains(u)) {
				if (!keyIsPresent(u)){
					mut[cptu][1] = u;
				}
				else if (!keyIsPresent(t)){
					mut[1][cptt] = t;
				}
				else {
					
				}
			}
		}
	}
}
