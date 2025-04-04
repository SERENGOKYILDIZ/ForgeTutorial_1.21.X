package net.jaybicov.tutorialmod.item;

import net.jaybicov.tutorialmod.TutorialMod;
import net.jaybicov.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_items_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                            .title(Component.translatable("creativetab.tutorialmod.alexandrite_items"))
                            .displayItems((itemDisplayParameters, pOutput) ->
                                {
                                    pOutput.accept(ModItems.ALEXANDRITE.get()); //We added ALEXANDRITE in our tab.
                                    pOutput.accept(ModItems.RAW_ALEXANDRITE.get()); //We added RAW ALEXANDRITE in our tab.

                                    pOutput.accept(ModItems.CHISEL.get());
                                })
                            .build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                            .title(Component.translatable("creativetab.tutorialmod.alexandrite_blocks"))
                            .withTabsBefore(ALEXANDRITE_ITEMS_TAB.getId()) //For we have 2 tabs.
                            .displayItems((itemDisplayParameters, pOutput) ->
                            {
                                pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
                                pOutput.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());
                            })
                            .build());


    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
