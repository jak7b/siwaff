package net.kuko.siwaff.block.customBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class nuke extends TntBlock {
    private static final Logger log = LoggerFactory.getLogger(nuke.class);

    public nuke() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_YELLOW)
                .instabreak()
                .sound(SoundType.GRASS)
                .isRedstoneConductor((state, world, pos) -> false)

        );
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion explosion) {
        if (!world.isClientSide) { // Ensure this only runs on the server side
            // Create a custom explosion with a larger radius
            world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 80.0f, Level.ExplosionInteraction.TNT);
        }
    }

    @Override
    public MutableComponent getName() {
        return Component.literal("Nuke");
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip,
                                TooltipFlag pFlag) {

        if (pFlag.isAdvanced()) {
            pTooltip.add(Component.literal("Idea: Chmel"));
        } else {
            pTooltip.add(Component.literal("A Very Energetic Boi").withStyle(ChatFormatting.GRAY,
                    ChatFormatting.ITALIC));
        }

        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
