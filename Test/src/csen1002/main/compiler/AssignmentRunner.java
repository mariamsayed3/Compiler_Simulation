package csen1002.main.compiler;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AssignmentRunner {
    public static void main(String[] args) {
        String input = "222#222#222";
        System.out.println("Input : "+ input);
        csen1002.main.compiler.AssignmentLexer lexer = new csen1002.main.compiler.AssignmentLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        csen1002.main.compiler.AssignmentParser parser = new csen1002.main.compiler.AssignmentParser(tokens);

        ParseTree tree = parser.startOfGrammar();
        csen1002.main.compiler.AssignmentCustomListener listener = new csen1002.main.compiler.AssignmentCustomListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        System.out.println("Check value: " + parser.startOfGrammar().check);
    }

}

