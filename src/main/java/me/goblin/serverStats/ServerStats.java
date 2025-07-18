package me.goblin.serverStats;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public final class ServerStats extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("serverstats").setExecutor(this); // Регистрация команды
        getLogger().info("§aПлагин активирован! Команда: /serverstats");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("serverstats")) return false;

        // Вывод статистики
        showStats(sender);
        return true;
    }

    private void showStats(CommandSender sender) {
        Runtime runtime = Runtime.getRuntime();
        sender.sendMessage("");
        // RAM
        long usedMB = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        long totalMB = runtime.totalMemory() / (1024 * 1024);
        long maxMB = runtime.maxMemory() / (1024 * 1024);
        sender.sendMessage("§aRAM: §f" + usedMB + "MB / " + totalMB + "MB (макс. " + maxMB + "MB)");

        // CPU
        try {
            OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
            double cpuLoad = osBean.getSystemCpuLoad() * 100;
            sender.sendMessage("§aCPU: §f" + String.format("%.2f", cpuLoad) + "%");
        } catch (Exception e) {
            sender.sendMessage("§aCPU: §fN/A");
        }

        // TPS
        try {
            double tps = Bukkit.getTPS()[0];
            sender.sendMessage("§aTPS: §f" + String.format("%.2f", tps));
        } catch (Exception e) {
            sender.sendMessage("§aTPS: §fN/A");
        }
        sender.sendMessage("");
    }
}