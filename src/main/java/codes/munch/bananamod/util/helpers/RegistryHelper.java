package codes.munch.bananamod.util.helpers;

import codes.munch.bananamod.BananaMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryHelper {
    // This is to quickly register features, blocks, items, structures, biomes etc.
    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey){
        entry.setRegistryName(new ResourceLocation(BananaMod.MOD_ID, registryKey));
        registry.register(entry);
        return entry;
    }
}
