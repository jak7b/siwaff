package net.kuko.siwaff.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class lightsaber extends Item {
    public lightsaber(int attackDamage, float attackSpeed, Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = target.level();

        // Apply fire effect for 5 seconds
        target.setSecondsOnFire(5);

        // Apply bleeding effect (simulated with particles) on the client side
        if (!world.isClientSide) {
            Vec3 pos = target.position();
            ((ServerLevel) world).sendParticles(
                    ParticleTypes.DAMAGE_INDICATOR,
                    pos.x, pos.y + 1, pos.z,
                    10, 0.5, 0.5, 0.5, 0.1
            );
        }

        // Play sound effect on the client side
        world.playSound(
                null,
                target.getX(), target.getY(), target.getZ(),
                SoundEvents.BLAZE_HURT,
                target.getSoundSource(),
                1.0F, 1.0F
        );

        // Return true to indicate the attack was successful
        return true;
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.literal("Red Lightsaber");
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        if (flag.isAdvanced()) {
            tooltip.add(Component.literal("Idea: SB").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            tooltip.add(Component.literal("A Shiny Boi").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }
    }
}