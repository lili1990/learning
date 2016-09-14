package jobs.job;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lili19289 on 2016/9/14.
 */
public class Time {
    private static final Pattern p = Pattern
            .compile("(([0-9]+?)((d|h|mi|min|mn|s)))+?");
    private static final Integer MINUTE = Integer.valueOf(60);
    private static final Integer HOUR;
    private static final Integer DAY;
    static {
        HOUR = Integer.valueOf(60 * MINUTE.intValue());
        DAY = Integer.valueOf(24 * HOUR.intValue());
    }

    public static int parseDuration(String duration) {
        if (duration == null) {
            return 30 * DAY.intValue();
        } else {
            Matcher matcher = p.matcher(duration);
            int seconds = 0;
            if (!matcher.matches()) {
                throw new IllegalArgumentException(
                        "Invalid duration pattern : " + duration);
            } else {
                matcher.reset();

                while (true) {
                    while (matcher.find()) {
                        if (matcher.group(3).equals("d")) {
                            seconds += Integer.parseInt(matcher.group(2))
                                    * DAY.intValue();
                        } else if (matcher.group(3).equals("h")) {
                            seconds += Integer.parseInt(matcher.group(2))
                                    * HOUR.intValue();
                        } else if (!matcher.group(3).equals("mi")
                                && !matcher.group(3).equals("min")
                                && !matcher.group(3).equals("mn")) {
                            seconds += Integer.parseInt(matcher.group(2));
                        } else {
                            seconds += Integer.parseInt(matcher.group(2))
                                    * MINUTE.intValue();
                        }
                    }

                    return seconds;
                }
            }
        }
    }

}
