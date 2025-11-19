package izzyn.aartifice.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


public class CreativeManaSource extends Block {
    public static final VoxelShape block_shape = makeShape();
    public CreativeManaSource(Properties settings){
        super(settings);
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