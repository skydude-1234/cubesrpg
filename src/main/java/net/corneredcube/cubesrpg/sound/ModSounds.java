package net.corneredcube.cubesrpg.sound;

import net.corneredcube.cubesrpg.Cubesrpg;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Cubesrpg.MODID);

    public static final RegistryObject<SoundEvent> plushie_squeak = registerSoundEvents("squeak-toy");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cubesrpg.MODID, name)));
    }
    public static void register(IEventBus bus) {
        SOUND_EVENTS.register(bus);
    }
}
