package net.hollowed.hss.common.item;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.ModEntityTypes;
import net.hollowed.hss.common.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HollowedsSwordsAndSorcery.MOD_ID);

    /** Entity Spawn Eggs **/

    public static final RegistryObject<Item> ICEOLOGER_SPAWN_EGG = ITEMS.register("iceologer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ICEOLOGER, 0x005bb0, 0x9cd9ff,
                    new Item.Properties()));



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
    public static final RegistryObject<Item> ENDER_DUST = ITEMS.register("ender_dust",
            () -> new Item(new Item.Properties().stacksTo(64)
                    ));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> BLANK_CLAY_TABLET = ITEMS.register("blank_clay_tablet",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> SWORD_MOLD = ITEMS.register("sword_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> PICKAXE_MOLD = ITEMS.register("pickaxe_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> AXE_MOLD = ITEMS.register("axe_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> SHOVEL_MOLD = ITEMS.register("shovel_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> HOE_MOLD = ITEMS.register("hoe_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> GREATSWORD_MOLD = ITEMS.register("greatsword_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> GLAIVE_MOLD = ITEMS.register("glaive_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> HELMET_MOLD = ITEMS.register("helmet_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> CHESTPLATE_MOLD = ITEMS.register("chestplate_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> LEGGINGS_MOLD = ITEMS.register("leggings_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> BOOTS_MOLD = ITEMS.register("boots_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_CLAY_TABLET = ITEMS.register("ancient_clay_tablet",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> ANCIENT_SWORD_MOLD = ITEMS.register("ancient_sword_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_PICKAXE_MOLD = ITEMS.register("ancient_pickaxe_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_AXE_MOLD = ITEMS.register("ancient_axe_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_SHOVEL_MOLD = ITEMS.register("ancient_shovel_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_HOE_MOLD = ITEMS.register("ancient_hoe_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_GREATSWORD_MOLD = ITEMS.register("ancient_greatsword_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_GLAIVE_MOLD = ITEMS.register("ancient_glaive_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_HELMET_MOLD = ITEMS.register("ancient_helmet_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_CHESTPLATE_MOLD = ITEMS.register("ancient_chestplate_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_LEGGINGS_MOLD = ITEMS.register("ancient_leggings_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> ANCIENT_BOOTS_MOLD = ITEMS.register("ancient_boots_mold",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> WOODEN_HELMET_TEMPLATE = ITEMS.register("wooden_helmet_template",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> WOODEN_CHESTPLATE_TEMPLATE = ITEMS.register("wooden_chestplate_template",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> WOODEN_LEGGINGS_TEMPLATE = ITEMS.register("wooden_leggings_template",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> WOODEN_BOOTS_TEMPLATE = ITEMS.register("wooden_boots_template",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));


    public static final RegistryObject<Item> IRON_CHUNK = ITEMS.register("iron_chunk",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> STEEL_CHUNK = ITEMS.register("steel_chunk",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> SILVER_CHUNK = ITEMS.register("silver_chunk",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> GOLD_CHUNK = ITEMS.register("gold_chunk",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> LARGE_DIAMOND = ITEMS.register("large_diamond",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> PLATINUM_CHUNK = ITEMS.register("platinum_chunk",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));






    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_SWORD = ITEMS.register("shaped_molten_iron_sword",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_PICKAXE = ITEMS.register("shaped_molten_iron_pickaxe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_AXE = ITEMS.register("shaped_molten_iron_axe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_SHOVEL = ITEMS.register("shaped_molten_iron_shovel",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_HOE = ITEMS.register("shaped_molten_iron_hoe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_GLAIVE = ITEMS.register("shaped_molten_iron_glaive",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_GREATSWORD = ITEMS.register("shaped_molten_iron_greatsword",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_HELMET = ITEMS.register("shaped_molten_iron_helmet",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_CHESTPLATE = ITEMS.register("shaped_molten_iron_chestplate",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_LEGGINGS = ITEMS.register("shaped_molten_iron_leggings",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_IRON_BOOTS = ITEMS.register("shaped_molten_iron_boots",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));


    public static final RegistryObject<Item> SHAPED_MOLTEN_SILVER_HELMET = ITEMS.register("shaped_molten_silver_helmet",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_SILVER_PLATED_CHESTPIECE = ITEMS.register("shaped_molten_silver_plated_chestpiece",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_SILVER_PLATED_LEGGINGS = ITEMS.register("shaped_molten_silver_plated_leggings",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_SILVER_TIPPED_BOOTS = ITEMS.register("shaped_molten_silver_tipped_boots",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));


    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_SWORD = ITEMS.register("shaped_molten_golden_sword",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_PICKAXE = ITEMS.register("shaped_molten_golden_pickaxe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_AXE = ITEMS.register("shaped_molten_golden_axe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_SHOVEL = ITEMS.register("shaped_molten_golden_shovel",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_HOE = ITEMS.register("shaped_molten_golden_hoe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_GLAIVE = ITEMS.register("shaped_molten_golden_glaive",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_GREATSWORD = ITEMS.register("shaped_molten_golden_greatsword",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_HELMET = ITEMS.register("shaped_molten_golden_helmet",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_CHESTPLATE = ITEMS.register("shaped_molten_golden_chestplate",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_LEGGINGS = ITEMS.register("shaped_molten_golden_leggings",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_GOLDEN_BOOTS = ITEMS.register("shaped_molten_golden_boots",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));


    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_SWORD = ITEMS.register("shaped_molten_steel_sword",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_PICKAXE = ITEMS.register("shaped_molten_steel_pickaxe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_AXE = ITEMS.register("shaped_molten_steel_axe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_SHOVEL = ITEMS.register("shaped_molten_steel_shovel",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_HOE = ITEMS.register("shaped_molten_steel_hoe",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_GLAIVE = ITEMS.register("shaped_molten_steel_glaive",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_GREATSWORD = ITEMS.register("shaped_molten_steel_greatsword",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_HELMET = ITEMS.register("shaped_molten_steel_helmet",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_CHESTPLATE = ITEMS.register("shaped_molten_steel_chestplate",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_LEGGINGS = ITEMS.register("shaped_molten_steel_leggings",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> SHAPED_MOLTEN_STEEL_BOOTS = ITEMS.register("shaped_molten_steel_boots",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));




    public static final RegistryObject<Item> SILVER_PLATED_CROSSBOW = ITEMS.register("silver_plated_crossbow",
            () -> new SpeedCrossbowItem(
                    new Item.Properties().durability(654)));



    public static final RegistryObject<Item> LEGENDARY_KEY = ITEMS.register("legendary_key",
            () -> new EdibleKeyItem(new Item.Properties().stacksTo(64)));


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
            () -> new BlockingSword(ModTiers.Steel, 4, -2.9f,
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
            () -> new HeavySwordItem(ModTiers.Platinum, 3, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PLATED_CHESTPIECE = ITEMS.register("silver_plated_chestpiece",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PLATED_LEGGINGS = ITEMS.register("silver_plated_leggings",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_TIPPED_BOOTS = ITEMS.register("silver_tipped_boots",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> GREAT_HAMMER = ITEMS.register("great_hammer",
            () -> new HammerItem(ModTiers.ModStone, 5, -3.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BATTLESTAFF = ITEMS.register("battlestaff",
            () -> new SwordItem(ModTiers.ModWood, 1, -2.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> GAUNTLET = ITEMS.register("gauntlet",
            () -> new SwordItem(ModTiers.ModStone, -1, -1.6f,
                    new Item.Properties()));
 public static final RegistryObject<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive",
         () -> new HeavySwordItem(ModTiers.ModWood, -1, -2.4f,
                 new Item.Properties()));
 public static final RegistryObject<Item> STONE_GLAIVE = ITEMS.register("stone_glaive",
         () -> new HeavySwordItem(ModTiers.ModStone, 0, -2.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new HeavySwordItem(ModTiers.ModIron, 1, -2.4f,
                    new Item.Properties()));
 public static final RegistryObject<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive",
         () -> new HeavySwordItem(ModTiers.ModGold, -1, -2.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new HeavySwordItem(ModTiers.ModDiamond, 2, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new HeavySwordItem(ModTiers.ModNetherite, 3, -2.4f,
                    new Item.Properties().fireResistant()));
 public static final RegistryObject<Item> WOODEN_GREATSWORD = ITEMS.register("wooden_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 2, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> STONE_GREATSWORD = ITEMS.register("stone_greatsword",
         () -> new BlockingSword(ModTiers.ModStone, 3, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
         () -> new BlockingSword(ModTiers.ModIron, 4, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> GOLDEN_GREATSWORD = ITEMS.register("golden_greatsword",
         () -> new BlockingSword(ModTiers.ModGold, 2, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword",
         () -> new BlockingSword(ModTiers.ModDiamond, 5, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword",
         () -> new BlockingSword(ModTiers.ModNetherite, 6, -2.8f,
                 new Item.Properties()));
    public static final RegistryObject<Item> VANGUARD_SHIELD = ITEMS.register("vanguard_shield",
            () -> new VanguardShield(
                    new Item.Properties().rarity(Rarity.UNCOMMON).durability(447)));
    public static final RegistryObject<Item> DEATHS_SCYTHE = ITEMS.register("deaths_scythe",
            () -> new DeathItem(ModTiers.Platinum, -3, -2.4f,
                    new Item.Properties().rarity(Rarity.EPIC)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
