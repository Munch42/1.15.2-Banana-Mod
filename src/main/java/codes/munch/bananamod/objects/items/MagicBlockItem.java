package codes.munch.bananamod.objects.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagicBlockItem extends BlockItem {
    public MagicBlockItem(Block blockIn, Item.Properties properties){
        super(blockIn, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
