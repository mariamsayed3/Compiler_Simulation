package csen1002.main.compiler;

public class AssignmentCustomListener extends AssignmentBaseListener {

    private int checkValue;

    public void exitStart(AssignmentParser.StartOfGrammarContext ctx) {
        System.out.println("hhhhh");
        checkValue = ctx.check;

    }

    public int getCheckValue() {
        return checkValue;
    }
}
