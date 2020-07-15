package codes.munch.bananamod.events;

import codes.munch.bananamod.BananaMod;
import codes.munch.bananamod.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Bus.MOD for usually when you modify your own event or another mods event.
// Bus.FORGE is for when you modify a forge or minecraft event
// https://www.youtube.com/watch?v=rIG50FtF3U0&list=PLaevjqy3XufYmltqo0eQusnkKVN7MpTUe&index=9
//
// For value, it is either Dist.Client if it is client only like rendering
// And Dedicated server if it is server only.
// For most events this is not needed as they run on both client and server.
@Mod.EventBusSubscriber(modid = BananaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestJumpEvent {
    @SubscribeEvent
    public static void testJumpEvent(LivingJumpEvent event){
        //BananaMod.LOGGER.info("TestJumpEvent Fired");
        LivingEntity livingEntity = event.getEntityLiving();

        World world = livingEntity.getEntityWorld();
        //world.setBlockState(livingEntity.getPosition().add(5, 0, 0), BlockInit.banana_block.getDefaultState());

        //livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 255));
        //livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5000, 255));

        //livingEntity.setGlowing(true);
    }
}
