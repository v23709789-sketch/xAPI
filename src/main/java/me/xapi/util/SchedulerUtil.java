package me.xapi.util;

import me.xapi.xAPI;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class SchedulerUtil {

    public static BukkitTask sync(Runnable runnable) {
        return Bukkit.getScheduler().runTask(xAPI.getInstance(), runnable);
    }

    public static BukkitTask async(Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(xAPI.getInstance(), runnable);
    }

    public static BukkitTask later(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLater(xAPI.getInstance(), runnable, delay);
    }

    public static BukkitTask laterAsync(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(xAPI.getInstance(), runnable, delay);
    }

    public static BukkitTask timer(Runnable runnable, long delay, long period) {
        return Bukkit.getScheduler().runTaskTimer(xAPI.getInstance(), runnable, delay, period);
    }

    public static BukkitTask timerAsync(Runnable runnable, long delay, long period) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(xAPI.getInstance(), runnable, delay, period);
    }
}