package org.samo_lego.lakotnik.fabric;

import net.fabricmc.api.ModInitializer;
import org.samo_lego.lakotnik.Lakotnik;

public class LakotnikFabric implements ModInitializer {

    @Override
    public void onInitialize() {
       Lakotnik.init(new FabricPlatform());
    }
}
