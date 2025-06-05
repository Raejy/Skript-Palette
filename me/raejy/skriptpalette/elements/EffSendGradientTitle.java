package me.raejy.skriptpalette.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffSendGradientTitle extends Effect {
    static {
        // Syntax: palette send title %string% to %players% with fade in %number%, stay %number%, fade out %number%
        Skript.registerEffect(EffSendGradientTitle.class,
            "palette send title %string% to %players% with fade in %number%, stay %number%, fade out %number%");
    }

    // Expressions for string, players, fade in, stay, fade out

    @Override
    protected void execute(Event e) {
        // Placeholder: parse gradient colors and build the title
        // Send fancy gradient title to all players in the list
    }

    @Override
    public String toString(Event e, boolean debug) {
        return "send vibrant gradient title";
    }
}