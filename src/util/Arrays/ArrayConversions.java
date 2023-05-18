package util.Arrays;

import java.util.List;

public class ArrayConversions
{
    public static String[] listToArray(List<String> list)
    {
        String[] result = new String[list.size()];
        for (int n = 0; n < list.size(); n++)
        {
            result[n] = list.get(n);
        }
        return result;
    }
}
