Map<UUID, BukkitTask> trails = new HashMap<>();

public void startTrail(Player player) {
    BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
        player.getWorld().spawnParticle(Particle.REDSTONE,
            player.getLocation().add(0, 1, 0),
            1,
            new Particle.DustOptions(Color.fromRGB(255, 0, 255), 1));
    }, 0L, 5L);
    trails.put(player.getUniqueId(), task);
}

public void stopTrail(Player player) {
    BukkitTask task = trails.remove(player.getUniqueId());
    if (task != null) task.cancel();
}
