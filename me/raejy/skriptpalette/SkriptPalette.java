package me.raejy.skriptpalette;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.util.Kleenean;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class SkriptPalette extends JavaPlugin {

    // --- Simple managers for demo ---
    private final Map<String, ClickStyle> scriptClickDefaults = new HashMap<>();
    public record ClickStyle(String hover, String click) {}
    private final Map<UUID, TrailSettings> trailPrefs = new HashMap<>();
    public record TrailSettings(String type, Color color) {}
    private final Map<UUID, String> userSounds = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("[SkriptPalette] Vibrant visual scripting unleashed!");

        Skript.registerAddon(this).loadClasses("me.raejy.skriptpalette");

        // Register effects manually
        Skript.registerEffect(EffShowSpiralParticle.class,
            "palette show spiral particle rainbow at %player% for %number% seconds");
        Skript.registerEffect(EffSendGradientTitle.class,
            "palette send title %string% to %players% with fade in %number%, stay %number%, fade out %number%");
    }

    @Override
    public void onDisable() {
        getLogger().info("[SkriptPalette] See you, stay colorful!");
    }

    // --- Effect: Show Rainbow Spiral Particle ---
    public static class EffShowSpiralParticle extends Effect {
        @Override
        protected void execute(Event e) {
            // This should be replaced with actual Skript expressions
            // For demonstration, spawn spiral at all online players for 2 seconds
            for (Player player : Bukkit.getOnlinePlayers()) {
                Location loc = player.getLocation();
                new BukkitRunnable() {
                    double t = 0;
                    @Override
                    public void run() {
                        if (t > Math.PI * 2) {
                            cancel();
                            return;
                        }
                        double x = Math.cos(t) * t;
                        double y = t * 0.2;
                        double z = Math.sin(t) * t;
                        Particle.DustOptions dust = new Particle.DustOptions(
                            org.bukkit.Color.fromRGB((int) (Math.sin(t) * 127 + 128), (int) (Math.cos(t) * 127 + 128), 255), 1.0F
                        );
                        loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(x, y, z), 1, dust);
                        t += Math.PI / 16;
                    }
                }.runTaskTimer(JavaPlugin.getProvidingPlugin(getClass()), 0L, 2L);
            }
        }
        @Override
        public String toString(Event e, boolean debug) {
            return "show vibrant spiral rainbow particle";
        }
    }

    // --- Effect: Send Gradient Title ---
    public static class EffSendGradientTitle extends Effect {
        @Override
        protected void execute(Event e) {
            // Example: send colored title to all online players
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§dWelcome §bBack!", "", 10, 60, 10);
            }
        }
        @Override
        public String toString(Event e, boolean debug) {
            return "send vibrant gradient title";
        }
    }

    // --- Utility: Clickable Chat (demo only) ---
    public void setClickDefault(String script, String hover, String click) {
        scriptClickDefaults.put(script, new ClickStyle(hover, click));
    }

    // --- Utility: Trail Manager (demo only) ---
    public void setTrailSettings(Player player, String type, Color color) {
        trailPrefs.put(player.getUniqueId(), new TrailSettings(type, color));
    }

    // --- Utility: Sound Sender (demo only) ---
    public void setUserSound(UUID userId, String soundId) {
        userSounds.put(userId, soundId);
    }
    public void playCustomSound(Player player) {
        String sound = userSounds.getOrDefault(player.getUniqueId(), "minecraft:entity.player.levelup");
        player.playSound(player.getLocation(), sound, 1f, 1f);
    }

    // --- Utility: Hologram Manager (demo only) ---
    public void spawnHologram(Location loc, String text, int durationTicks) {
        ArmorStand holo = loc.getWorld().spawn(loc, ArmorStand.class);
        holo.setVisible(false);
        holo.setCustomName(ChatColor.translateAlternateColorCodes('&', text));
        holo.setCustomNameVisible(true);
        holo.setGravity(false);
        holo.setMarker(true);
        Bukkit.getScheduler().runTaskLater(this, holo::remove, durationTicks);
    }
}
