package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.item.ItemStack

/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[ dissembler ] trait AEPowerStorage extends IAEItemPowerStorage
                                                   with NBTAccess
{
	private final val internalCurrentPower = "internalCurrentPower"

	def maxStorage: Double

	def injectAmount: Double


	def injectAEPower( is: ItemStack, amt: Double ): Double =
	{
		val currentStorage = this.getAECurrentPower( is )
		val maxStorage = this.getAEMaxPower( is )
		val newStorage = Math.min( maxStorage, currentStorage + this.injectAmount )
		val diff = maxStorage - newStorage
		this.setAECurrentPower( is, newStorage )

		diff
	}

	def getAECurrentPower( is: ItemStack ): Double =
	{
		val tag = this.getNBTData( is )
		val currentStorage = tag.getDouble( internalCurrentPower )

		currentStorage
	}

	def getPowerFlow( is: ItemStack ): AccessRestriction = AccessRestriction.WRITE

	def getAEMaxPower( is: ItemStack ): Double = this.maxStorage

	def extractAEPower( is: ItemStack, amt: Double ): Double =
	{
		val currentStorage = this.getAECurrentPower( is )
		val newStorage = Math.max( 0.0, currentStorage - amt )
		this.setAECurrentPower( is, newStorage )

		newStorage
	}

	private def setAECurrentPower( is: ItemStack, value: Double ): Unit =
	{
		val tag = this.getNBTData( is )
		tag.setDouble( internalCurrentPower, value )
	}
}
