package izzyn.aartifice.datagen;

import izzyn.aartifice.AdvancedArtificing;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

import static net.minecraft.world.phys.shapes.Shapes.block;

public class AdvancedArtificingModelProvider extends FabricModelProvider {
    public AdvancedArtificingModelProvider(FabricDataOutput output){
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator){
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }

    @Override
    public String getName() {
        return "AdvancedArtificingModelProvider";
    }
    private static class CustomBlockStateModelGenerator {
        public static final ModelTemplate CREATIVE_MANA_SOURCE = block("creative_mana_source", TextureSlot.create("1"), TextureSlot.create("2"), TextureSlot.create("3"));
        private static ModelTemplate block(String parent, TextureSlot... requiredTextureKeys){
            return new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(AdvancedArtificing.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
        }
    }
}