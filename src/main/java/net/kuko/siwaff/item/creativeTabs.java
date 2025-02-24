package net.kuko.siwaff.item;

import net.kuko.siwaff.block.blocks;
import net.kuko.siwaff.main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class creativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, main.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEMS = CREATIVE_MODE_TABS.register("item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(items.FRIED_EGG.get()))
                    .title(Component.literal("Items - siwaff"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(items.FRIED_EGG.get());
                        pOutput.accept(items.LIGHT_RED.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(blocks.NUKE.get()))
                    .title(Component.literal("Blocks - siwaff"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(blocks.NUKE.get());

                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
