package projetovarsea.lucassoft.com.br.projetovarsea.util;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;


/**
 * Created by Lucas on 02/01/2017.
 */

public class Utilitarios {


    public static JSONObject createJasonObject(Object object) throws IllegalAccessException {
        JSONObject jsonObject = new JSONObject();
        try {
            for(Field fields : object.getClass().getDeclaredFields()) {
                fields = object.getClass().getDeclaredField(fields.getName());
                fields.setAccessible(true);
                jsonObject.put(fields.getName(),fields.get(object));
          }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                 Log.d("NoSuchFieldException", e.getMessage());
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("NoSuchFieldException", e.getMessage());
        }
        return jsonObject;
    }
    }