package drugmod.Stuff.Class;

import drugmod.Main;
import drugmod.Init.BlockList;
import drugmod.Init.ItemList;
import drugmod.Stuff.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
   public BlockBase(String Name, Material Material) {
      super(Material);
      this.func_149663_c(Name);
      this.setRegistryName(Name);
      this.func_149647_a(Main.CREATIVE_TAB);
      BlockList.BLOCK_LIST.add(this);
      ItemList.ITEM_LIST.add((new ItemBlock(this)).setRegistryName(this.getRegistryName()));
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(Item.func_150898_a(this), 0, "inventory");
   }
}
