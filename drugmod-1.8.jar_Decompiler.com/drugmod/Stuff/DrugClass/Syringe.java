package drugmod.Stuff.DrugClass;

import drugmod.Init.BlockList;
import drugmod.Init.ItemList;
import drugmod.Stuff.Class.ItemBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Syringe extends ItemBase {
   public Syringe(String Name) {
      super(Name);
   }

   public EnumActionResult func_180614_a(EntityPlayer Player, World CurrentWorld, BlockPos Position, EnumHand Hand, EnumFacing Facing, float X, float Y, float Z) {
      if (!CurrentWorld.field_72995_K) {
         IBlockState State = CurrentWorld.func_180495_p(Position);
         if ((State.func_177230_c().equals(BlockList.PLANT_OPIUM) && BlockList.PLANT_OPIUM.func_185525_y(State) || State.func_177230_c().equals(Blocks.field_150328_O)) && Player.field_71071_by.func_70441_a(new ItemStack(ItemList.ITEM_MORPHINE_SYRINGE))) {
            Player.func_184586_b(Hand).func_190918_g(1);
         }
      }

      return EnumActionResult.SUCCESS;
   }
}
