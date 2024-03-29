package net.hollowed.hss.common.enchantment;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.FrostWalkerEnchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, HollowedsSwordsAndSorcery.MOD_ID);

 //   public static RegistryObject<Enchantment> LIGHTNING_STRIKER =
   //         ENCHANTMENTS.register("lightning_striker",
     //               () -> new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON,
       //                     EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> CURSE_OF_SHATTERING =
            ENCHANTMENTS.register("curse_of_shattering",
                    () -> new CurseOfShattering(Enchantment.Rarity.RARE, EnchantmentCategory.BREAKABLE, EquipmentSlot.values()));
    public static RegistryObject<Enchantment> GILDED_RESILIENCE =
            ENCHANTMENTS.register("gilded_resilience",
                    () -> new GildedResilience(Enchantment.Rarity.UNCOMMON));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
