package net.kuko.siwaff.item.customItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class wiff extends Item {
    public wiff(Properties properties) {
        super(properties);
    }



    // Override the name to always return "Wiff"
    @Override
    public Component getName(ItemStack stack) {
        return Component.literal("Wiff");
    }
}