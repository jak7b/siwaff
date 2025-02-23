package net.kuko.siwaff.item;

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

    public static final RegistryObject<CreativeModeTab> RANDOM_STUFF = CREATIVE_MODE_TABS.register("random_stuff",
            () -> CreativeModeTab.builder() .icon(()-> new ItemStack(Items.BARRIER))
                    .title(Component.literal("Random Stuffik"+" - " + main.ownSuffix))
                    .displayItems((itemDisplayParameters, output) ->
                            output.accept(Items.BARRIER)

                            )).build();

    public static final RegistryObject<CreativeModeTab> IDEAS = CREATIVE_MODE_TABS.register("ideas",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(Items.BARRIER))
                    .title(Component.literal("Ideas"+" - " + main.ownSuffix))
                    .displayItems((itemDisplayParameters, output) ->
                                    output.accept(Items.BARRIER)
                            )
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
