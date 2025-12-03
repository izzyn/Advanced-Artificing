package izzyn.aartifice.blocks;

import com.mojang.serialization.MapCodec;
import izzyn.aartifice.Mana;
import net.fabricmc.fabric.mixin.screenhandler.NamedScreenHandlerFactoryMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CreativeManaSource extends BaseEntityBlock {
    public static final VoxelShape block_shape = makeShape();
    public static final Component CONTAINER_TITLE = Component.translatable("creative_mana_source.title");

    public CreativeManaSource(Properties properties) {
        super(properties);
    }
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(CreativeManaSource::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CreativeManaSourceEntity(pos, state);
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if(!world.isClientSide()){
            if (!(world.getBlockEntity(pos) instanceof CreativeManaSourceEntity creativeManaSourceEntity)) {
                return super.useWithoutItem(state, world, pos, player, hit);
            }
            creativeManaSourceEntity.addPull(2);
            if (world.getBlockEntity(pos) instanceof MenuProvider menuProvider) player.openMenu(menuProvider);

            player.displayClientMessage(Component.literal("You've clicked the block for the " + creativeManaSourceEntity.getMana() + "th time."), true);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getBlockSupportShape(BlockState state, BlockGetter world, BlockPos pos) {
        return block_shape;
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return block_shape;
    }
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return block_shape;
    }
    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.4375, 0, 0.4375, 0.5625, 0.3125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.5, 0.4375, 0.5625, 0.625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.3125, 0.5625, 0.5625, 0.4375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.3125, 0.3125, 0.5625, 0.4375, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.3125, 0.4375, 0.6875, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.3125, 0.4375, 0.5625, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0.4375, 0.4375, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.375, 0.375, 0.4375, 0.4375, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.375, 0.5625, 0.4375, 0.4375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.375, 0.5625, 0.625, 0.4375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.375, 0.375, 0.625, 0.4375, 0.4375), BooleanOp.OR);

        return shape;
    }



}
