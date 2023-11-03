package edu.upc.dsa.util;
import net.moznion.random.string.RandomStringGenerator;

public class RandomIdGenerator {
    public static String RandomID() {
        RandomStringGenerator generator = new RandomStringGenerator();
        return generator.generateByRegex("\\w+\\d*[0-9]{0,8}");
    }
}
