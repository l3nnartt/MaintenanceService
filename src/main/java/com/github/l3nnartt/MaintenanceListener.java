package com.github.l3nnartt;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MaintenanceListener implements Listener {
  //custom ping respond
  @EventHandler
  public void onPing(ProxyPingEvent e) {
    ServerPing response = e.getResponse();
    Players players = response.getPlayers();

    response.setVersion(new ServerPing.Protocol("MAINTENANCE", response.getVersion().getProtocol() - 1));
    PlayerInfo[] maintenancePI = { new PlayerInfo("§cWe are currently under Maintenance", "1") };
    players.setSample(maintenancePI);

    e.setResponse(response);
  }

  //kick on join with maintenance message
  @EventHandler
  public void onJoin(PreLoginEvent e) {
    e.getConnection().disconnect(new ComponentBuilder("We are currently under Maintenance").color(
        ChatColor.RED).create());
  }
}