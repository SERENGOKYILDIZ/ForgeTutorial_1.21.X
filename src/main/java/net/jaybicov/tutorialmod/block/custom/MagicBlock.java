package net.jaybicov.tutorialmod.block.custom;

import net.jaybicov.tutorialmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

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
            if(itemEntity.getItem().getItem() == ModItems.RAW_ALEXANDRITE.get()) // The item is raw alexandrite?
            {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
                // Convert diamond
            }

            if(itemEntity.getItem().getItem() == Items.FLINT) // The item is flint?
            {
                itemEntity.setItem(new ItemStack(ModItems.ALEXANDRITE.get(), itemEntity.getItem().getCount()));
                // Convert alexandrite
            }

            if(itemEntity.getItem().getItem() == Items.RABBIT_FOOT) // The item is rabbit foot?
            {
                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem().getCount()));
                // Convert emerald
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
