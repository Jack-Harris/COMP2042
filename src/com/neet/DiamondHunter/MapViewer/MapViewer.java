package com.neet.DiamondHunter.MapViewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MapViewer extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Create basic window.
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            // Read map - convert to 2D ArrayList
            List<List<Integer>> map = readMap("Resources/Maps/testmap.map");


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


    /***
     * Convert file containing map into 2D integer ArrayList.
     * @param Directory on disk of map (String)
     * @return 2D integer ArrayList containing map.
     */
    public List<List<Integer>> readMap(String directory) {
        List<List<Integer>> mapArray = new ArrayList<List<Integer>>();

        try {
            // Read file from disk.
            List<String> fileLines = Files.readAllLines(Paths.get(directory));
            File mapFile = new File(directory);

            // For each line, convert to its own ArrayList of integers.
            fileLines.forEach(line -> {
                String[] elems = line.split("\\s+");
                Integer[] elemsInt = new Integer[elems.length];

                for(int i = 0; i < elems.length; i++) {
                    elemsInt[i] = Integer.valueOf(elems[i]);
                }

                mapArray.add(Arrays.asList(elemsInt));
            });

            mapArray.forEach(System.out::println);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mapArray;
    }




}