package net.jaybicov.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

// It is necessary to click the SHIFT key 2 times to search for special classes (such as meals).

public class ModFoodProperties {
    public static final FoodProperties KOHLRABI = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 400), 0.20f)
            .usingConvertsTo(Items.DIAMOND) // I added it (It was an exaggeration, of course).
            .build();
}
