package net.hollowed.hss.common.item.custom;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MOD_ID);

    public static final RegistryObject<Attribute> FIRE_DAMAGE = ATTRIBUTES.register("fire_damage", () ->
            new RangedAttribute("generic.fire_damage", 2.0D, 0.0D, 2048.0D));
}
