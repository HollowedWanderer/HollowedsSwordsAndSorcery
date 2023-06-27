package net.hollowed.hss.common.item;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.ModBlocks;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.item.custom.*;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HollowedsSwordsAndSorcery.MOD_ID);

   // public static final RegistryObject<Item> TESTITEM = ITEMS.register("test_item",
     //       () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> TESTMODELITEM = ITEMS.register("test_model_item",
      //      () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STAFF_OF_THUNDERING = ITEMS.register("staff_of_thundering",
            StaffOfThundering::new);
    public static final RegistryObject<Item> ETERNAL_GOLDEN_CARROT = ITEMS.register("eternal_golden_carrot",
            () -> new EternalGoldenCarrot(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant()));
    public static final RegistryObject<Item> SILVER_SCRAP = ITEMS.register("silver_scrap",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot",
            () -> new Item(new Item.Properties().stacksTo(64)));

    //Wrought/Aetherium Items

    //public static final RegistryObject<Item> AETHERIUM_INGOT = ITEMS.register("aetherium_ingot",
      //      () -> new Item(new Item.Properties().stacksTo(64)));

    //public static final RegistryObject<Item> INFINITY_DUST = ITEMS.register("infinity_dust",
         //   () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ENDER_DUST = ITEMS.register("ender_dust",
            () -> new Item(new Item.Properties().stacksTo(64)
                    ));
  //  public static final RegistryObject<Item> MAHOGANY_SIGN = ITEMS.register("mahogany_sign",
    //        () -> new SignItem(new Item.Properties().stacksTo(16),
      //              ModBlocks.MAHOGANY_SIGN.get(), ModBlocks.MAHOGANY_WALL_SIGN.get()));

    //public static final RegistryObject<Item> CINNAMON_SIGN = ITEMS.register("cinnamon_sign",
      //      () -> new SignItem(new Item.Properties().stacksTo(16)
        //            ,
          //          ModBlocks.CINNAMON_SIGN.get(), ModBlocks.CINNAMON_WALL_SIGN.get()));
    public static final RegistryObject<Item> SILVER_PLATED_CROSSBOW = ITEMS.register("silver_plated_crossbow",
            () -> new SpeedCrossbowItem(
                    new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModTiers.Steel, 2, -2.4f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModTiers.Steel, 0, -2.8f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModTiers.Steel, 5, -3.1f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModTiers.Steel, 1, -3f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModTiers.Steel, -3, -1f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_LEGGING = ITEMS.register("steel_leggings",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_GREATSWORD = ITEMS.register("steel_greatsword",
            () -> new BlockingSword(ModTiers.Steel, 5, -2.9f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_GLAIVE = ITEMS.register("steel_glaive",
            () -> new HeavySwordItem(ModTiers.Steel, 1, -2.4f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModTiers.Platinum, 4, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModTiers.Platinum, 2, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModTiers.Platinum, 6, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModTiers.Platinum, 2, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModTiers.Platinum, -2, -1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_GREATSWORD = ITEMS.register("platinum_greatsword",
            () -> new BlockingSword(ModTiers.Platinum, 6, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_GLAIVE = ITEMS.register("platinum_glaive",
            () -> new HeavySwordItem(ModTiers.Platinum, 3, -2.3f,
                    new Item.Properties()));
 public static final RegistryObject<Item> PLATINUM_DAGGER = ITEMS.register("platinum_dagger",
         () -> new DaggerItem(ModTiers.Platinum, 1, -1.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet",
            () -> new SilverArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PLATED_CHESTPIECE = ITEMS.register("silver_plated_chestpiece",
            () -> new SilverArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PLATED_LEGGINGS = ITEMS.register("silver_plated_leggings",
            () -> new SilverArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_TIPPED_BOOTS = ITEMS.register("silver_tipped_boots",
            () -> new SilverArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> GREAT_HAMMER = ITEMS.register("great_hammer",
            () -> new SwordItem(ModTiers.ModStone, 5, -3.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BATTLESTAFF = ITEMS.register("battlestaff",
            () -> new SwordItem(ModTiers.ModWood, 1, -2.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> GAUNTLET = ITEMS.register("gauntlet",
            () -> new SwordItem(ModTiers.ModStone, -1, -1.6f,
                    new Item.Properties()));
 public static final RegistryObject<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive",
         () -> new HeavySwordItem(ModTiers.ModWood, 1, -2.4f,
                 new Item.Properties()));
 public static final RegistryObject<Item> STONE_GLAIVE = ITEMS.register("stone_glaive",
         () -> new HeavySwordItem(ModTiers.ModStone, 1, -2.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new HeavySwordItem(ModTiers.Steel, 1, -2.4f,
                    new Item.Properties()));
 public static final RegistryObject<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive",
         () -> new HeavySwordItem(ModTiers.Steel, 1, -2.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new HeavySwordItem(ModTiers.Steel, 2, -2.3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new HeavySwordItem(ModTiers.Steel, 3, -2.3f,
                    new Item.Properties().fireResistant()));
 public static final RegistryObject<Item> WOODEN_GREATSWORD = ITEMS.register("wooden_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 2, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> STONE_GREATSWORD = ITEMS.register("stone_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 3, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 4, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> GOLDEN_GREATSWORD = ITEMS.register("golden_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 2, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 5, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 6, -2.8f,
                 new Item.Properties()));
    public static final RegistryObject<Item> DEATHS_SCYTHE = ITEMS.register("deaths_scythe",
            () -> new DeathItem(ModTiers.Platinum, -4, -2.4f,
                    new Item.Properties().rarity(Rarity.EPIC)));
  //  public static final RegistryObject<Item> WINGED_MEDALLION = ITEMS.register("winged_medallion",
    //        ParagliderItem::new);
   // public static final RegistryObject<Item> WROUGHT_SPEARMAN_SPAWN_EGG = ITEMS.register("wrought_spearman_spawn_egg",
     //       () -> new ForgeSpawnEggItem(ModEntityTypes.WROUGHT_SPEARMAN, 0x7e8986, 0x007662,
       //             new Item.Properties().tab(ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB)));
    //public static final RegistryObject<Item> WROUGHT_SWORDSMAN_SPAWN_EGG = ITEMS.register("wrought_swordsman_spawn_egg",
      //      () -> new ForgeSpawnEggItem(ModEntityTypes.WROUGHT_SWORDSMAN, 0x7e8986, 0x007662,
        //            new Item.Properties().tab(ModCreativeModeTab.HOLLOWEDS_SWORDS_AND_SORCERY_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
