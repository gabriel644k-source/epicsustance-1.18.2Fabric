package drugmod.Stuff.Class;

import drugmod.Main;
import drugmod.Init.ItemList;
import drugmod.Stuff.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ArmorBase extends ItemArmor implements IHasModel {
   public ArmorBase(String Name, ArmorMaterial Material, int Index, EntityEquipmentSlot Slot) {
      super(Material, Index, Slot);
      this.func_77655_b(Name);
      this.setRegistryName(Name);
      this.func_77637_a(Main.CREATIVE_TAB);
      ItemList.ITEM_LIST.add(this);
   }

   public void registerModels() {
      Main.proxy.registerItemRenderer(this, 0, "inventory");
   }
}
