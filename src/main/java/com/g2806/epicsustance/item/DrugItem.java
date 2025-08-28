package com.g2806.epicsustance.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DrugItem extends Item {
    private final StatusEffectInstance[] effects;
    private final boolean producesSmoke;

    public DrugItem(Item.Settings settings, StatusEffectInstance... effects) {
        this(settings, true, effects);
    }

    public DrugItem(Item.Settings settings, boolean producesSmoke, StatusEffectInstance... effects) {
        super(settings);
        this.effects = effects;
        this.producesSmoke = producesSmoke;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        
        if (!world.isClient()) {
            consumeDrug(user, world);
            itemStack.decrement(1);
        }
        
        return TypedActionResult.consume(itemStack);
    }

    private void consumeDrug(LivingEntity entity, World world) {
        for (StatusEffectInstance effect : effects) {
            entity.addStatusEffect(new StatusEffectInstance(effect));
        }

        if (producesSmoke && !world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE, 
                entity.getX(), entity.getY() + 2.0, entity.getZ(), 
                5, 0.0, 0.1, 0.0, 0.0);
        }
    }
}