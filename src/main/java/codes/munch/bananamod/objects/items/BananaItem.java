package codes.munch.bananamod.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BananaItem extends Item {
    public BananaItem(Properties properties){
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        //  In Ticks the amount of time it burns.
        return 600;
    }
}
