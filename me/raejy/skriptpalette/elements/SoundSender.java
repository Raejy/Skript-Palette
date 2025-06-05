private final Map<UUID, String> userSounds = new HashMap<>();

public void setUserSound(UUID userId, String soundId) {
    userSounds.put(userId, soundId);
}

public void playCustomSound(Player player) {
    String sound = userSounds.getOrDefault(player.getUniqueId(), "minecraft:entity.player.levelup");
    player.playSound(player.getLocation(), sound, 1f, 1f);
}
