package Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import util.Arrays.ArrayConversions;

public class Tokenizer
{
    public static String[] tokenize(File file) throws IOException
    {
        List<String> list = new ArrayList<>();
        char[] chars = Files.readString(file.toPath()).toCharArray();
        String _buffer = "";
        for (char c : chars)
        {
            if (Character.toString(c).matches("[^\\s(){}\\[\\]\";]+")) _buffer += c;
            else if (Character.toString(c).matches("[(){}\\[\\]\";]"))
            {
                if (!_buffer.matches("")) list.add(_buffer);
                _buffer = "";
                list.add(Character.toString(c));
            }
            else
            {
                if (!_buffer.matches("")) list.add(_buffer);
                _buffer = "";
            }
        }

        return ArrayConversions.listToArray(list);
    }
}