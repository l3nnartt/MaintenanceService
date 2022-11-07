package com.github.l3nnartt;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class MaintenanceService extends Plugin {
  @Override
  public void onEnable() {
    // You should not put an enable message in your plugin.
    // BungeeCord already does so
    getLogger().info("Yay! It loads!");
    ProxyServer.getInstance().getPluginManager().registerListener(this, new MaintenanceListener());
  }
}