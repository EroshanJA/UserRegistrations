package com.countiesenergy.users.takehometest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is to validate the name and email of the user.
 * Function : validateUserEmail, 
 *              validate the email of the user,
 *              Input  - @email, user's email 
 *              Output - true or false
 * Function : validateUserName,
 *              validate user first and last name of the user,
 *              Input - @name, user's name
 *              Output - true or false
 */
public class InputValidator {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String NAME_PATTERN = "^[\\p{L} .'-]+$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern namePattern = Pattern.compile(NAME_PATTERN);

    public static boolean validateUserEmail(String email){

        try {
            if (null == email || email.length() < 1) {
                return false;
            } else {
                Matcher matcher = emailPattern.matcher(email);
                return matcher.matches();
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean validateUserName(String name) {
        
        try {
            if (null == name || name.length() < 1) {
                return false;
            } else {
                Matcher matcher = namePattern.matcher(name);
                return matcher.matches();
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
