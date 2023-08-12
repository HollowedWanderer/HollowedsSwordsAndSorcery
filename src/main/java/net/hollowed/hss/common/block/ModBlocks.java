package net.hollowed.hss.common.block;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.block.custom.*;
//import net.hollowed.hss.common.block.entity.custom.AlloyForgeBlock;
import net.hollowed.hss.common.block.entity.custom.AlloyForgeBlock;
import net.hollowed.hss.common.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            SteelBlock::new);
  //  public static final RegistryObject<Block> MINING_TABLE = registerBlock("mining_table",
   //         MiningTable::new);

    /** Crates */
   // public static final RegistryObject<Block> CRATE = registerBlock("crate",
   //         Crate::new);
  //  public static final RegistryObject<Block> APPLE_CRATE = registerBlock("apple_crate",
   //         Crate::new);
  //  public static final RegistryObject<Block> POTATO_CRATE = registerBlock("potato_crate",
  //          Crate::new);
  //  public static final RegistryObject<Block> CARROT_CRATE = registerBlock("carrot_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> BEETROOT_CRATE = registerBlock("beetroot_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> CHORUS_FRUIT_CRATE = registerBlock("chorus_fruit_crate",
  //          Crate::new);
  //  public static final RegistryObject<Block> GOLDEN_CARROT_CRATE = registerBlock("golden_carrot_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> GOLDEN_APPLE_CRATE = registerBlock("golden_apple_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> ARROW_CRATE = registerBlock("arrow_crate",
  //          Crate::new);
   // public static final RegistryObject<Block> ROTTeN_FLESH__CRATE = registerBlock("rotten_flesh_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> BLAZE_ROD_CRATE = registerBlock("blaze_rod_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> ENDER_PEARL_CRATE = registerBlock("ender_pearl_crate",
   //         Crate::new);
   // public static final RegistryObject<Block> STRING_SPOOL = registerBlock("string_spool",
  //          StringSpool::new);
  //  public static final RegistryObject<Block> CHARCOAL_BLOCK = registerBlock("charcoal_block",
  //          CharcoalBlock::new);



    /** Sacks */
   // public static final RegistryObject<Block> GUNPOWDER_SACK = registerBlock("gunpowder_sack",
  //          ExplosiveSack::new);
  //  public static final RegistryObject<Block> COCOA_BEAN_SACK = registerBlock("cocoa_bean_sack",
  //          Sack::new);
  //  public static final RegistryObject<Block> SWEET_BERRY_SACK = registerBlock("sweet_berry_sack",
   //         Sack::new);
   // public static final RegistryObject<Block> SUGAR_SACK = registerBlock("sugar_sack",
   //         Sack::new);
  //  public static final RegistryObject<Block> FEATHER_SACK = registerBlock("feather_sack",
   //         FeatherSack::new);
   // public static final RegistryObject<Block> GLOW_BERRY_SACK = registerBlock("glow_berry_sack",
   //         Sack::new);



    /** Bundles */
  //  public static final RegistryObject<Block> BONE_BUNDLE = registerBlock("bone_bundle",
  //          BoneBundle::new);
  //  public static final RegistryObject<Block> BAMBOO_BUNDLE = registerBlock("bamboo_bundle",
  //          BambooBundle::new);
  //  public static final RegistryObject<Block> CACTUS_BUNDLE = registerBlock("cactus_bundle",
  //          CactusBundle::new);
  //  public static final RegistryObject<Block> SUGAR_CANE_BUNDLE = registerBlock("sugar_cane_bundle",
  //          SugarCaneBundle::new);
    public static final RegistryObject<Block> STICK_BUNDLE = registerBlock("stick_bundle",
            StickBundle::new);




    /** Mahogany Wood */
  //  public static final RegistryObject<Block> MAHOGANY_LOG = registerBlock("mahogany_log",
  //          () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG),
   //                 true, 5, 5));
  //  public static final RegistryObject<Block> MAHOGANY_WOOD = registerBlock("mahogany_wood",
   //         () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
   //                 true, 5,5));
  //  public static final RegistryObject<Block> STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
  //          () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG),
  //                  true, 5, 5));
  //  public static final RegistryObject<Block> STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
   //         () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD),
   //                 true, 5,5));
   // public static final RegistryObject<Block> MAHOGANY_PLANKS = registerBlock("mahogany_planks",
  //          () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
  //                  true, 5,20) );
   // public static final RegistryObject<Block> MAHOGANY_LEAVES = registerBlock("mahogany_leaves",
  //          () -> new MahoganyLeaves(true, 30, 60));
   // public static final RegistryObject<Block> MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
     //       () -> new SaplingBlock(new MahoganyTreeGrower(),
       //             BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
  //  public static final RegistryObject<Block> MAHOGANY_STAIRS = registerBlock("mahogany_stairs",
    //        () -> new StairBlock(() -> ModBlocks.MAHOGANY_PLANKS.get().defaultBlockState(),
     //               BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD).strength(2f, 3f)));
   // public static final RegistryObject<Block> MAHOGANY_SLAB = registerBlock("mahogany_slab",
    //        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
     //               .sound(SoundType.WOOD).strength(2f, 3f)));
   // public static final RegistryObject<Block> MAHOGANY_FENCE = registerBlock("mahogany_fence",
      //      () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
       //             .sound(SoundType.WOOD).strength(2f, 3f)));
   // public static final RegistryObject<Block> MAHOGANY_FENCE_GATE = registerBlock("mahogany_fence_gate",
     //       () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
       //             .sound(SoundType.WOOD).strength(2f, 3f)));
    //public static final RegistryObject<Block> MAHOGANY_BUTTON = registerBlock("mahogany_button",
      //      () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
        //            .strength(0.5f).sound(SoundType.WOOD)));
    //public static final RegistryObject<Block> MAHOGANY_PRESSURE_PLATE = registerBlock("mahogany_pressure_plate",
      //      () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
        //            BlockBehaviour.Properties.of(Material.WOOD)
          //          .strength(0.5f).sound(SoundType.WOOD)));
    //public static final RegistryObject<Block> MAHOGANY_DOOR = registerBlock("mahogany_door",
      //      () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).strength(0.5f)
        //            .noOcclusion().sound(SoundType.WOOD)));
    //public static final RegistryObject<Block> MAHOGANY_TRAPDOOR = registerBlock("mahogany_trapdoor",
      //      () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(0.5f)
        //            .noOcclusion().sound(SoundType.WOOD)));

  //  public static final RegistryObject<Block> MAHOGANY_WALL_SIGN = registerBlockWithoutBlockItem("mahogany_wall_sign",
    //        () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).sound(SoundType.WOOD).noCollission(), ModWoodTypes.MAHOGANY));

    //public static final RegistryObject<Block> MAHOGANY_SIGN = registerBlockWithoutBlockItem("mahogany_sign",
      //      () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).sound(SoundType.WOOD).noCollission(), ModWoodTypes.MAHOGANY));




    /** Cinnamon */
    // I've register the CINNAMON PLANKS without an Item and detailed Properties - because the block is needed for the particle of the Sign
    // If you want to use them as regular block in your mod feel free to change the registration
   // public static final RegistryObject<Block> CINNAMON_PLANKS = registerBlockWithoutBlockItem("cinnamon_planks",
     //       () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

   // public static final RegistryObject<Block> CINNAMON_WALL_SIGN = registerBlockWithoutBlockItem("cinnamon_wall_sign",
      //      () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CINNAMON));

  //  public static final RegistryObject<Block> CINNAMON_SIGN = registerBlockWithoutBlockItem("cinnamon_sign",
        //    () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CINNAMON));




    // - INFO - IMPORTANT -
    //  "render_type": "cutout"  - render layer in json models


    /** Fir Wood */
  //  public static final RegistryObject<Block> GREEN_FIR_SAPLING = registerBlock("green_fir_sapling",
    //        () -> new FirSapling(new NullTree(),
      //              BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    //public static final RegistryObject<Block> ORANGE_FIR_SAPLING = registerBlock("orange_fir_sapling",
      //      () -> new OrangeFirSapling(new NullTree(),
        //            BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    /** Tip <p>
     * If you create flammable Blocks by using the 3 methods isFlammable, Flammability and FireSpreadSpeed <p>
     * the better and cleaner way it is to create a helper class (like the FlammableLeavesBlock-Class) and <p>
     * and pass it the necessary parameters</p></p></p>*/
   // public static final RegistryObject<Block> FIR_LEAVES = registerBlock("fir_leaves",
   //         () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES),
    //                true, 30,60));
 //   public static final RegistryObject<Block> ORANGE_FIR_LEAVES = registerBlock("orange_fir_leaves",
      //      () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES),
        //            true, 30, 60));



    /**Tip <p>
     * If you add an constructor to your/a method, you can pass parameter<p>
     * This looks much cleaner than the implementing of methods in the block registern method!</p></p>*/
    //public static final RegistryObject<Block> FIR_LOG = registerBlock("fir_log",
     //       () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG),
      //              true, 5,5));
  //  public static final RegistryObject<Block> FIR_WOOD = registerBlock("fir_wood",
     //       () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
      //              true, 5,5));
  //  public static final RegistryObject<Block> STRIPPED_FIR_LOG = registerBlock("stripped_fir_log",
     //       () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG),
      //              true, 5,5));
  //  public static final RegistryObject<Block> STRIPPED_FIR_WOOD = registerBlock("stripped_fir_wood",
      //      () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD),
         //           true, 5,5));
  //  public static final RegistryObject<Block> FIR_PLANKS = registerBlock("fir_planks",
        //    () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
        //            true, 5, 20));
  //  public static final RegistryObject<Block> FIR_STAIRS = registerBlock("fir_stairs",
         //   () -> new StairBlock(() -> ModBlocks.FIR_PLANKS.get().defaultBlockState(),
          //          BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
          //                  .strength(2f, 3f)));
   // public static final RegistryObject<Block> FIR_SLAB = registerBlock("fir_slab",
         //   () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)
         //           .strength(2f, 3f)));
 //   public static final RegistryObject<Block> FIR_FENCE = registerBlock("fir_fence",
       //     () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)
          //          .strength(2f, 3f)));
    //public static final RegistryObject<Block> FIR_FENCE_GATE = registerBlock("fir_fence_gate",
      //      () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
        //            .strength(2f, 3f));

    public static final RegistryObject<Block> DUNGEON_DOOR = registerBlock("dungeon_door",
            DungeonDoorBlock::new);
    public static final RegistryObject<Block> DUNGEON_DOOR_OPEN = registerBlock("dungeon_door_open",
            DungeonDoorOpenBlock::new);
    public static final RegistryObject<Block> DUNGEON_DOOR_HITBOX = registerBlock("dungeon_door_hitbox",
            DungeonDoorHitboxBlock::new);
    public static final RegistryObject<Block> DUNGEON_DOOR_OPEN_HITBOX = registerBlock("dungeon_door_open_hitbox",
            DungeonDoorOpenHitboxBlock::new);



    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            PlatinumBlock::new);
    public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block",
            MythrilBlock::new);
    public static final RegistryObject<Block> BEWITCHMENT_TABLE = registerBlock("bewitchment_table",
            () -> new BewitchmentTableBlock(BlockBehaviour.Properties.copy(Blocks.ENCHANTING_TABLE)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion().dynamicShape()
                    .sound(SoundType.STONE)));
   // public static final RegistryObject<Block> CLOVER = registerBlock("clover",
   //         () -> new Clover(MobEffects.LUCK, 10, BlockBehaviour.Properties.copy(Blocks.GRASS)
     //               .noCollission().instabreak().sound(SoundType.GRASS)));

  //  public static final RegistryObject<Block> CATTAIL = registerBlock("cattail",
     //       () -> new Cattail(BlockBehaviour.Properties.copy(Blocks.GRASS)
         //           .noCollission().instabreak().sound(SoundType.GRASS)
            //        .offsetType(BlockBehaviour.OffsetType.XZ)));






    public static final RegistryObject<Block> MOLTEN_IRON_SWORD = registerBlock("molten_iron_sword",
            MoltenIronSword::new);
    public static final RegistryObject<Block> MOLTEN_IRON_PICKAXE = registerBlock("molten_iron_pickaxe",
            MoltenIronPickaxe::new);
    public static final RegistryObject<Block> MOLTEN_IRON_AXE = registerBlock("molten_iron_axe",
            MoltenIronAxe::new);
    public static final RegistryObject<Block> MOLTEN_IRON_SHOVEL = registerBlock("molten_iron_shovel",
            MoltenIronShovel::new);
    public static final RegistryObject<Block> MOLTEN_IRON_HOE = registerBlock("molten_iron_hoe",
            MoltenIronHoe::new);
    public static final RegistryObject<Block> MOLTEN_IRON_GLAIVE = registerBlock("molten_iron_glaive",
            MoltenIronGlaive::new);
    public static final RegistryObject<Block> MOLTEN_IRON_GREATSWORD = registerBlock("molten_iron_greatsword",
            MoltenIronGreatsword::new);
    public static final RegistryObject<Block> MOLTEN_IRON_HELMET = registerBlock("molten_iron_helmet",
            MoltenIronHelmet::new);
    public static final RegistryObject<Block> MOLTEN_IRON_CHESTPLATE = registerBlock("molten_iron_chestplate",
            MoltenIronChestplate::new);
    public static final RegistryObject<Block> MOLTEN_IRON_LEGGINGS = registerBlock("molten_iron_leggings",
            MoltenIronLeggings::new);
    public static final RegistryObject<Block> MOLTEN_IRON_BOOTS = registerBlock("molten_iron_boots",
            MoltenIronBoots::new);

    public static final RegistryObject<Block> MOLTEN_SILVER_HELMET = registerBlock("molten_silver_helmet",
            MoltenSilverHelmet::new);
    public static final RegistryObject<Block> MOLTEN_SILVER_PLATED_CHESTPIECE = registerBlock("molten_silver_plated_chestpiece",
            MoltenSilverChestplate::new);
    public static final RegistryObject<Block> MOLTEN_SILVER_PLATED_LEGGINGS = registerBlock("molten_silver_plated_leggings",
            MoltenSilverLeggings::new);
    public static final RegistryObject<Block> MOLTEN_SILVER_TIPPED_BOOTS = registerBlock("molten_silver_tipped_boots",
            MoltenSilverBoots::new);

    public static final RegistryObject<Block> MOLTEN_GOLDEN_SWORD = registerBlock("molten_golden_sword",
            MoltenGoldenSword::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_PICKAXE = registerBlock("molten_golden_pickaxe",
            MoltenGoldenPickaxe::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_AXE = registerBlock("molten_golden_axe",
            MoltenGoldenAxe::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_SHOVEL = registerBlock("molten_golden_shovel",
            MoltenGoldenShovel::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_HOE = registerBlock("molten_golden_hoe",
            MoltenGoldenHoe::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_GLAIVE = registerBlock("molten_golden_glaive",
            MoltenGoldenGlaive::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_GREATSWORD = registerBlock("molten_golden_greatsword",
            MoltenGoldenGreatsword::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_HELMET = registerBlock("molten_golden_helmet",
            MoltenGoldenHelmet::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_CHESTPLATE = registerBlock("molten_golden_chestplate",
            MoltenGoldenChestplate::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_LEGGINGS = registerBlock("molten_golden_leggings",
            MoltenGoldenLeggings::new);
    public static final RegistryObject<Block> MOLTEN_GOLDEN_BOOTS = registerBlock("molten_golden_boots",
            MoltenGoldenBoots::new);

    public static final RegistryObject<Block> MOLTEN_STEEL_SWORD = registerBlock("molten_steel_sword",
            MoltenSteelSword::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_PICKAXE = registerBlock("molten_steel_pickaxe",
            MoltenSteelPickaxe::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_AXE = registerBlock("molten_steel_axe",
            MoltenSteelAxe::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_SHOVEL = registerBlock("molten_steel_shovel",
            MoltenSteelShovel::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_HOE = registerBlock("molten_steel_hoe",
            MoltenSteelHoe::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_GLAIVE = registerBlock("molten_steel_glaive",
            MoltenSteelGlaive::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_GREATSWORD = registerBlock("molten_steel_greatsword",
            MoltenSteelGreatsword::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_HELMET = registerBlock("molten_steel_helmet",
            MoltenSteelHelmet::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_CHESTPLATE = registerBlock("molten_steel_chestplate",
            MoltenSteelChestplate::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_LEGGINGS = registerBlock("molten_steel_leggings",
            MoltenSteelLeggings::new);
    public static final RegistryObject<Block> MOLTEN_STEEL_BOOTS = registerBlock("molten_steel_boots",
            MoltenSteelBoots::new);





    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            PlatinumOre::new);

    public static final RegistryObject<Block> ALLOY_FORGE = registerBlock("alloy_forge",
            AlloyForgeBlock::new);


    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            DeepslatePlatinumOre::new);

   public static final RegistryObject<Block> TEMPLE_STATUE = registerBlock("temple_statue",
          () -> new TempleStatue(BlockBehaviour.Properties.copy(Blocks.STONE)
                  .strength(4f).requiresCorrectToolForDrops().noOcclusion()
                  .sound(SoundType.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> EMPTY_TEMPLE_STATUE = registerBlock("empty_temple_statue",
            () -> new EmptyTempleStatue(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()
                    .sound(SoundType.POLISHED_DEEPSLATE)));

    public static final RegistryObject<Block> DUNGEON_STEEL = registerBlock("dungeon_steel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()
                    .strength(50.0F, 3000.0F)));
    public static final RegistryObject<Block> ENGRAVED_DUNGEON_STEEL = registerBlock("engraved_dungeon_steel",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops()
                    .strength(50.0F, 3000.0F)));

    // - - Decorative Blocks - -

    public static final RegistryObject<Block> MIXED_BRICKS = registerBlock("mixed_bricks",
         () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).requiresCorrectToolForDrops()
                    .strength(6.0F, 7.0F)));
    public static final RegistryObject<Block> INFERNIUM_BLOCK = registerBlock("infernium_block",
            InferniumBlock::new);
    public static final RegistryObject<Block> ZEPHYRITE_BLOCK = registerBlock("zephyrite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).requiresCorrectToolForDrops()
                    .strength(6.0F, 7.0F)));
    public static final RegistryObject<Block> SLATE = registerBlock("slate",
            Slate::new);

    public static final RegistryObject<Block> ANCIENT_CLAY = registerBlock("ancient_clay",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops()
                    .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> ANCIENT_CLAY_STAIRS = registerBlock("ancient_clay_stairs",
       () -> new StairBlock(() -> ModBlocks.ANCIENT_CLAY.get().defaultBlockState(),
              BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_STAIRS).sound(SoundType.PACKED_MUD)
                      .strength(1f, 3f)));
     public static final RegistryObject<Block> ANCIENT_CLAY_SLAB = registerBlock("ancient_clay_slab",
       () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_SLAB).sound(SoundType.PACKED_MUD)
               .strength(1f, 3f)));
    public static final RegistryObject<Block> ANCIENT_URN = registerBlock("ancient_urn",
            AncientUrnBlock::new);
    public static final RegistryObject<Block> ANCIENT_CLAY_BRICKS = registerBlock("ancient_clay_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()
                    .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> ANCIENT_CLAY_BRICK_STAIRS = registerBlock("ancient_clay_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ANCIENT_CLAY.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_STAIRS).sound(SoundType.MUD_BRICKS)
                            .strength(1f, 3f)));
    public static final RegistryObject<Block> ANCIENT_CLAY_BRICK_SLAB = registerBlock("ancient_clay_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_SLAB).sound(SoundType.MUD_BRICKS)
                    .strength(1f, 3f)));
    public static final RegistryObject<Block> ANCIENT_CLAY_BRICK_WALL = registerBlock("ancient_clay_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_SLAB).sound(SoundType.MUD_BRICKS)
                    .strength(1f, 3f)));
    public static final RegistryObject<Block> TRIMMED_ANCIENT_CLAY = registerBlock("trimmed_ancient_clay",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD).sound(SoundType.PACKED_MUD).requiresCorrectToolForDrops()
                    .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> SLATE_BRICKS = registerBlock("slate_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.DEEPSLATE_BRICKS).requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> SLATE_TILES = registerBlock("slate_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.DEEPSLATE_TILES).requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_SHINGLES = registerBlock("brown_terracotta_shingles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.STONE).requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> VERTICAL_DARK_OAK_PLANKS = registerBlock("vertical_dark_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)
                    .strength(2.0f, 3.0F)));
   /** public static final RegistryObject<Block> MIXED_BRICK_STAIRS = registerBlock("fir_stairs",
            () -> new StairBlock(() -> ModBlocks.FIR_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                            .strength(2f, 3f)),null);
    public static final RegistryObject<Block> FIR_SLAB = registerBlock("fir_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f, 3f)),null);
    public static final RegistryObject<Block> FIR_FENCE = registerBlock("fir_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)
                    .strength(2f, 3f)),null); **/

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientSideHandler {
//
//    }

}

   // DoublePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
