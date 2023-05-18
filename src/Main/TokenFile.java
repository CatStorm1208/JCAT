package Main;

import java.io.File;
import java.io.IOException;

public class TokenFile
{
    File file;
    String[] tokens;

    public TokenFile(File _file) throws IOException
    {
        file = _file;
        tokens = Tokenizer.tokenize(file);
    }

    public String[] getTokens()
    {
        return tokens;
    }
}
