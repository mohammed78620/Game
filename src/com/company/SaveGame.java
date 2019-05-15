package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates how high-score data can be written to a text file.
 */
public class SaveGame {
    /** return the filename into a string*/
    private String fileName;

    /**
     * allows any string int the parameter to be instantiated into a variable called filename
     * @param fileName takes a string of the file data path
     */
    public SaveGame(String fileName) {
        this.fileName = fileName;
    }

    /**
     * the methods takes in parameters that represent the level previous state and writes them into a file
     * @param level represent player current level
     * @param score represent player current score
     * @param pos represent player curent position
     * @param health represent player current health
     * @throws IOException indicates if the file has a error
     */
    public void writeLevel( String level, int score, String pos,int health ) throws IOException {
        boolean append = true;

        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(level + "!" + score + "!" + pos + "!" + health + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
