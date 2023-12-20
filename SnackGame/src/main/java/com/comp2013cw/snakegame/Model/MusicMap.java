package com.comp2013cw.snakegame.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to map the musics' names to their paths.
 * @author Shuli WANG
 */

public class MusicMap {
    public static Map<String, String> musicPaths = new HashMap<>();
    static String dir = "/musics/";
    static {
        musicPaths.put("Brisk (default)", dir + "frogger.mp3");
        musicPaths.put("cyber", dir + "cyber.mp3");
    }
}
