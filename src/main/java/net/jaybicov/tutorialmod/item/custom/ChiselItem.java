package net.jaybicov.tutorialmod.item.custom;

import net.jaybicov.tutorialmod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

/**
 * Press CTRL + H for you want to see functions of Item Class
 */
public class ChiselItem extends Item {
    /**
     * We have prepared a map variable for the blocks that Chisel will change.
     */
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.GLASS, Blocks.DIAMOND_BLOCK,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.DIAMOND_BLOCK, Blocks.BEDROCK,
                    Blocks.DIRT, ModBlocks.ALEXANDRITE_BLOCK.get()
            );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }



    /**
     * Run this function if you click anything block.
     */
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel(); // Clicked coordinate.
        Block clickedBlock = level.getBlockState(pContext.getClickedPos())
                .getBlock(); // Clicked coordinate of block.

        if(CHISEL_MAP.containsKey(clickedBlock)) // If the clicked block exists in the variable we have prepared.
        {
            if(!level.isClientSide()) //Is the Server or Client being controlled? (Required)
            {
                // This code changes the blocks.
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());



                // This code works to reduce your life after using the tool.
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level),
                        ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));


                // This code plays sound. (Grindstone sound was used)
                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE,
                        SoundSource.BLOCKS);

            }
        }
        return InteractionResult.SUCCESS;
    }
}
