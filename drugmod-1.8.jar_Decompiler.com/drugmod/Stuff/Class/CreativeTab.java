package drugmod.Stuff.Class;

import drugmod.Init.ItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
   public CreativeTab(String Name) {
      super(Name);
   }

   public ItemStack func_78016_d() {
      return new ItemStack(ItemList.DRUG_WEED);
   }
}
