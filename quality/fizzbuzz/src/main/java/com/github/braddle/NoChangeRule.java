package com.github.braddle;

public class NoChangeRule implements Rule {
    @Override
    public boolean applicable(int value) {
        return value > 0;
    }

    @Override
    public String apply(int value) {
        return Integer.toString(value);
    }
}
