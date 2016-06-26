package buildcraft.core.crops;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import buildcraft.api.crops.CropManager;
import buildcraft.api.crops.ICropHandler;

public class CropHandlerReeds implements ICropHandler {
    public static final CropHandlerReeds INSTANCE = new CropHandlerReeds();
    public static final int MAX_HEIGHT = 3;

    protected CropHandlerReeds() {}

    @Override
    public boolean isSeed(ItemStack stack) {
        return stack.getItem() == Items.REEDS;
    }

    @Override
    public boolean canSustainPlant(World world, ItemStack seed, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        return block.canSustainPlant(state, world, pos, EnumFacing.UP, Blocks.REEDS) && block != Blocks.REEDS && world.isAirBlock(pos.up());
    }

    @Override
    public boolean plantCrop(World world, EntityPlayer player, ItemStack seed, BlockPos pos) {
        return CropManager.getDefaultHandler().plantCrop(world, player, seed, pos);
    }

    @Override
    public boolean isMature(IBlockAccess access, IBlockState state, BlockPos pos) {
        return false;
    }

    @Override
    public boolean harvestCrop(World world, BlockPos pos, List<ItemStack> drops) {
        return false;
    }
}
