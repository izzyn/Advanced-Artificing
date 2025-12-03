package izzyn.aartifice;

import izzyn.aartifice.blocks.CreativeManaSourceEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities{

    public static final BlockEntityType<CreativeManaSourceEntity> CREATIVE_MANA_SOURCE_ENTITY = register("creative_mana_source_entity", CreativeManaSourceEntity::new, ModBlocks.CREATIVE_MANA_SOURCE);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(AdvancedArtificing.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
    public static void initialize() {}
}