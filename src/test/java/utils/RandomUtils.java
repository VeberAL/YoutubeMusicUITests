package utils;

import java.util.Random;

public class RandomUtils {

    public String getSingerName() {
        String[] singerNames = {"Ariana Grande", "Ed Sheeran", "Sting", "Justin Bieber", "Taylor Swift"};
        return singerNames[new Random().nextInt(singerNames.length)];
    }

}
