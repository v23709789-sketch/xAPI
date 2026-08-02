package me.xapi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

    private static final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String color(String message) {
        if (message == null) return "";

        Matcher matcher = HEX_PATTERN.matcher(message);
        while (matcher.find()) {
            String hexCode = message.substring(matcher.start(), matcher.end());
            String replaceSharp = hexCode.replace('#', 'x');
            char[] ch = replaceSharp.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : ch) {
                builder.append("&").append(c);
            }
            message = message.replace(hexCode, builder.toString());
        }

        return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String stripColor(String message) {
        if (message == null) return "";
        return org.bukkit.ChatColor.stripColor(color(message));
    }
}