package codes.munch.bananamod.init;

import codes.munch.bananamod.BananaMod;
import codes.munch.bananamod.objects.items.BananaItem;
import codes.munch.bananamod.objects.items.SpecialItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

// This is where we initialize all items.
@Mod.EventBusSubscriber(modid = BananaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(BananaMod.MOD_ID)
public class ItemInit {
    public static final Item banana_item = null;
    public static final Item special_item = null;

    // Tools
    public static final Item banana_sword = null;
    public static final Item banana_pickaxe = null;
    public static final Item banana_shovel = null;
    public static final Item banana_axe = null;
    public static final Item banana_hoe = null;

    // Armour
    public static final Item banana_helmet = null;
    public static final Item banana_chestplate = null;
    public static final Item banana_leggings = null;
    public static final Item banana_boots = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BananaItem(new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(8).saturation(1.2f).meat().effect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000, 3), 0.7f).build())).setRegistryName("banana_item"));
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("special_item"));

        // Tools
        event.getRegistry().register(new SwordItem(ModItemTier.BANANA, 7, 5.0f, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(12).saturation(4f).build())).setRegistryName("banana_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.BANANA, 4, 5.0f, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(12).saturation(6f).build())).setRegistryName("banana_pickaxe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.BANANA, 2, 5.0f, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(12).saturation(6f).build())).setRegistryName("banana_shovel"));
        event.getRegistry().register(new AxeItem(ModItemTier.BANANA, 10, 2.5f, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(12).saturation(6f).build())).setRegistryName("banana_axe"));
        event.getRegistry().register(new HoeItem(ModItemTier.BANANA, 1, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(14).saturation(3f).build())).setRegistryName("banana_hoe"));
        event.getRegistry().register(new SwordItem(ModItemTier.BANANA, 6, 5.5f, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(14).saturation(5f).build())).setRegistryName("banana_cutlass_wood"));

        // Banana Gold Tools
        event.getRegistry().register(new SwordItem(ModItemTier.BANANA_GOLD, 8, 6.0f, new Item.Properties().group(BananaMod.BananaModItemGroup.instance).food(new Food.Builder().hunger(15).saturation(7f).build())).setRegistryName("banana_cutlass_banana"));

        // Armour
        event.getRegistry().register(new ArmorItem(ModArmourMaterial.BANANA_ARMOUR, EquipmentSlotType.HEAD, new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("banana_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmourMaterial.BANANA_ARMOUR, EquipmentSlotType.CHEST, new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("banana_chestplate"));
        event.getRegistry().register(new ArmorItem(ModArmourMaterial.BANANA_ARMOUR, EquipmentSlotType.LEGS, new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("banana_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmourMaterial.BANANA_ARMOUR, EquipmentSlotType.FEET, new Item.Properties().group(BananaMod.BananaModItemGroup.instance)).setRegistryName("banana_boots"));
    }

    public enum ModItemTier implements IItemTier{
        //      int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
        BANANA(4, 1700, 15.0f, 7.0f, 250, () -> {
            return Ingredient.fromItems(ItemInit.banana_item);
        }),

        BANANA_GOLD(5, 2100, 18.0f, 8.0f, 275, () -> {
            return Ingredient.fromItems(ItemInit.banana_item);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

    public enum ModArmourMaterial implements IArmorMaterial {
        //This is the texture id so like bananamod:banana/layer1 or 2, Then maxDamageFactor, Then Damage Reduction Factor in this order:
        // Boots, Leggings, Chestplate, Helmet, Enchantability, Equip Sound, Toughness, Ingredient Supplier same as above
        BANANA_ARMOUR(BananaMod.MOD_ID + ":banana", 5, new int[] {7, 9, 11, 7}, 158, SoundEvents.ENTITY_BEE_STING, 6.5f, () -> {
           return Ingredient.fromItems(ItemInit.banana_item);
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModArmourMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn){
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}
