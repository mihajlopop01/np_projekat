/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import domen.Termin;
import java.io.File;

import java.util.List;

/**
 *
 * @author Mihajlo Popovic
 */
public class JsonUtil {

    public static synchronized void persistTerminListToJson(List<Termin> termini, String filePath) throws IOException {
        File file = new File(filePath);

        // Delete the file if it exists
        if (file.exists()) {
            if (!file.delete()) {
                System.err.println("Failed to delete existing file: " + filePath);
                return;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(termini, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } }
