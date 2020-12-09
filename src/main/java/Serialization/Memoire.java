package Serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Memoire {

    /**
     * Cette classe a pour vocation a contenir deux méthodes génériques
     * sauvegarder et recuperer utilisables sur l'ensemble des données
     */

    public void write_data(Serializable data, File fileToWrite) throws IOException {
        //Création d'un objet GSON de serialisation
        Gson jsonObject = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();

        // ouverture du fichier où l'on souhaite écrire
        Writer writer = new FileWriter(fileToWrite);

        //Serialisation dans l'objet writer de classe FileWriter
        jsonObject.toJson(data, writer);

        // fermeture du writer
        writer.close();
    }

    public Serializable read_data (File fileToRead) {
        // On initialise un objet Gson qui fera appel a la classe Deserializer pour les objets
        Gson jsonReader = new GsonBuilder().registerTypeAdapter(Serializable.class, new Deserializer()).create();
        Serializable data = null;
        try (Reader readerW = new FileReader(fileToRead)) {

            data =  jsonReader.fromJson(readerW, Serializable.class);
            return data;

        } catch (IOException e) {

            System.out.println("Aucun fichier data.json a lire.");
            System.out.println("Echec de lecture.");

        }

    return data;

    }

}
