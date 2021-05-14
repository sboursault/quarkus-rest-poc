package com.sb.restserver;

import java.util.Random;

public enum Choice {

    ROCK, PAPER, SCISSORS;

    public static Choice random() {
        return Choice.values()[new Random().nextInt(Choice.values().length)];
    }
}