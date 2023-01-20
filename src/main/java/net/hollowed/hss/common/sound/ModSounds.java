package net.hollowed.hss.common.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.hollowed.hss.HollowedsSwordsAndSorcery.MOD_ID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> MOD_SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<SoundEvent> HEAVY_STEP =
            registerSoundEvent("heavy_step");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return MOD_SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MOD_ID)));
    }

    public static void register(IEventBus eventBus) {
        MOD_SOUND_EVENTS.register(eventBus);
    }
}
