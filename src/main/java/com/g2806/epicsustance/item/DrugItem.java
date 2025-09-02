package com.g2806.epicsustance.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.level.Level;

public class DrugItem extends Item {
    private final MobEffectInstance[] effects;
    private final boolean producesSmoke;

    public DrugItem(Item.Properties settings, MobEffectInstance... effects) {
        this(settings, true, effects);
    }

    public DrugItem(Item.Properties settings, boolean producesSmoke, MobEffectInstance... effects) {
        super(settings);
        this.effects = effects;
        this.producesSmoke = producesSmoke;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        
        if (!world.isClientSide()) {
            consumeDrug(user, world);
            itemStack.shrink(1);
        }
        
        return InteractionResultHolder.consume(itemStack);
    }

    private void consumeDrug(LivingEntity entity, Level world) {
        for (MobEffectInstance effect : effects) {
            entity.addEffect(new MobEffectInstance(effect));
        }

        if (producesSmoke && !world.isClientSide()) {
            ServerLevel serverWorld = (ServerLevel) world;
            serverWorld.sendParticles(ParticleTypes.LARGE_SMOKE, 
                entity.getX(), entity.getY() + 2.0, entity.getZ(), 
                5, 0.0, 0.1, 0.0, 0.0);
        }
    }
}