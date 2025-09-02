package com.g2806.epicsustance.block;

import net.minecraft.world.level.ItemLike;
import com.g2806.epicsustance.init.ItemRegistry;

public class TobaccoPlant extends DrugPlant {
    public TobaccoPlant() {
        super(null, null); // Will be set via overrides to avoid circular dependency
    }
    
    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistry.SEED_TOBACCO.get();
    }
    
    @Override
    protected ItemLike getCropItem() {
        return ItemRegistry.ITEM_TOBACCO.get();
    }
}