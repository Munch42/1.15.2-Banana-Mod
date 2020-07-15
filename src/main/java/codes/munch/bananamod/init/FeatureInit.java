package codes.munch.bananamod.init;

import codes.munch.bananamod.BananaMod;
import codes.munch.bananamod.util.helpers.RegistryHelper;
import codes.munch.bananamod.world.features.structures.ShinyBananaTemplePieces;
import codes.munch.bananamod.world.features.structures.ShinyBananaTempleStructure;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FeatureInit {

    // Static instance of our structure for ease of adding to biomes.
    public static Structure<NoFeatureConfig> SHINY_BANANA_TEMPLE = new ShinyBananaTempleStructure(NoFeatureConfig::deserialize);
    public static IStructurePieceType SBTP = ShinyBananaTemplePieces.Piece::new;


    /*
     * Registers the features and structures. Normal Features will be registered here too.
     */
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
    {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();

        /* Registers the structure itself and sets what its path is. In this case,
         * the structure will have the resourcelocation of structure_tutorial:run_down_house (actually, bananamod:shiny_banana_temple).
         *
         * It is always a good idea to register your regular features too so that other mods
         * can use them too directly from the Forge Registry. It great for mod compatibility.
         */
        RegistryHelper.register(registry, SHINY_BANANA_TEMPLE, "shiny_banana_temple");
        register(SBTP, "SBTP");
        List<Structure<?>> tempList = new ArrayList<>(Feature.ILLAGER_STRUCTURES);
        tempList.add(SHINY_BANANA_TEMPLE);
        Feature.ILLAGER_STRUCTURES = ImmutableList.copyOf(tempList);
    }


    /*
     * Registers the structures pieces themselves. If you don't do this part, Forge will complain to you in the Console.
     */
    static IStructurePieceType register(IStructurePieceType structurePiece, String key)
    {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
    }
}
