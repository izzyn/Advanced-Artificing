package izzyn.aartifice.menus;

import izzyn.aartifice.ModMenus;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

public class CreativeManaSourceMenu extends AbstractContainerMenu {
    public ContainerData data;
    ContainerLevelAccess dataAccess;
    public CreativeManaSourceMenu(int ContainerID, Inventory inventory){
        //this(ContainerID, inventory);
        this(ContainerID, inventory, new SimpleContainerData(3), ContainerLevelAccess.NULL);
    }
    public CreativeManaSourceMenu(int containerID, Inventory inventory, ContainerData _data, ContainerLevelAccess _dataAccess){
        super(ModMenus.CREATIVE_MANA_SOURCE_MENU, containerID);
        this.data = _data;
        this.dataAccess = _dataAccess;
        this.addDataSlots(data);
    }
    public int getPotency(){
        return this.data.get(0);
    }
    public int getPurity(){
        return this.data.get(1);
    }
    public int getPull(){
        return this.data.get(2);
    }

    public void setPotency(int value){
        if(value != this.data.get(0)){
            this.setData(0, value);
            this.broadcastChanges();
            this.sendAllDataToRemote();

        }
    }
    public void setPurity(int value){
        if(value != this.data.get(1)){
            this.setData(0, value);
        }
    }
    public void getPull(int value){
        if(value != this.data.get(2)){
            this.setData(0, value);
        }
    }
    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }


}