package com.g2806.epicsustance.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DrugFood extends Item {
    private final MobEffectInstance[] effects;

    public DrugFood(Item.Properties settings, MobEffectInstance... effects) {
        super(settings);
        this.effects = effects;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (!world.isClientSide()) {
            for (MobEffectInstance effect : effects) {
                user.addEffect(new MobEffectInstance(effect));
            }
        }
        return super.finishUsingItem(stack, world, user);
    }
}