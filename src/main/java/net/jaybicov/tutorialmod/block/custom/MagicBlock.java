package net.jaybicov.tutorialmod.block.custom;

import net.jaybicov.tutorialmod.item.ModItems;
import net.jaybicov.tutorialmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

/**
 * A quick name change process can be performed with SHIFT + F6.
 */
public class MagicBlock extends Block {
    /**
    * When CTRL + H is pressed, the "Hierarchy" window that opens shows other blocks.
    */
    public MagicBlock(Properties properties) {
        super(properties);
    }
    // By studying the "MagmaBlock" class, we can understand what the "stepOn" method does.


    /**
     * We have overridden the otherwise condition with this code.
    */
    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    /// If an item comes in, this place will work
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        if(pEntity instanceof ItemEntity itemEntity) // Is it item?
        {
//            if(itemEntity.getItem().getItem() == ModItems.RAW_ALEXANDRITE.get()) // The item is raw alexandrite?
//            {
//                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
//                // Convert diamond
//            }
//
//            if(itemEntity.getItem().getItem() == Items.FLINT) // The item is flint?
//            {
//                itemEntity.setItem(new ItemStack(ModItems.ALEXANDRITE.get(), itemEntity.getItem().getCount()));
//                // Convert alexandrite
//            }
//
//            if(itemEntity.getItem().getItem() == Items.RABBIT_FOOT) // The item is rabbit foot?
//            {
//                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem().getCount()));
//                // Convert emerald
//            }

            //For Custom Tags
            if(isValidItem(itemEntity.getItem())) // If the item's tag is "TRANSFORMABLE_ITEMS"
            {
            itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
                // Convert diamond
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    // This method was added automatically for Custom Tags
    private boolean isValidItem(ItemStack item)
    {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }


    // For Custom Tooltips
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.magic_block.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
