package org.samo_lego.template.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.samo_lego.template.Template;

public class TemplateFabric implements ModInitializer {

    @Override
    public void onInitialize() {
       Template.init(new FabricPlatform());

        CommandRegistrationCallback.EVENT.register(Template::registerCommands);
    }
}
