package izzyn.aartifice.items;

import izzyn.aartifice.Mana;
import izzyn.aartifice.ModComponents;
import izzyn.aartifice.builders.ManaBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ManaBottle extends Item {
    public ManaBottle(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        if (world.isClientSide()){
            return InteractionResult.SUCCESS;
        }
        Mana count = stack.getOrDefault(ModComponents.MANA_COMPONENT_TYPE, Mana.builder().buildMana());
        ++count.Purity;
        stack.set(ModComponents.MANA_COMPONENT_TYPE, count);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {

        Mana count = stack.getOrDefault(ModComponents.MANA_COMPONENT_TYPE, Mana.builder().buildMana());
        textConsumer.accept(Component.translatable("itemTooltip.advanced-artificing.mana_bottle.info", count.Purity).withStyle(ChatFormatting.AQUA));
    }
}
