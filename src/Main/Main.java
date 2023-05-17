package Main;

import java.io.File;
import java.io.IOException;
import java.util.Stack;
import GeneralTypes.*;
import Tokenizer.Tokenize;

public class Main
{

    Stack<func> returnStack = new Stack<>();
    static File mainFile = new File(""); //Put pathname here

    public static void main(String[] args) throws IOException
    {
        Tokenize.start(mainFile);
    }
}