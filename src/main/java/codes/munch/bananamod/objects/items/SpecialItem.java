package codes.munch.bananamod.objects.items;

import codes.munch.bananamod.init.BlockInit;
import codes.munch.bananamod.util.helpers.KeyboardHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SpecialItem extends Item {
    public SpecialItem(Properties properties){
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent("You were holding shift!"));
            tooltip.add(new StringTextComponent("This is a test tooltip?!"));
        } else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT" + "\u00A77" + " for more info!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 500, 255));
        worldIn.setRainStrength(1.0f);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        return true;
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.banana_block.getDefaultState());
        return super.onEntityItemUpdate(stack, entity);
    }
}
