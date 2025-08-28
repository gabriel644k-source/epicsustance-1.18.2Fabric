package com.g2806.epicsustance.init;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.g2806.epicsustance.Epicsustance;
import com.g2806.epicsustance.block.DrugPlant;

public class BlockRegistry {
    
    public static final DrugPlant PLANT_WEED = registerBlock("plant_weed", 
        new DrugPlant(Items.WHEAT_SEEDS), false);
    public static final DrugPlant PLANT_COCAINE = registerBlock("plant_cocaine", 
        new DrugPlant(Items.WHEAT_SEEDS), false);
    public static final DrugPlant PLANT_TOBACCO = registerBlock("plant_tobacco", 
        new DrugPlant(Items.WHEAT_SEEDS), false);
    public static final DrugPlant PLANT_OPIUM = registerBlock("plant_opium", 
        new DrugPlant(Items.WHEAT_SEEDS), false);
    
    public static final Block DRUG_FARMER = registerBlock("drug_farmer", 
        new Block(Block.Settings.of(Material.STONE).strength(3.0f)), true);

    private static <T extends Block> T registerBlock(String name, T block, boolean shouldRegisterItem) {
        Identifier id = new Identifier(Epicsustance.MOD_ID, name);
        
        if (shouldRegisterItem) {
            Registry.register(Registry.ITEM, id, new BlockItem(block, 
                new Item.Settings().group(Epicsustance.DRUG_TAB)));
        }
        
        return Registry.register(Registry.BLOCK, id, block);
    }

    public static void registerBlocks() {
        Epicsustance.LOGGER.info("Registering blocks for " + Epicsustance.MOD_ID);
    }
}