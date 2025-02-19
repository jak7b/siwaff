package net.kuko.siwaff.item;

import net.kuko.siwaff.item.customItem.wiff;
import net.kuko.siwaff.siwaff;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class items {
    public static final DeferredRegister<Item>  ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, siwaff.MOD_ID);


    public static final RegistryObject<Item> WIFF = ITEMS.register("wiff",
            () -> new wiff(new Item.Properties()));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
