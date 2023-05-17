package Tokenizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenize
{
    public static String[] start(File file) throws IOException
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

        System.out.println(Arrays.toString(list.toArray()));
        return null;
    }
}