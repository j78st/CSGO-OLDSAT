package Memoire;

import Score.Ranking;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class Memoire {

    /**
     * Cette classe a pour vocation a contenir deux méthodes génériques
     * sauvegarder et recuperer utilisables sur l'ensemble des données
     */

    public void write_data(Data data, File fileToWrite) throws IOException {

        //Création d'un objet GSON de serialisation
        Gson jsonObject = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        // ouverture du fichier où l'on souhaite écrire
        Writer writer = new FileWriter(fileToWrite);


        //Serialisation dans l'objet writer de classe FileWriter
        jsonObject.toJson(data, writer);


        // fermeture du writer
        writer.close();
    }

    public Data read_data (File fileToRead) {
        // On initialise un objet Gson qui fera appel a la classe ParcDeserialize pour les objets Vehicules
        Gson jsonReader = new GsonBuilder().registerTypeAdapter(Data.class, new OAdeserialize()).create();
        Data data = null;
        try (Reader readerW = new FileReader(fileToRead)) {

            //Si un fichier data.json existe, on extrait les donnees et renvoit un objet ParcDeLocation
            data =  jsonReader.fromJson(readerW, Data.class);
            return data;

        } catch (IOException e) {

            System.out.println("Aucun fichier data.json a lire.");
            System.out.println("Echec de lecture.");

        }

    return data;

    }

}
