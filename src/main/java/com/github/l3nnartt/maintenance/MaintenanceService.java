package com.github.l3nnartt.maintenance;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class MaintenanceService extends Plugin {

  @Override
  public void onEnable() {
    ProxyServer.getInstance().getPluginManager().registerListener(this, new MaintenanceListener());
  }
}