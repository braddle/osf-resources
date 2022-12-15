package org.example;

public class r {

    private int abc;

    private boolean beenChosen = false;

    private String ip = "127.0.0.1";

    private static final Integer answer = new Integer(42);

    public void test() {

        String[] field = {"a", "b", "c", "s", "e"};
        String s,t = "";
        for (int i = 0; i < field.length; ++i)
            if (i % 2 == 0) {
                System.out.println("even");
            } else {

            }
            s = s + field[i];

        System.out.println(ip.toString());
    }

    public void AnotherTest(boolean a, boolean b) {
        try {
            doThing();
        } catch (Exception e) {

        }
    }

    private void doThing() {

    }


    public void other() {
        boolean loop = true;

        for (;loop;) loop = false;

        return;
    }
}
