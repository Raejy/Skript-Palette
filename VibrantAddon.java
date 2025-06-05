package com.yourname.vibrantaddon;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class VibrantAddon extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Vibrant logging
        getLogger().info("\u001B[35m[VibrantAddon]\u001B[0m Addon is loading with vibrant colors and developer-friendly tools!");

        // Register Skript elements here
        Skript.registerAddon(this);
        // Example: Skript.registerEvent("Vibrant Event", SimpleEvent.class, PlayerJoinEvent.class, "[vibrant] player join");

        // Register events, commands, etc.
        getServer().getPluginManager().registerEvents(this, this);

        // More vibrant startup features...
    }

    @Override
    public void onDisable() {
        getLogger().info("\u001B[35m[VibrantAddon]\u001B[0m Addon is shutting down. See you soon!");
    }
}