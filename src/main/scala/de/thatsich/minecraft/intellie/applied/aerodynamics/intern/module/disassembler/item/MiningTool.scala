package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler.item


import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait MiningTool extends Item
                         with AEPowerStorage
                         with NBTAccess
                         with DisassemblerConfigAccess
{
	/**
	 * gets the mining speed
	 *
	 * @param is ItemStack of this
	 * @param block Mining block
	 * @param metadata metadata of bloc
	 *
	 * @return configured mining speed
	 */
	override def getDigSpeed(is: ItemStack, block: Block, metadata: Int): Float =
	{
		this.getCurrentMiningSpeed(is).toFloat
	}

	def getCurrentMiningSpeed(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current: Int = tag.getInteger(Tags.MiningSpeed)

		if (this.getAECurrentPower(is) >= this.getCurrentEnergyUsage(is))
		{
			(this.initMiningSpeed + current) min this.maxMiningSpeed
		}
		else
		{
			0
		}
	}

	def setCurrentMiningSpeed(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.MiningSpeed, value)
	}

	def getCurrentMiningLevel(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current = tag.getDouble(Tags.MiningLevel)

		(this.initMiningLevel + current) min this.maxMiningLevel
	}

	def setCurrentMiningLevel(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.MiningLevel, value)
	}

	private object Tags extends Enumeration
	{
		type Tags = Value
		val MiningLevel, MiningSpeed = Value

		implicit def tagsToString(tag: Tags): String = tag.toString.toLowerCase
	}

}