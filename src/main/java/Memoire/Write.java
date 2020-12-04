package Memoire;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.*; //Importation de la bibliotheque GSON

import ParcDeLocation.*;

//La classe Read va effectuer la serialisation du fichier "data.json" en une instance ParcDeLocation
public class Write {
    public Write(ParcDeLocation unParcDeLocation){
		//Création d'un objet GSON de serialisation
    	Gson jsonObject = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();	
    	
    	try(Writer writer = new FileWriter("data.json")){ //Ouverture/Creation d'un fichier data.json
    		jsonObject.toJson(unParcDeLocation, writer); //Serialisation dans l'objet writer de classe FileWriter
    		writer.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}    	
        
    }
}