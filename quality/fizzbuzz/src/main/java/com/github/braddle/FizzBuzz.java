package com.github.braddle;

public class FizzBuzz {
    private Rule[] rules;

    public FizzBuzz(Rule[] rules) {
        this.rules = rules;
    }

    public String run(int value) {
        for (int i = 0; i < rules.length; i++) {
            Rule r = rules[i];

            if (r.applicable(value)) {
                return r.apply(value);
            }
        }

        return "";
    }
}
