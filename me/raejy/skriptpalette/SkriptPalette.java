package me.raejy.skriptpalette;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SkriptPalette extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[SkriptPalette] Vibrant visual scripting unleashed!");

        // Register Skript addon
        Skript.registerAddon(this)
            .loadClasses("me.raejy.skriptpalette", "elements");

        // (Optional) Register custom events for particles and chat
        // Example: Skript.registerEvent("vibrant spiral", SimpleEvent.class, PlayerSpiralParticleEvent.class, "[palette] spiral effect");
    }

    @Override
    public void onDisable() {
        getLogger().info("[SkriptPalette] See you, stay colorful!");
    }
}