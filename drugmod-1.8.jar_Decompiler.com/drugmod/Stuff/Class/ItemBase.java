package drugmod.Stuff.Class;

import drugmod.Main;
import drugmod.Init.ItemList;
import drugmod.Stuff.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
   public ItemBase(String Name) {
      this.func_77655_b(Name);
      this.setRegistryName(Name);
      this.func_77637_a(Main.CREATIVE_TAB);
      ItemList.ITEM_LIST.add(this);
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0, "inventory");
   }
}
