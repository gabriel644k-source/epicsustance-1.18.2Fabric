package drugmod.Stuff;

import drugmod.Init.BlockList;
import drugmod.Init.ItemList;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber
public class RegistryHandler {
   @SubscribeEvent
   public static void onItemRegister(Register<Item> Event) {
      Event.getRegistry().registerAll((IForgeRegistryEntry[])ItemList.ITEM_LIST.toArray(new Item[0]));
   }

   @SubscribeEvent
   public static void onBlockRegister(Register<Block> Event) {
      Event.getRegistry().registerAll((IForgeRegistryEntry[])BlockList.BLOCK_LIST.toArray(new Block[0]));
   }

   @SubscribeEvent
   public static void onModelRegister(ModelRegistryEvent Event) {
      Iterator var1 = ItemList.ITEM_LIST.iterator();

      while(var1.hasNext()) {
         Item ThisItem = (Item)var1.next();
         if (ThisItem instanceof IHasModel) {
            ((IHasModel)ThisItem).registerModels();
         }
      }

      var1 = BlockList.BLOCK_LIST.iterator();

      while(var1.hasNext()) {
         Block ThisBlock = (Block)var1.next();
         if (ThisBlock instanceof IHasModel) {
            ((IHasModel)ThisBlock).registerModels();
         }
      }

   }
}
