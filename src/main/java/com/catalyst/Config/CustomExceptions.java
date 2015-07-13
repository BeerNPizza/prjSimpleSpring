package com.catalyst.Config;

/*
    Class That Handles Unhandled Exceptions Aka Runtime Exceptions

    To Be Honest:
        There's Really No Need For This.

    Info About Exceptions:
        Checked exceptions are meant to flag a problematic situation that should be handled by the developer
        who calls your method. It should be possible to recover from such an exception. A good example of this
        is a FileNotFoundException. Those exceptions are subclasses of Exception.

        Unchecked exceptions are meant to represent a bug in your code, an unexpected situation that you might
        not be able to recover from. A NullPointerException is a classical example. Those exceptions are subclasses
        of RuntimeException.
*/
public class CustomExceptions extends RuntimeException
{
    public CustomExceptions(String Message)
    {
        super(Message);
    }
}