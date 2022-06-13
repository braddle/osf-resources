package com.example.demo.fizzbuzz;

public class FizzBuzz {
    private final String input;

    private int validatedInput;
    private String result;
    private String generatedResult;
    private boolean errorState;
    private String error;

    public FizzBuzz(String input) {
        this.input = input;
    }

    public boolean getErrorState() {
        return errorState;
    }

    public void setErrorState(boolean state) {
        this.errorState = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getValidatedInput() {
        return validatedInput;
    }

    public void setValidatedInput(int validatedInput) {
        this.validatedInput = validatedInput;
    }

    public String getInput() {
        return input;
    }

    public String getGeneratedResult(){return generatedResult;}

    public void setGeneratedResult(String generatedResult){this.generatedResult = generatedResult;}


}
