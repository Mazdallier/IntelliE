package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IIcon
import net.minecraft.world.{IBlockAccess, World}


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchBlock extends BlockContainer(Material.iron)
                             with WorkbenchGuiHandler
{
	private var iconSide: IIcon = null
	private var iconTop: IIcon = null
	private var iconBottom: IIcon = null
	this.setBlockName("appaero.workbench")
	this.setBlockTextureName("workbench")

	@SideOnly(Side.CLIENT)
	override def registerBlockIcons(register: IIconRegister): Unit =
	{
		this.iconTop = register.registerIcon("appaero:workbench_top")
		this.iconSide = register.registerIcon("appaero:workbench_side")
		this.iconBottom = register.registerIcon("appaero:workbench_bottom")
	}

	@SideOnly(Side.CLIENT)
	override def getIcon(workd: IBlockAccess, x: Int, y: Int, z: Int, side: Int): IIcon =
	{
		side match
		{
			case 0 => this.iconBottom
			case 1 => this.iconTop

			case _ => this.iconSide
		}
	}

	@SideOnly(Side.CLIENT)
	override def getIcon(side: Int, meta: Int): IIcon =
	{
		side match
		{
			case 0 => this.iconBottom
			case 1 => this.iconTop

			case _ => this.iconSide
		}
	}

	override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, hitX: Float, hitY: Float, p_149727_9_ : Float): Boolean =
	{
		if (!world.isRemote)
		{
			val name = this.getClass.getSimpleName
			val hash = this.getUniqueID(name)
			println(s"HASH: $hash")
			player.openGui(AppliedAerodynamics, hash, world, x, y, z)
		}

		true
	}

	def createNewTileEntity(world: World, par2int: Int): TileEntity = new WorkbenchTileEntity

	// TODO refactoring to commong
	private def getUniqueID(str: String): Int =
	{
		var h: Int = 0

		for (ch <- str)
		{
			h = 31 * h + ch
		}

		h
	}
}
