package org.ctdog.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Component:Concurrent Tester
 * Description:Basic utilities
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public class BasicUtils {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static Logger logger = Logger.getLogger(BasicUtils.class);

    private BasicUtils() {
    }

    public static String formatDate(long date, String format) {
        return formatDate(new Date(date), format);
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String defaultFormatDate(long date) {
        return formatDate(date, DEFAULT_DATE_PATTERN);
    }

    public static String defaultFormatDate(Date date) {
        return formatDate(date, DEFAULT_DATE_PATTERN);
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
