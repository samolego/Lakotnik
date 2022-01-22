package org.samo_lego.lakotnik.forge;

import net.minecraftforge.fml.common.Mod;
import org.samo_lego.lakotnik.Lakotnik;

import static org.samo_lego.lakotnik.Lakotnik.MOD_ID;

@Mod(MOD_ID)
public class LakotnikForge {

    public LakotnikForge() {
        Lakotnik.init(new ForgePlatform());
    }
}
