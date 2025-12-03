package izzyn.aartifice.screens.widgets;


import izzyn.aartifice.ModComponents;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class ScrollWidget extends AbstractSliderButton {

    Consumer<Double> event;
    public ScrollWidget(int i, int j, int k, int l, Component component, double d, Consumer<Double> _event) {
        super(i, j, k, l, component, d);
        this.event = _event;
    }

    @Override
    protected void updateMessage() {
            event.accept(value);
            //setMessage(Component.nullToEmpty(String.format("%.2f", value)));
    }

    @Override
    protected void applyValue() {

    }
}