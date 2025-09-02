package com.g2806.epicsustance.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.InteractionResult;
import com.g2806.epicsustance.init.BlockRegistry;

public class DrugSeed extends BlockItem {
    
    public DrugSeed(Properties settings) {
        super(BlockRegistry.PLANT_WEED.get(), settings);
    }
    
    public DrugSeed(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState state) {
        Block blockBelow = context.getLevel().getBlockState(context.getClickedPos().below()).getBlock();
        return blockBelow == BlockRegistry.DRUG_FARMER.get();
    }
}