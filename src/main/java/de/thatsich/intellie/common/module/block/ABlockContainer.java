package de.thatsich.intellie.common.module.block;

import dagger.ObjectGraph;
import de.thatsich.intellie.common.module.ATexture;
import de.thatsich.intellie.common.module.block.info.ABlockInfo;
import de.thatsich.intellie.common.module.block.info.ABlockName;
import de.thatsich.intellie.common.module.item.AItemBlock;
import de.thatsich.intellie.common.module.tileentity.ATileEntity;
import de.thatsich.intellie.common.registries.TileEntityRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.inject.Inject;


public abstract class ABlockContainer extends BlockContainer implements IBlockContainer
{
	private final Class<? extends AItemBlock> itemBlockClass;
	private final Class<? extends ATileEntity> tileEntityClass;
	@Inject ObjectGraph injector;
	@Inject TileEntityRegistry tileEntities;

	protected ABlockContainer ( ABlockInfo info, ABlockConfig config, ABlockGui gui, ABlockNetwork network, ATexture texture, Class<? extends ATileEntity> tileEntityClass, Class<? extends AItemBlock> itemBlockClass )
	{
		super( info.getMaterial() );

		this.tileEntityClass = tileEntityClass;
		this.itemBlockClass = itemBlockClass;

		final ABlockName blockName = info.getBlockName();
		final String name = blockName.getName();
		final float hardness = info.getHardness();
		final CreativeTabs creativeTab = info.getCreativeTab();

		this.setBlockName( name );
		this.setHardness( hardness );
		//		this.setBlockBounds(  );

		this.setCreativeTab( creativeTab );
		//		Player player = null;
		//		InventoryPlayer play = null;
		//		play.

	}

	public Class<? extends AItemBlock> getItemBlockClass ()
	{
		return this.itemBlockClass;
	}

	@Override
	public TileEntity createNewTileEntity ( World world, int metadata )
	{
		final ATileEntity tileEntity = this.injector.get( this.tileEntityClass );

		this.tileEntities.addTileEntity( tileEntity );

		return tileEntity;
	}
}