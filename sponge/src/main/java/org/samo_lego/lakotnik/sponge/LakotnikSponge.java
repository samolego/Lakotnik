package org.samo_lego.lakotnik.sponge;

import com.google.inject.Inject;
import org.samo_lego.lakotnik.Lakotnik;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.ConstructPluginEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

import static org.samo_lego.lakotnik.Lakotnik.MOD_ID;

@Plugin(MOD_ID)
public class LakotnikSponge {

    @Inject
    private final PluginContainer container;

    @Inject
    public LakotnikSponge(final PluginContainer container) {
        this.container = container;
    }

    @Listener
    public void onConstructPlugin(final ConstructPluginEvent event) {
        // Perform any one-time setup
        Lakotnik.init(new SpongePlatform(this.container));
    }
}
