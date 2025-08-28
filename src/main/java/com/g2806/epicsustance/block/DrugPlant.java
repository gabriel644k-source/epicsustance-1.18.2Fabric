package com.g2806.epicsustance.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import java.util.List;
import java.util.Random;
import com.g2806.epicsustance.init.BlockRegistry;

public class DrugPlant extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };
    
    private final ItemConvertible seedsItem;
    private final ItemConvertible cropItem;

    public DrugPlant(ItemConvertible seedsItem, ItemConvertible cropItem) {
        super(Settings.copy(net.minecraft.block.Blocks.WHEAT));
        this.seedsItem = seedsItem;
        this.cropItem = cropItem;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return seedsItem;
    }

    protected ItemConvertible getCropItem() {
        return cropItem;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())];
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(BlockRegistry.DRUG_FARMER);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(this.getAgeProperty());
        boolean isMaxAge = age == this.getMaxAge();
        
        if (isMaxAge) {
            if (!world.isClient) {
                // Drop 1-3 crop items
                int cropCount = 1 + world.random.nextInt(3);
                for (int i = 0; i < cropCount; i++) {
                    dropStack(world, pos, new ItemStack(getCropItem()));
                }
                
                // Drop 0-2 seeds
                int seedCount = world.random.nextInt(3);
                for (int i = 0; i < seedCount; i++) {
                    dropStack(world, pos, new ItemStack(getSeedsItem()));
                }
                
                // Reset plant to age 0
                world.setBlockState(pos, state.with(this.getAgeProperty(), 0), 2);
            }
            return ActionResult.SUCCESS;
        }
        
        return super.onUse(state, world, pos, player, hand, hit);
    }
}