package de.thatsich.minecraft.core.module.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.item.{ItemStack, ItemArmor}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItemArmor( material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int )
                         ( implicit creativeTab: CreativeTabs )
	extends ItemArmor( material, renderIndex, armorType )
{
	this.setCreativeTab( creativeTab )
	this.setUnlocalizedName( this.getClass.getSimpleName )

	override def getArmorTexture( stack: ItemStack, entity: Entity, slot: Int, `type`: String ): String =
	{
		"appaero:textures/suite/armor.png"
	}
}