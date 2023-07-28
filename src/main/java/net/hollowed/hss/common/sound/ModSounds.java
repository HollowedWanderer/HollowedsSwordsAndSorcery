package net.hollowed.hss.common.sound;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HollowedsSwordsAndSorcery.MOD_ID);

    public static final RegistryObject<SoundEvent> ICEOLOGER_AMBIENT = registerSoundEvent("iceologer_ambient");
    public static final RegistryObject<SoundEvent> ICEOLOGER_HURT = registerSoundEvent("iceologer_hurt");
    public static final RegistryObject<SoundEvent> ICEOLOGER_DEATH = registerSoundEvent("iceologer_death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
