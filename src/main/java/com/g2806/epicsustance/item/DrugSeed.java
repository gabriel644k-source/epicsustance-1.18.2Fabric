package com.g2806.epicsustance.item;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.block.Block;
import com.g2806.epicsustance.init.BlockRegistry;

public class DrugSeed extends AliasedBlockItem {
    
    public DrugSeed(Settings settings) {
        super(BlockRegistry.PLANT_WEED, settings);
    }
    
    public DrugSeed(Block block, Settings settings) {
        super(block, settings);
    }
}