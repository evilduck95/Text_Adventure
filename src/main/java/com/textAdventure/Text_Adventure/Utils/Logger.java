package com.textAdventure.Text_Adventure.Utils;

public class Logger {

    private final static String INFO_INDICATOR = "[ ? INFORMATION ? ]";
    private final static String WARNING_INDICATOR = "[ *   WARNING   * ]";
    private final static String ERROR_INDICATOR = "[ !    ERROR    ! ]";


    private final static String MESSAGE_HEADER = " - - - - - - - - - -\n";
    private final static String MESSAGE_FOOTER = "\n = = = = = = = = = =\n";


    public static <T> void info(T message) {
        String messageStr = message.toString();
        String outputStr = messageStr.contains("\n") ?
                String.format("%s\n\n%s\n\n%s", INFO_INDICATOR, messageStr, MESSAGE_FOOTER) :
                String.format("%s - %s", INFO_INDICATOR, messageStr);
        System.out.println(outputStr);
    }
}
