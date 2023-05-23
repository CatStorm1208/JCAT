package Main;

import Exceptions.InvalidTokenException;
import GeneralTypes.func;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Main
{
    static Stack<func> returnStack = new Stack<>();
    static TokenFile mainFile;
    static String[] mainTokens;

    public static void main(String[] args) throws IOException, InvalidTokenException
    {
        mainFile = new TokenFile(new File("C:\\Users\\anton\\IdeaProjects\\JCAT\\src\\Test\\yes.jcat")); //Put pathname here
        mainTokens = mainFile.getTokens();

        for (int n = 0; n < mainTokens.length;)
        {
            //REMEMBER always do n++
            if (mainTokens[n].matches("func")) //Branch for func
            {
                n++;
                if (mainTokens[n].matches("[a-zA-Z_][a-zA-Z0-9_]+"))
                {
                    n++;
                    if (mainTokens[n].matches("\\{"))
                    {
                        returnStack.push(new func(mainTokens[n-1]));
                        n++;
                    }
                    else throw new InvalidTokenException(mainTokens[n]);
                }
                else throw new InvalidTokenException(mainTokens[n]);
            }
            else if (mainTokens[n].matches("return")) //Branch for return TODO add return values
            {
                n++;
                if (mainTokens[n].matches(";"))
                {
                    n++;
                    if (mainTokens[n].matches("}"))
                    {
                        returnStack.pop();
                        n++;
                    }
                    else throw new InvalidTokenException(mainTokens[n]);
                }
                else throw new InvalidTokenException(mainTokens[n]);
            }
            else if (mainTokens[n].matches("println")) //Branch for println
            {
                n++;
                if (mainTokens[n].matches("\\("))
                {
                    n++;
                    if (mainTokens[n].matches("\""))
                    {
                        n+=2;
                        if (mainTokens[n].matches("\""))
                        {
                            n++;
                            if (mainTokens[n].matches("\\)"))
                            {
                                n++;
                                if (mainTokens[n].matches(";"))
                                {
                                    System.out.println(mainTokens[n-3]);
                                    n++;
                                }
                                else throw new InvalidTokenException(mainTokens[n]);
                            }
                            else throw new InvalidTokenException(mainTokens[n]);
                        }
                        else throw new InvalidTokenException(mainTokens[n]);
                    }
                    else throw new InvalidTokenException(mainTokens[n]);
                }
                else throw new InvalidTokenException(mainTokens[n]);
            }
            else if (mainTokens[n].matches("print")) //Branch for println
            {
                n++;
                if (mainTokens[n].matches("\\("))
                {
                    n++;
                    if (mainTokens[n].matches("\""))
                    {
                        n+=2;
                        if (mainTokens[n].matches("\""))
                        {
                            n++;
                            if (mainTokens[n].matches("\\)"))
                            {
                                n++;
                                if (mainTokens[n].matches(";"))
                                {
                                    System.out.print(mainTokens[n-3]);
                                    n++;
                                }
                                else throw new InvalidTokenException(mainTokens[n]);
                            }
                            else throw new InvalidTokenException(mainTokens[n]);
                        }
                        else throw new InvalidTokenException(mainTokens[n]);
                    }
                    else throw new InvalidTokenException(mainTokens[n]);
                }
                else throw new InvalidTokenException(mainTokens[n]);
            }
            else throw new InvalidTokenException(mainTokens[n]);
        }
    }
}