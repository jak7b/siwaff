package net.kuko.siwaff.item.Food;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class Fried_Egg extends Item {
    public Fried_Egg(Properties properties) {
        super(properties);
    }


    @Override
    public Component getName(ItemStack pStack) {
        return Component.literal("Fried Egg");
    }

    @Override
    public Component getDescription() {
        return Component.literal("A Fried Egg, simply")
                .withStyle(ChatFormatting.ITALIC,ChatFormatting.GRAY);
    }

    @Override
    public @Nullable FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
        return new FoodProperties.Builder()
                .nutrition(5)
                .saturationMod(0.5f)
                .build();
    }
}
