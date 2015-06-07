package de.faolblog.terraformer.init;

import cpw.mods.fml.common.registry.GameRegistry;
import de.faolblog.terraformer.item.ItemBiomeTester;
import de.faolblog.terraformer.item.ItemTF;

/**
 * Created by Vera on 07.06.15.
 */
public class ModItems {
    public static final ItemTF biomeTester =new ItemBiomeTester();

    public static void init(){
        GameRegistry.registerItem(biomeTester,"biomeTester");
    }
}
