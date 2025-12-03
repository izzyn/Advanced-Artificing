package izzyn.aartifice;

import izzyn.aartifice.screens.CreativeManaSourceScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.MenuScreens;

@Environment(EnvType.CLIENT)
public class AdvancedArtificingClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        MenuScreens.register(ModMenus.CREATIVE_MANA_SOURCE_MENU, CreativeManaSourceScreen::new);
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}
