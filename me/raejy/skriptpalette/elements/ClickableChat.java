TextComponent message = new TextComponent("§x§F§F§0§0§F§FClick Me!");
message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
    new ComponentBuilder("This is a hover text!").create()));
message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/warp spawn"));

player.spigot().sendMessage(message);
