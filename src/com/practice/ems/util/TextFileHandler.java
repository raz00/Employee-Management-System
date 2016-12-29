/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.ems.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raju
 */
public class TextFileHandler {
    String filepath;
    public TextFileHandler(String filepath) {
        this.filepath = filepath;
    }
    public void setFilePath (String filepath){
        this.filepath = filepath;
    }

    public List<String> read() throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(filepath)));
        String line = "";
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
    public void write( String content ) throws IOException{
        FileWriter writer = new FileWriter(new File (filepath));
        writer.write(content);
        writer.close();
    }
}
