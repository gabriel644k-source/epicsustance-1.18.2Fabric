package com.g2806.epicsustance;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.g2806.epicsustance.init.ItemRegistry;
import com.g2806.epicsustance.init.BlockRegistry;

public class Epicsustance implements ModInitializer {
	public static final String MOD_ID = "epicsustance";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup DRUG_TAB = FabricItemGroupBuilder.build(
		new Identifier(MOD_ID, "drugs"),
		() -> new ItemStack(ItemRegistry.ITEM_WEED)
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Epic Sustance mod!");
		
		BlockRegistry.registerBlocks();
		ItemRegistry.registerItems();
	}
}