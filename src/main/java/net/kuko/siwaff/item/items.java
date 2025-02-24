package net.kuko.siwaff.item;


import net.kuko.siwaff.item.Food.Fried_Egg;
import net.kuko.siwaff.item.weapons.lightsaber;
import net.kuko.siwaff.main;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class items {
    public static final DeferredRegister<Item>  ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, main.MOD_ID);


    // Hamburger I add
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Fried_Egg(new Item.Properties()));

    public static final RegistryObject<Item> LIGHT_RED = ITEMS.register("light_red",
            () -> new lightsaber(30,1.0f,new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
