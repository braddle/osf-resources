package com.github.braddle;

public interface Rule {

    public boolean applicable(int value);

    public String apply(int value);
}
