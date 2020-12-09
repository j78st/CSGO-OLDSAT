package Serialization;

import Score.Ranking;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;

public class Deserializer implements JsonDeserializer<Serializable> {

    /* Classe permettant la differenciation des types d'objets sérialisés
    lors de la deserialisation */

    @Override
    public Serializable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        //==== différenciation des cas en fonction des attributs ====//

        // Récupération d'un classement
        if (json.getAsJsonObject().has("ranking")) {
            return context.deserialize(json, Ranking.class);
        }

        // Récupération des paramètres
        else if (json.getAsJsonObject().has("age")) {
            return context.deserialize(json, ObjetB.class);
        }

        // Récupération d'un autre truc
        else {
            return context.deserialize(json, ObjetA.class);
        }
    }
}