package net.jaybicov.tutorialmod.item;

import net.jaybicov.tutorialmod.TutorialMod;
import net.jaybicov.tutorialmod.item.custom.ChiselItem;
import net.jaybicov.tutorialmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            ()-> new Item(new Item.Properties()
            ));

    //For Second item:
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            ()-> new Item(new Item.Properties()
            ));


    //For Advanced item:
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            ()-> new ChiselItem(new Item.Properties()
                    .durability(32)
            ));

    //For Custom Food item:
    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            ()-> new Item(new Item.Properties()
                    .food(ModFoodProperties.KOHLRABI)
            )
                // Adding a custom tooltip with an anonymous class
            {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    //For Custom Fuel item:
    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            ()-> new FuelItem(new Item.Properties(), 1200));




    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}