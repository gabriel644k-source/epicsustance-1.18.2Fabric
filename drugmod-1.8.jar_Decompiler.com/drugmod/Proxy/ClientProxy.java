package drugmod.Proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
   public void registerItemRenderer(Item ThisItem, int Meta, String ID) {
      ModelLoader.setCustomModelResourceLocation(ThisItem, Meta, new ModelResourceLocation(ThisItem.getRegistryName(), ID));
   }
}
