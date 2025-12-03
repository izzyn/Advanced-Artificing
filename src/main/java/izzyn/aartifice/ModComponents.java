package izzyn.aartifice;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

public class ModComponents {
    public static final DataComponentType<Mana> MANA_COMPONENT_TYPE = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ResourceLocation.fromNamespaceAndPath(AdvancedArtificing.MOD_ID, "mana"),
            DataComponentType.<Mana>builder().persistent(Mana.CODEC).build()
    );
    protected static void initialize() {
        AdvancedArtificing.LOGGER.info("Registering {} components", AdvancedArtificing.MOD_ID);
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    } }