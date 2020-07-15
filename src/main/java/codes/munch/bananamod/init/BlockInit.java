package codes.munch.bananamod.init;

import codes.munch.bananamod.BananaMod;
import codes.munch.bananamod.objects.blocks.BananaOreBlock;
import codes.munch.bananamod.objects.blocks.MagicBlock;
import codes.munch.bananamod.objects.items.MagicBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

// This is where we initialize all blocks.
@Mod.EventBusSubscriber(modid = BananaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BananaMod.MOD_ID)
public class BlockInit {
    public static final Block banana_block = null;
    public static final Block banana_ore_block = null;
    public static final Block magic_block = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.2f, 7.0f).sound(SoundType.CROP)).setRegistryName("banana_block"));
        event.getRegistry().register(new BananaOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.STONE)).setRegistryName("banana_ore_block"));
        event.getRegistry().register(new MagicBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.5f, 8.0f)
                .sound(SoundType.BAMBOO).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                .lightValue(5).slipperiness(1.2f).speedFactor(2.0f).noDrops())
                .setRegistryName("magic_block"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(banana_block, new Item.Properties().maxStackSize(15).group(BananaMod.BananaModItemGroup.instance)).setRegistryName("banana_block"));
        event.getRegistry().register(new BlockItem(banana_ore_block, new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("banana_ore_block"));
        event.getRegistry().register(new MagicBlockItem(magic_block,  new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("magic_block"));
    }
}
