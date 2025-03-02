package owmii.powah.block;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import owmii.powah.Powah;
import owmii.powah.block.cable.CableBlock;
import owmii.powah.block.discharger.EnergyDischargerBlock;
import owmii.powah.block.ender.EnderCellBlock;
import owmii.powah.block.ender.EnderGateBlock;
import owmii.powah.block.energizing.EnergizingOrbBlock;
import owmii.powah.block.energizing.EnergizingRodBlock;
import owmii.powah.block.energycell.EnergyCellBlock;
import owmii.powah.block.furnator.FurnatorBlock;
import owmii.powah.block.hopper.EnergyHopperBlock;
import owmii.powah.block.magmator.MagmatorBlock;
import owmii.powah.block.reactor.ReactorBlock;
import owmii.powah.block.solar.SolarBlock;
import owmii.powah.block.thermo.ThermoBlock;
import owmii.powah.block.transmitter.PlayerTransmitterBlock;
import owmii.powah.lib.block.Properties;
import owmii.powah.lib.registry.VarReg;

public class Blcks {

    public static final DeferredRegister.Blocks DR = DeferredRegister.createBlocks(Powah.MOD_ID);

    public static final VarReg<Tier, Block> ENERGY_CELL = new VarReg<>(DR, "energy_cell",
            variant -> new EnergyCellBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.values());
    public static final VarReg<Tier, Block> ENDER_CELL = new VarReg<>(DR, "ender_cell",
            variant -> new EnderCellBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> ENERGY_CABLE = new VarReg<>(DR, "energy_cable",
            variant -> new CableBlock(Properties.metalNoSolid(2.0f, 20.0f).noCollission(), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> ENDER_GATE = new VarReg<>(DR, "ender_gate",
            variant -> new EnderGateBlock(Properties.metalNoSolid(2.0f, 20.0f).noCollission(), variant), Tier.getNormalVariants());
    public static final DeferredBlock<Block> ENERGIZING_ORB = DR.register("energizing_orb",
            () -> new EnergizingOrbBlock(Properties.metalNoSolid(2.0f, 20.0f)));
    public static final VarReg<Tier, Block> ENERGIZING_ROD = new VarReg<>(DR, "energizing_rod",
            variant -> new EnergizingRodBlock(Properties.metalNoSolid(2.0f, 20.0f).noCollission(), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> FURNATOR = new VarReg<>(DR, "furnator",
            variant -> new FurnatorBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> MAGMATOR = new VarReg<>(DR, "magmator",
            variant -> new MagmatorBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> THERMO_GENERATOR = new VarReg<>(DR, "thermo_generator",
            variant -> new ThermoBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> SOLAR_PANEL = new VarReg<>(DR, "solar_panel",
            variant -> new SolarBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> REACTOR = new VarReg<>(DR, "reactor",
            variant -> new ReactorBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> PLAYER_TRANSMITTER = new VarReg<>(DR, "player_transmitter",
            variant -> new PlayerTransmitterBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> ENERGY_HOPPER = new VarReg<>(DR, "energy_hopper",
            variant -> new EnergyHopperBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final VarReg<Tier, Block> ENERGY_DISCHARGER = new VarReg<>(DR, "energy_discharger",
            variant -> new EnergyDischargerBlock(Properties.metalNoSolid(2.0f, 20.0f), variant), Tier.getNormalVariants());
    public static final DeferredBlock<Block> ENERGIZED_STEEL = DR.register("energized_steel_block", () -> new Block(Properties.metal(2.0f, 20.0f)));
    public static final DeferredBlock<Block> BLAZING_CRYSTAL = DR.register("blazing_crystal_block", () -> new Block(Properties.metal(2.0f, 20.0f)));
    public static final DeferredBlock<Block> NIOTIC_CRYSTAL = DR.register("niotic_crystal_block", () -> new Block(Properties.metal(2.0f, 20.0f)));
    public static final DeferredBlock<Block> SPIRITED_CRYSTAL = DR.register("spirited_crystal_block", () -> new Block(Properties.metal(2.0f, 20.0f)));
    public static final DeferredBlock<Block> NITRO_CRYSTAL = DR.register("nitro_crystal_block", () -> new Block(Properties.metal(2.0f, 20.0f)));
    public static final DeferredBlock<Block> URANINITE = DR.register("uraninite_block", () -> new Block(Properties.metal(2.0f, 20.0f)));
    public static final DeferredBlock<Block> DEEPSLATE_URANINITE_ORE_POOR = DR.register("deepslate_uraninite_ore_poor",
            () -> new DropExperienceBlock(ConstantInt.of(0), Properties.deepslate()));
    public static final DeferredBlock<Block> DEEPSLATE_URANINITE_ORE = DR.register("deepslate_uraninite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), Properties.deepslate()));
    public static final DeferredBlock<Block> DEEPSLATE_URANINITE_ORE_DENSE = DR.register("deepslate_uraninite_ore_dense",
            () -> new DropExperienceBlock(ConstantInt.of(0), Properties.deepslate()));
    public static final DeferredBlock<Block> URANINITE_ORE_POOR = DR.register("uraninite_ore_poor",
            () -> new DropExperienceBlock(ConstantInt.of(0), Properties.rock(3.0f, 8.0f)));
    public static final DeferredBlock<Block> URANINITE_ORE = DR.register("uraninite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), Properties.rock(3.2f, 8.0f)));
    public static final DeferredBlock<Block> URANINITE_ORE_DENSE = DR.register("uraninite_ore_dense",
            () -> new DropExperienceBlock(ConstantInt.of(0), Properties.rock(4.0f, 8.0f)));
    public static final DeferredBlock<Block> DRY_ICE = DR.register("dry_ice", () -> new Block(Properties.rock(2.0f, 8.0f)));
}
