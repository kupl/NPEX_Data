/**
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.config;


@net.runelite.client.plugins.PluginDescriptor(name = "Configuration", loadWhenOutdated = true, hidden = true// prevent users from disabling
)
public class ConfigPlugin extends net.runelite.client.plugins.Plugin {
    @javax.inject.Inject
    private net.runelite.client.ui.ClientToolbar clientToolbar;

    @javax.inject.Inject
    private net.runelite.client.config.ConfigManager configManager;

    @javax.inject.Inject
    private net.runelite.client.plugins.PluginManager pluginManager;

    @javax.inject.Inject
    private java.util.concurrent.ScheduledExecutorService executorService;

    @javax.inject.Inject
    private net.runelite.client.config.RuneLiteConfig runeLiteConfig;

    @javax.inject.Inject
    private net.runelite.client.config.ChatColorConfig chatColorConfig;

    private net.runelite.client.plugins.config.ConfigPanel configPanel;

    private net.runelite.client.ui.NavigationButton navButton;

    @java.lang.Override
    protected void startUp() throws java.lang.Exception {
        configPanel = new net.runelite.client.plugins.config.ConfigPanel(pluginManager, configManager, executorService, runeLiteConfig, chatColorConfig);
        final java.awt.image.BufferedImage icon = net.runelite.client.util.ImageUtil.getResourceStreamFromClass(getClass(), "config_icon.png");
        navButton = net.runelite.client.ui.NavigationButton.builder().tooltip("Configuration").icon(icon).priority(0).panel(configPanel).build();
        clientToolbar.addNavigation(navButton);
    }

    @java.lang.Override
    protected void shutDown() throws java.lang.Exception {
        clientToolbar.removeNavigation(navButton);
    }

    @com.google.common.eventbus.Subscribe
    public void onPluginChanged(net.runelite.client.events.PluginChanged event) {
        javax.swing.SwingUtilities.invokeLater(configPanel::refreshPluginList);
    }
}

