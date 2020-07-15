package codes.munch.bananamod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class BananaOreBlock extends Block {
    public BananaOreBlock(Properties properties){
        super(properties);
    }

    int baseXP = 1000;

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return (baseXP * fortune);
    }
}
