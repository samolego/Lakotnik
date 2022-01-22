package org.samo_lego.template.forge;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.samo_lego.template.Template;

import static org.samo_lego.template.Template.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(MOD_ID)
public class TemplateForge {

    public TemplateForge() {
        MinecraftForge.EVENT_BUS.register(this);
        Template.init(new ForgePlatform());
    }

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        boolean dedicated = event.getEnvironment().equals(Commands.CommandSelection.DEDICATED);

        Template.registerCommands(dispatcher, dedicated);
    }
}
