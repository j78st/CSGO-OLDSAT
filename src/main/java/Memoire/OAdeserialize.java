package Memoire;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class OAdeserialize implements JsonDeserializer<Data> {

    //Classe permettant la differenciation des types de vehicules
    //lors de la deserialisation

    @Override
    public Data deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.getAsJsonObject().has("nom")) {
            return context.deserialize(json, ObjetA.class);
        } else {
            return context.deserialize(json, ObjetB.class);
        }
    }
}