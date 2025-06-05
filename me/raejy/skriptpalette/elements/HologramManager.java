public void spawnHologram(Location loc, String text, int durationTicks) {
    ArmorStand holo = loc.getWorld().spawn(loc, ArmorStand.class);
    holo.setVisible(false);
    holo.setCustomName(ChatColor.translateAlternateColorCodes('&', text));
    holo.setCustomNameVisible(true);
    holo.setGravity(false);
    holo.setMarker(true);

    Bukkit.getScheduler().runTaskLater(plugin, holo::remove, durationTicks);
}
