package java.com.example.demo.fizzbuzz;

public class FizzBuzzService {

    public static void process(FizzBuzz fizzBuzz) {
        validate(fizzBuzz);

        if (fizzBuzz.getErrorState() == false) {
            calculate(fizzBuzz);
        }
    }

    public static void validate(FizzBuzz fizzBuzz) {
        try {
            Integer.parseInt(fizzBuzz.getInput());
            fizzBuzz.setErrorState(false);
            fizzBuzz.setValidatedInput(Integer.parseInt(fizzBuzz.getInput()));
        } catch (NumberFormatException ex) {
            fizzBuzz.setErrorState(true);
            fizzBuzz.setError("Input must be an integer");
        }
    }


    public static void calculate(FizzBuzz fizzBuzz) {
        String result = "";
        if (fizzBuzz.getValidatedInput() % 3 == 0) result += "fizz";
        if (fizzBuzz.getValidatedInput() % 5 == 0) result += "buzz";
        if (result == "") {
            fizzBuzz.setResult(String.valueOf(fizzBuzz.getValidatedInput()));
        } else {
            fizzBuzz.setResult(result);
        }
    }
}
