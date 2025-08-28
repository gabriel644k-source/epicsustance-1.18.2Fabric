package drugmod.Stuff.DrugClass;

import drugmod.Stuff.Configuration;
import drugmod.Stuff.Class.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrugItem extends ItemBase {
   private Potion[] DrugEffect;
   private int DrugDuration;
   private boolean DrugSmoke;

   public DrugItem(String Name, Potion[] Effect, int Duration, boolean Smoke) {
      super(Name);
      this.DrugEffect = Effect;
      this.DrugDuration = Duration;
      this.DrugSmoke = Smoke;
   }

   public EnumActionResult func_180614_a(EntityPlayer Player, World CurrentWorld, BlockPos Position, EnumHand Hand, EnumFacing Facing, float X, float Y, float Z) {
      if (!CurrentWorld.field_72995_K) {
         Player.func_184586_b(Hand).func_190918_g(1);

         for(int I = 0; I < this.DrugEffect.length; ++I) {
            Player.func_70690_d(new PotionEffect(this.DrugEffect[I], this.DrugDuration));
         }

         if (this.DrugSmoke && Configuration.DRUG_SMOKE) {
            CurrentWorld.func_175688_a(EnumParticleTypes.SMOKE_LARGE, Player.field_70165_t, Player.field_70163_u + 2.0D, Player.field_70161_v, 0.0D, 0.1D, 0.0D, new int[0]);
         }

         if (Configuration.DRUG_NAUSEA) {
            Player.func_70690_d(new PotionEffect(MobEffects.field_76431_k, this.DrugDuration * 2));
         }
      }

      return EnumActionResult.SUCCESS;
   }
}
