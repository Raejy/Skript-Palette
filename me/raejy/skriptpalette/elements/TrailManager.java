private final Map<UUID, TrailSettings> trailPrefs = new HashMap<>();

public record TrailSettings(String type, Color color) {}

public void setTrailSettings(Player player, String type, Color color) {
    trailPrefs.put(player.getUniqueId(), new TrailSettings(type, color));
}

