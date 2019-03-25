package config;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class Token {
  public static String GetToken(String config, String value) throws FileNotFoundException {
    String path = "" + config + ".json";
    BufferedReader buffer = new BufferedReader(new FileReader(path));
    Gson gson = new Gson();
    Properties json = gson.fromJson(buffer, Properties.class);
    return ((json).getProperty(value));
  }
}
