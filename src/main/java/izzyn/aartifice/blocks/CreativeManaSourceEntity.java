package izzyn.aartifice.blocks;

import izzyn.aartifice.Mana;
import izzyn.aartifice.ModBlockEntities;
import izzyn.aartifice.ModBlocks;
import izzyn.aartifice.menus.CreativeManaSourceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


public class CreativeManaSourceEntity extends BlockEntity implements MenuProvider {

    public Mana mana = Mana.builder().baseStorage(100).potency(56).pull(1).buildMana();
    ContainerData data = new ContainerData() {
        @Override
        public int get(int i) {
            return switch(i){
                case 0 -> mana.Potency;
                case 1 -> mana.Purity;
                case 2 -> mana.Pull;
                default -> 0;
            };
        }

        @Override
        public void set(int i, int j) {
            switch(i){
                case 0 -> {
                    if(mana.Potency == j){ return;}
                    mana.Potency = j;
                }
                case 1 -> {
                    if(mana.Purity == j){ return;}
                    mana.Purity = j;
                }
                case 2 -> {
                    if(mana.Pull == j){ return;}
                    mana.Pull = j;
                }
            }
            setChanged();
        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    public CreativeManaSourceEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.CREATIVE_MANA_SOURCE_ENTITY, pos, state);
    }
    public int getMana(){
        return mana.getTargetStorage();
    }

    public void addPull(int pull){
        mana.Pull += pull;
        setChanged();
    }
 @Override
    protected void saveAdditional(ValueOutput writeView){
        mana.serialize(writeView);
        super.saveAdditional(writeView);
    }

    @Override
    protected void loadAdditional(ValueInput readView){
        super.loadAdditional(readView);
        mana.deserialize(readView);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        return saveWithoutMetadata(registryLookup);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return this.level instanceof ServerLevel ? new CreativeManaSourceMenu(i,inventory, this.data, ContainerLevelAccess.create(getLevel(), getBlockPos())): null;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.advanced-artificing.creative_mana_source");
    }
}