package codes.munch.bananamod;

import codes.munch.bananamod.init.ItemInit;
import codes.munch.bananamod.init.FeatureInit;
import codes.munch.bananamod.world.gen.BananaOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("bananamod")
@Mod.EventBusSubscriber(modid = BananaMod.MOD_ID, bus = Bus.MOD)
public class BananaMod
{
    // This is for the Mappings: http://export.mcpbot.bspk.rs/
    // Tutorial I have been following: https://www.youtube.com/watch?v=rIG50FtF3U0&list=PLaevjqy3XufYmltqo0eQusnkKVN7MpTUe

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "bananamod";
    public static BananaMod instance;

    public BananaMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        modEventBus.addListener(this::setup);

        // Register the enqueueIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);
        instance = this;

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code

        //Add our structure to all biomes including other modded biomes
        //
        //You can filter to certain biomes based on stuff like temperature, scale, precipitation, mod id,
        //and if you use the BiomeDictionary, you can even check if the biome has certain tags like swamp or snowy.
        for(Biome biome : ForgeRegistries.BIOMES) {
            // All structures needs to be added by .addStructure AND .addFeature in order to spawn.
            //
            // .addStructure tells Minecraft that this biome can start the generation of the structure.
            // .addFeature tells Minecraft that the pieces of the structure can be made in this biome.
            //
            // Thus it is best practice to do .addFeature for all biomes and do .addStructure as well for
            // the biome you want the structure to spawn in. That way, the structure will only spawn in the
            // biomes you want but will not get cut off when generating if part of it goes into a non-valid biome.
            //
            //Note: If your mappings are out of data,
            //	Biome.addStructure will be Biome.func_225566_b_ ,
            //      Feature.withConfiguration will be Feature.func_225566_b_ ,
            //	ConfiguredFeature.withPlacement will be ConfiguredFeature.func_227228_a_ ,
            //	Placement.configure will be Placement.func_227446_a_
            if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS || biome == Biomes.DESERT_LAKES) {
                biome.addStructure(FeatureInit.SHINY_BANANA_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
                biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, FeatureInit.SHINY_BANANA_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
            }
        }
    }

    /*private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }*/

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        // Load is done before server starts which is when you want to generate things like ores.

        BananaOreGen.generateOre();
    }

    public static class BananaModItemGroup extends ItemGroup {
        public static final BananaModItemGroup instance = new BananaModItemGroup(ItemGroup.GROUPS.length, "bananatab");

        private BananaModItemGroup(int index, String label){
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.banana_item);
        }
    }

    // Structure Tutorial: https://github.com/TelepathicGrunt/StructureTutorialMod
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event){
            // Registers the structures/features
            // If this isn't done, it will crash.
            FeatureInit.registerFeatures(event);
        }
    }
}
