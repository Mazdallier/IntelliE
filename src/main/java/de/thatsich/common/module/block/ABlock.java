package de.thatsich.common.module.block;

import de.thatsich.common.module.ATexture;
import de.thatsich.common.module.block.info.ABlockInfo;
import de.thatsich.common.module.block.info.ABlockName;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;


public abstract class ABlock extends Block implements IBlock
{
	protected ABlock ( ABlockInfo info, ABlockConfig config, ATexture blockTexture )
	{
		super( info.getMaterial() );

		final ABlockName blockName = info.getBlockName();
		final String name = blockName.getName();
		final float hardness = info.getHardness();
		final CreativeTabs creativeTab = info.getCreativeTab();
		final String texture = blockTexture.getTexture();

		this.setBlockName( name );
		this.setHardness( hardness );
		this.setBlockTextureName( texture );
		this.setCreativeTab( creativeTab );
	}
}
