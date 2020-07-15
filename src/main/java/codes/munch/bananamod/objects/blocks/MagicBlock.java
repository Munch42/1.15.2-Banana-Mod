package codes.munch.bananamod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class MagicBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(13, 0, 4.000000000000005, 14, 0.1, 12.000000000000005),
            Block.makeCuboidShape(2, 0, 4.000000000000005, 3, 0.1, 12.000000000000005),
            Block.makeCuboidShape(4, 0, 14, 12, 0.09999999999999964, 15),
            Block.makeCuboidShape(4, 0, 1, 12, 0.09999999999999964, 2),
            Block.makeCuboidShape(3, 0, 2, 4, 0.1, 3),
            Block.makeCuboidShape(2, 0, 3, 3, 0.1, 4),
            Block.makeCuboidShape(13, 0, 3, 14, 0.1, 4),
            Block.makeCuboidShape(12, 0, 2, 13, 0.1, 3),
            Block.makeCuboidShape(12, 0, 13, 13, 0.1, 14),
            Block.makeCuboidShape(13, 0, 12, 14, 0.1, 13),
            Block.makeCuboidShape(3, 0, 13, 4, 0.1, 14),
            Block.makeCuboidShape(2, 0, 12, 3, 0.1, 13),
            Block.makeCuboidShape(8, 0, 12, 9, 0.1, 13),
            Block.makeCuboidShape(7, 0, 12, 9, 0.1, 13),
            Block.makeCuboidShape(7, 0, 3, 9, 0.1, 4),
            Block.makeCuboidShape(9, 0, 7, 11, 0.1, 9),
            Block.makeCuboidShape(5, 0, 7, 7, 0.1, 9),
            Block.makeCuboidShape(7, 0, 9, 9, 0.1, 11),
            Block.makeCuboidShape(7, 0, 5, 9, 0.1, 7),
            Block.makeCuboidShape(10, 0, 4, 12, 0.1, 6),
            Block.makeCuboidShape(4, 0, 4, 6, 0.1, 6),
            Block.makeCuboidShape(4, 0, 10, 6, 0.1, 12),
            Block.makeCuboidShape(10, 0, 10, 12, 0.1, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(4, 0, 2, 12, 0.1, 3),
            Block.makeCuboidShape(4, 0, 13, 12, 0.1, 14),
            Block.makeCuboidShape(14, 0, 4, 15, 0.1, 12),
            Block.makeCuboidShape(1, 0, 4, 2, 0.1, 12),
            Block.makeCuboidShape(2, 0, 12, 3, 0.1, 13),
            Block.makeCuboidShape(3, 0, 13, 4, 0.1, 14),
            Block.makeCuboidShape(3, 0, 2, 4, 0.1, 3),
            Block.makeCuboidShape(2, 0, 3, 3, 0.1, 4),
            Block.makeCuboidShape(13, 0, 3, 14, 0.1, 4),
            Block.makeCuboidShape(12, 0, 2, 13, 0.1, 3),
            Block.makeCuboidShape(13, 0, 12, 14, 0.1, 13),
            Block.makeCuboidShape(12, 0, 13, 13, 0.1, 14),
            Block.makeCuboidShape(12, 0, 7, 13, 0.1, 8),
            Block.makeCuboidShape(12, 0, 7, 13, 0.1, 9),
            Block.makeCuboidShape(3, 0, 7, 4, 0.1, 9),
            Block.makeCuboidShape(7, 0, 5, 9, 0.1, 7),
            Block.makeCuboidShape(7, 0, 9, 9, 0.1, 11),
            Block.makeCuboidShape(9, 0, 7, 11, 0.1, 9),
            Block.makeCuboidShape(5, 0, 7, 7, 0.1, 9),
            Block.makeCuboidShape(4, 0, 4, 6, 0.1, 6),
            Block.makeCuboidShape(4, 0, 10, 6, 0.1, 12),
            Block.makeCuboidShape(10, 0, 10, 12, 0.1, 12),
            Block.makeCuboidShape(10, 0, 4, 12, 0.1, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(2, 0, 4, 3, 0.1, 12),
            Block.makeCuboidShape(13, 0, 4, 14, 0.1, 12),
            Block.makeCuboidShape(4, 0, 1, 12, 0.1, 2),
            Block.makeCuboidShape(4, 0, 14, 12, 0.1, 15),
            Block.makeCuboidShape(12, 0, 13, 13, 0.1, 14),
            Block.makeCuboidShape(13, 0, 12, 14, 0.1, 13),
            Block.makeCuboidShape(2, 0, 12, 3, 0.1, 13),
            Block.makeCuboidShape(3, 0, 13, 4, 0.1, 14),
            Block.makeCuboidShape(3, 0, 2, 4, 0.1, 3),
            Block.makeCuboidShape(2, 0, 3, 3, 0.1, 4),
            Block.makeCuboidShape(12, 0, 2, 13, 0.1, 3),
            Block.makeCuboidShape(13, 0, 3, 14, 0.1, 4),
            Block.makeCuboidShape(7, 0, 3, 8, 0.1, 4),
            Block.makeCuboidShape(7, 0, 3, 9, 0.1, 4),
            Block.makeCuboidShape(7, 0, 12, 9, 0.1, 13),
            Block.makeCuboidShape(5, 0, 7, 7, 0.1, 9),
            Block.makeCuboidShape(9, 0, 7, 11, 0.1, 9),
            Block.makeCuboidShape(7, 0, 5, 9, 0.1, 7),
            Block.makeCuboidShape(7, 0, 9, 9, 0.1, 11),
            Block.makeCuboidShape(4, 0, 10, 6, 0.1, 12),
            Block.makeCuboidShape(10, 0, 10, 12, 0.1, 12),
            Block.makeCuboidShape(10, 0, 4, 12, 0.1, 6),
            Block.makeCuboidShape(4, 0, 4, 6, 0.1, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(4, 0, 13, 12, 0.1, 14),
            Block.makeCuboidShape(4, 0, 2, 12, 0.1, 3),
            Block.makeCuboidShape(1, 0, 4, 2, 0.1, 12),
            Block.makeCuboidShape(14, 0, 4, 15, 0.1, 12),
            Block.makeCuboidShape(13, 0, 3, 14, 0.1, 4),
            Block.makeCuboidShape(12, 0, 2, 13, 0.1, 3),
            Block.makeCuboidShape(12, 0, 13, 13, 0.1, 14),
            Block.makeCuboidShape(13, 0, 12, 14, 0.1, 13),
            Block.makeCuboidShape(2, 0, 12, 3, 0.1, 13),
            Block.makeCuboidShape(3, 0, 13, 4, 0.1, 14),
            Block.makeCuboidShape(2, 0, 3, 3, 0.1, 4),
            Block.makeCuboidShape(3, 0, 2, 4, 0.1, 3),
            Block.makeCuboidShape(3, 0, 8, 4, 0.1, 9),
            Block.makeCuboidShape(3, 0, 7, 4, 0.1, 9),
            Block.makeCuboidShape(12, 0, 7, 13, 0.1, 9),
            Block.makeCuboidShape(7, 0, 9, 9, 0.1, 11),
            Block.makeCuboidShape(7, 0, 5, 9, 0.1, 7),
            Block.makeCuboidShape(5, 0, 7, 7, 0.1, 9),
            Block.makeCuboidShape(9, 0, 7, 11, 0.1, 9),
            Block.makeCuboidShape(10, 0, 10, 12, 0.1, 12),
            Block.makeCuboidShape(10, 0, 4, 12, 0.1, 6),
            Block.makeCuboidShape(4, 0, 4, 6, 0.1, 6),
            Block.makeCuboidShape(4, 0, 10, 6, 0.1, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public MagicBlock(Properties properties){
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        // Switches on the facing?
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // This basically gets the FACING property and then takes the context of the direction you are placing it in and then gets the opposite of that.
        // This is so that it is facing towards you rather than away from you.
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via IBlockState#withRotation(Rotation) whenever possible. Implementing/overriding is
     * fine.
     */
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via IBlockState#withMirror(Mirror) whenever possible. Implementing/overriding is fine.
     */
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        // Remote means is it server or client. Remote would be client. Not remote is client.
        if(!worldIn.isRemote()){
            ServerWorld serverWorld = (ServerWorld) worldIn;

            // Since we are adding lightning it needs to be done on server.
            LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
            serverWorld.addLightningBolt(entity);

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.FAIL;
    }
}
