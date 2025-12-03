package izzyn.aartifice;
import izzyn.aartifice.AdvancedArtificing;
import izzyn.aartifice.blocks.CreativeManaSource;
import izzyn.aartifice.menus.CreativeManaSourceMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModMenus {

    public static final MenuType<CreativeManaSourceMenu> CREATIVE_MANA_SOURCE_MENU =register("creative_mana_source_menu",CreativeManaSourceMenu::new, FeatureFlags.VANILLA_SET);
    public static <T extends AbstractContainerMenu> MenuType<T> register(String name, BiFunction<Integer, Inventory, T> menuFactory, FeatureFlagSet flags){
        ResourceKey<MenuType<?>> key = ResourceKey.create(Registries.MENU, ResourceLocation.fromNamespaceAndPath(AdvancedArtificing.MOD_ID, name));
        MenuType<T> menu = new MenuType<>(menuFactory::apply, flags);
        Registry.register(BuiltInRegistries.MENU, key, menu);
        return menu;
    }
    public static void initialize(){

    }
}