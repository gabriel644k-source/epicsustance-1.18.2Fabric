package drugmod.Stuff.DrugClass;

import drugmod.Main;
import drugmod.Init.BlockList;
import drugmod.Init.ItemList;
import drugmod.Stuff.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class DrugSeed extends Item implements IHasModel, IPlantable {
   private Block DrugPlant;

   public DrugSeed(String Name) {
      this.func_77655_b(Name);
      this.setRegistryName(Name);
      this.func_77637_a(Main.CREATIVE_TAB);
      ItemList.ITEM_LIST.add(this);
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0, "inventory");
   }

   public EnumActionResult func_180614_a(EntityPlayer Player, World CurrentWorld, BlockPos Position, EnumHand Hand, EnumFacing Facing, float X, float Y, float Z) {
      if (!CurrentWorld.field_72995_K) {
         ItemStack Stack = Player.func_184586_b(Hand);
         IBlockState State = CurrentWorld.func_180495_p(Position).func_177230_c().func_176223_P();
         boolean Sustainable = State.equals(BlockList.DRUG_FARMER.func_176223_P()) || State.equals(Blocks.field_150458_ak.func_176223_P());
         if (Facing == EnumFacing.UP && Player.func_175151_a(Position.func_177972_a(Facing), Facing, Stack) && Sustainable && CurrentWorld.func_175623_d(Position.func_177984_a())) {
            CurrentWorld.func_175656_a(Position.func_177984_a(), this.DrugPlant.func_176223_P());
            Stack.func_190918_g(1);
            return EnumActionResult.SUCCESS;
         }
      }

      return EnumActionResult.FAIL;
   }

   public EnumPlantType getPlantType(IBlockAccess World, BlockPos Position) {
      return EnumPlantType.Crop;
   }

   public IBlockState getPlant(IBlockAccess World, BlockPos Position) {
      return this.DrugPlant.func_176223_P();
   }

   public DrugSeed SetPlant(Block Plant) {
      this.DrugPlant = Plant;
      return this;
   }
}
