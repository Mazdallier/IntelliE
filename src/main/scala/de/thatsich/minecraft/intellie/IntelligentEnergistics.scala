package de.thatsich.minecraft.intellie


import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.agricultures.AppliedAgricultures
import de.thatsich.minecraft.intellie.applied.intelligences.AppliedIntelligences
import de.thatsich.minecraft.intellie.child.ChildUnloader


/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = IntelligentEnergistics.id,
	name = IntelligentEnergistics.name,
	version = IntelligentEnergistics.version,
	dependencies = IntelligentEnergistics.dependencies,
	modLanguage = "scala"
)
object IntelligentEnergistics extends ChildUnloader
{
	final val id = "intellie"
	final val name = "Intelligent Energistics"
	final val version = "${version}"
	final val dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);required-after:appliedenergistics2@[rv1-beta-1,)"

	private val abbreviation = new Abbreviation("IE")
	private val log = new SimpleLog(this.abbreviation)

	this.unload(AppliedAerodynamics.id, this.disableAero, this.log)
	this.unload(AppliedAgricultures.id, this.disableAgro, this.log)
	this.unload(AppliedIntelligences.id, this.disableInt, this.log)
}