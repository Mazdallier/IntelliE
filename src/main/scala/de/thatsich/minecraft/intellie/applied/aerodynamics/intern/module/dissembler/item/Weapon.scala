package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import de.thatsich.minecraft.common.module.util.{CappedValue, NBTAccess}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait Weapon extends Item
                     with NBTAccess
                     with DissemblerConfigAccess
                     with CappedValue
                     with AEPowerStorage
{
	/**
	 * Called when hitting an entity
	 * if sufficient power is there
	 * it deals damage to the target
	 *
	 * @param is weapoen
	 * @param target target entity
	 * @param hitter hitting entity
	 *
	 * @return false to cancel further processing
	 */
	override def hitEntity(is: ItemStack, target: EntityLivingBase, hitter: EntityLivingBase): Boolean =
	{
		val energyUsage = this.getCurrentEnergyPerBlockBreak(is)
		if (this.getAECurrentPower(is) > energyUsage)
		{
			this.extractAEPower(is, energyUsage)

			hitter match
			{
				case player: EntityPlayer =>
					val source = DamageSource.causePlayerDamage(player)
					val damage: Float = this.getCurrentDamageVsEntities(is).toFloat

					target.attackEntityFrom(source, damage)
					return true
				case _                    =>
			}
		}

		false
	}

//	override def onLeftClickEntity(stack: ItemStack, player: EntityPlayer, entity: Entity): Boolean =
//	{
//		val damage = this.getCurrentDamageVsEntities(stack)
//
//		entity.attackEntityFrom(DamageSource.causePlayerDamage(player), damage.toFloat)
//
//		false
//	}

	def getCurrentDamageVsEntities(is: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		val current: Double = tag.getDouble(Weapon.internalCurrentDamageVsEntities)

		this.getInBetween(this.initDamageVsEntites, current, this.maxDamageVsEntites)
	}

	def setCurrentDamageVsEntities(is: ItemStack, value: Double): Unit =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		tag.setDouble(Weapon.internalCurrentDamageVsEntities, value)
	}
}

object Weapon
{
	private final val internalCurrentDamageVsEntities: String = "internalCurrentDamageVsEntities"
}
