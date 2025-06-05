package me.raejy.skriptpalette.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.Particle;

public class EffShowSpiralParticle extends Effect {
    static {
        // Syntax: palette show spiral particle rainbow at %player% for %number% seconds
        Skript.registerEffect(EffShowSpiralParticle.class,
            "palette show spiral particle rainbow at %player% for %number% seconds");
    }

    // Expressions for player and time
    // (Implement as standard Skript Effect with init, toString, and execute methods)

    @Override
    protected void execute(Event e) {
        // Placeholder: get player and duration from expressions
        Player player = ...;
        int seconds = ...;

        Location loc = player.getLocation();
        // Example spiral (simplified): spawn rainbow particles in a spiral
        for (double t = 0; t < Math.PI * 2; t += Math.PI / 16) {
            double x = Math.cos(t) * t;
            double y = t * 0.2;
            double z = Math.sin(t) * t;
            Particle.DustOptions dust = new Particle.DustOptions(
                org.bukkit.Color.fromRGB((int)(Math.sin(t) * 127 + 128), (int)(Math.cos(t) * 127 + 128), 255),
                1.0F
            );
            loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(x, y, z), 1, dust);
        }
    }

    @Override
    public String toString(Event e, boolean debug) {
        return "show vibrant spiral rainbow particle";
    }
}