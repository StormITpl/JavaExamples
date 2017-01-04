package pl.stormit.stringbuilder;

public class Concatenation {

    public void stringConcatenation() {
        String value = "a";
        value += "b";
    }

    public void StringBuilderConcatenation() {
        StringBuilder sb = new StringBuilder("a");
        sb.append("b");
        String value = sb.toString();
    }
}
