package com.g2806.epicsustance.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DrugFood extends Item {
    private final StatusEffectInstance[] effects;

    public DrugFood(Item.Settings settings, StatusEffectInstance... effects) {
        super(settings);
        this.effects = effects;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient()) {
            for (StatusEffectInstance effect : effects) {
                user.addStatusEffect(new StatusEffectInstance(effect));
            }
        }
        return super.finishUsing(stack, world, user);
    }
}