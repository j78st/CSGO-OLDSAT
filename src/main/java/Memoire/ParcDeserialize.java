package Memoire;

import com.google.gson.*;
import java.lang.reflect.Type;
 public class ParcDeserialize{
 // public class ParcDeserialize implements JsonDeserializer<> {
    /*
        Classe permettant la differenciation des types de vehicules
        lors de la deserialisation

    @Override
	public Vehicule deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
		throws JsonParseException {
		
		if (json.getAsJsonObject().has("nbPlaces")){ //Seules les voitures possedent l'attribut nbPlaces
			return context.deserialize(json, Voiture.class);

		} else if(json.getAsJsonObject().has("nbMoteurs")){ //Seules les avions possedent l'attribut nbMoteurs
			return context.deserialize(json, Avion.class);

		} else { // Il ne reste que les motos dans le JSON qui n'ont pas ete traites
			return context.deserialize(json, Moto.class);
		}
	} */
}
