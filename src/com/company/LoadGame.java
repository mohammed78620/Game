package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadGame {
    /** return the filename into a string*/
    private String fileName;
    /** Shows the level the player is on*/
    private int level;
    /** Show the score the player has*/
    private int score;
    /** Show the current position of the player*/
    private String pos;
    /** Show the X value of the vector*/
    private Float firstValue;
    /** Shows the Y value of the vector*/
    private Float secondValue;
    /** Shows the player health*/
    private int health;


    /**
     * allows any string int the parameter to be instantiated into a variable called filename
     * @param fileName requires a string withe the data path of file contained
     */
    public LoadGame(String fileName){
        this.fileName = fileName;
    }

    /**
     * read the file to find player pos health and score
     * @throws IOException signal if the file is incorrect
     */
    public void readLevel() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split ("!");
                level = Integer.parseInt(tokens[0]);
                score = Integer.parseInt(tokens[1]);

                //split the X and Y
                pos = (tokens[2]);
                pos = pos.replaceAll ("\\(","").replaceAll ("\\)","");
                String[] posValue = pos.split (",");
                firstValue = Float.valueOf (posValue[0]);
                secondValue = Float.valueOf (posValue[1]);

                health = Integer.parseInt (tokens[3]);

                System.out.println("level: " + level + ", Score: " + score);
                line = reader.readLine();
                System.out.print (line);

            }
            System.out.println("...done.");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
    /**
     * returns player level
     * @return level
     */
    public int getLevel(){
        return level;

    }

    /**
     * returns player score
     * @return score
     */
    public int getScore(){
        return score;
    }

    /**
     * returns player health
     * @return health
     */
    public int getHealth(){
        return health;
    }


    /**
     * returns player X coordinates
     * @return firstValue
     */
    public Float getFirstValue(){
        return firstValue;
    }

    /**
     * returns player Y coordinates
     * @return firstValue
     */

    public Float getSecondValue(){
        return secondValue;
    }





}
