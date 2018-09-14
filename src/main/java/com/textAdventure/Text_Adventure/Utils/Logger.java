package com.textAdventure.Text_Adventure.Utils;

public class Logger {

    private final static String INFO_INDICATOR = "[ ? INFORMATION ? ]";
    private final static String WARNING_INDICATOR = "[ *   WARNING   * ]";
    private final static String ERROR_INDICATOR = "[ !    ERROR    ! ]";


    private final static String MESSAGE_HEADER = " - - - - - - - - - -\n";
    private final static String MESSAGE_FOOTER = "\n = = = = = = = = = =\n";


    public static <T> void info(T message) {
        String output = message.toString();
        if (output.contains("\n")) {
            System.out.println(String.format("%s\n\n%s\n\n%s",
                    INFO_INDICATOR,
                    output,
                    MESSAGE_FOOTER));

        } else {
            System.out.println(String.format("%s - %s",
                    INFO_INDICATOR,
                    output));
        }

    }

}
