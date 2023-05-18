package Exceptions;

public class InvalidTokenException extends Exception
{
    public InvalidTokenException(String token)
    {
        super("Following Token is invalid: " + token);
    }
}
