package drugmod.Stuff.DrugClass;

import drugmod.Init.BlockList;
import drugmod.Init.ItemList;
import java.util.Random;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class DrugPlant extends BlockCrops {
   private Item DrugSeed;
   private Item DrugItem;

   public DrugPlant(String Name) {
      this.func_149663_c(Name);
      this.setRegistryName(Name);
      BlockList.BLOCK_LIST.add(this);
      ItemList.ITEM_LIST.add((new ItemBlock(this)).setRegistryName(this.getRegistryName()));
   }

   public boolean func_180639_a(World World, BlockPos Position, IBlockState State, EntityPlayer Player, EnumHand Hand, EnumFacing Facing, float X, float Y, float Z) {
      if (this.func_185525_y(State) && Player.func_184586_b(Hand).func_190926_b()) {
         if (!Player.func_191521_c(new ItemStack(this.DrugItem))) {
            World.func_72838_d(new EntityItem(World, (double)Position.func_177958_n(), (double)Position.func_177956_o(), (double)Position.func_177952_p(), new ItemStack(this.DrugItem, 1)));
         }

         World.func_175656_a(Position, this.func_185528_e(0));
         return true;
      } else {
         return false;
      }
   }

   public boolean func_180671_f(World World, BlockPos Position, IBlockState State) {
      IBlockState Under = World.func_180495_p(Position.func_177977_b()).func_177230_c().func_176223_P();
      return Under.equals(Blocks.field_150458_ak.func_176223_P()) || Under.equals(BlockList.DRUG_FARMER.func_176223_P());
   }

   public void func_180645_a(World CurrentWorld, BlockPos Position, IBlockState State, Random Random) {
      if (!CurrentWorld.field_72995_K && this.func_185525_y(State)) {
         IBlockState Under = CurrentWorld.func_180495_p(Position.func_177977_b()).func_177230_c().func_176223_P();
         if (Under.equals(BlockList.DRUG_FARMER.func_176223_P()) && CurrentWorld.func_180495_p(Position.func_177979_c(2)).func_177230_c().equals(Blocks.field_150438_bZ)) {
            TileEntity Storage = CurrentWorld.func_175625_s(Position.func_177979_c(2));
            if (!Storage.equals((Object)null)) {
               IItemHandler Container = (IItemHandler)Storage.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);

               for(int I = 0; I < Container.getSlots(); ++I) {
                  ItemStack Remaining = Container.insertItem(I, new ItemStack(this.DrugItem, 1), true);
                  if (Remaining.func_190926_b()) {
                     CurrentWorld.func_175656_a(Position, this.func_185528_e(0));
                     Container.insertItem(0, new ItemStack(this.DrugItem, 1), false);
                     break;
                  }
               }
            }
         }
      }

      super.func_180645_a(CurrentWorld, Position, State, Random);
   }

   protected Item func_149866_i() {
      return this.DrugSeed;
   }

   protected Item func_149865_P() {
      return this.DrugItem;
   }

   public DrugPlant SetSeed(Item Seed) {
      this.DrugSeed = Seed;
      return this;
   }

   public DrugPlant SetDrug(Item Drug) {
      this.DrugItem = Drug;
      return this;
   }
}
