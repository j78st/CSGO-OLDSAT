package Memoire;

import com.google.gson.*; //Importation de la bibliotheque GSON
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;



//La classe Read va effectuer la deserialisation du fichier "data.json" en une instance ParcDeLocation
public class Read {
	public Gson jsonReader;

	public Read() { 
		// On initialise un objet Gson qui fera appel a la classe ParcDeserialize pour les objets Vehicules
		// jsonReader = new GsonBuilder().registerTypeAdapter(Vehicule.class, new ParcDeserialize()).create();
	}

	/*public ParcDeLocation readParcLocation(ParcDeLocation ancienParc) {
		try (Reader readerW = new FileReader("data.json")) {
			//Si un fichier data.json existe, on extrait les donnees et renvoit un objet ParcDeLocation
			return jsonReader.fromJson(readerW, ParcDeLocation.class);
		} catch (IOException e) {
			System.out.println("Aucun fichier data.json a lire.");
			System.out.println("Echec de lecture.");
		}
		return ancienParc; // Il s'agit d'une securite en cas d'echec de lecture : le parc de location en entree est celui renvoye et non null
	}*/

}