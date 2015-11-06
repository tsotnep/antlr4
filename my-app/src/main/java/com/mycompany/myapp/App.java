package com.mycompany.myapp;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.List;


/**
 * simple language
 * grammar is in ANTLR4
 * Tsotne Putkaradze
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        csvLexer lexer = new csvLexer(new ANTLRFileStream("in.txt"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        csvParser parser = new csvParser(tokenStream);
        ParserRuleContext tree = parser.parse();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        csvListener listener = new csvListener() {
            public void enterParse(csvParser.ParseContext ctx) {
                System.out.println("enter Parse");
            }

            public void exitParse(csvParser.ParseContext ctx) {
                System.out.println("exit Parse");
            }

            public void enterLine(csvParser.LineContext ctx) {
                System.out.println("enter line");

                List<TerminalNode> contentText = ctx.TEXT(); //everything in the TEXT
                for (TerminalNode t : contentText)
                    System.out.println(t.getText());

                List<TerminalNode> contentNumber = ctx.NUMBER();
                for (TerminalNode t : contentNumber)
                    System.out.println(t.getText());
            }


            public void exitLine(csvParser.LineContext ctx) {
                System.out.println("exit line");
            }

            public void visitTerminal(TerminalNode node) {
                System.out.println("visit Terminal");
            }

            public void visitErrorNode(ErrorNode node) {
                System.out.println("visit errorNode");
            }

            public void enterEveryRule(ParserRuleContext ctx) {
                System.out.println("enter EveryRule");
            }

            public void exitEveryRule(ParserRuleContext ctx) {
                System.out.println("exit EveryRule");
            }
        };
        parseTreeWalker.walk(listener, tree);


        System.out.println("END of 'App.java'");
    }
}
