/*package kittehmod.ceilands.worldgen.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;

public class CeilandsChunkGenerator extends NoiseBasedChunkGenerator
{

    public static final Codec<CeilandsChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RegistryOps.retrieveRegistry(Registry.STRUCTURE_SET_REGISTRY).forGetter(ceilandsChunkGenerator -> ceilandsChunkGenerator.structureSets),
            RegistryOps.retrieveRegistry(Registry.NOISE_REGISTRY).forGetter(ceilandsChunkGenerator -> ceilandsChunkGenerator.noises),
            RegistryOps.retrieveRegistry(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY).forGetter(ceilandsChunkGenerator -> ceilandsChunkGenerator.settingsRegistry),
            BiomeSource.CODEC.fieldOf("biome_source").forGetter(ceilandsChunkGenerator -> ceilandsChunkGenerator.biomeSource),
            NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter(ceilandsChunkGenerator -> ceilandsChunkGenerator.settings),
            RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((ceilandsChunkGenerator) -> ceilandsChunkGenerator.biomeRegistry))
    .apply(instance, instance.stable(CeilandsChunkGenerator::new)));

    protected final BlockState defaultBlock;
    protected final BlockState defaultFluid;
    private final Registry<NormalNoise.NoiseParameters> noises;
    private final Registry<NoiseGeneratorSettings> settingsRegistry;
    private final Holder<NoiseGeneratorSettings> settings;
    private final Registry<Biome> biomeRegistry;
    private final Aquifer.FluidPicker globalFluidPicker;
	
	public CeilandsChunkGenerator(Registry<StructureSet> structureSetRegistry, Registry<NormalNoise.NoiseParameters> noises, Registry<NoiseGeneratorSettings> settingsRegistry, BiomeSource biomeSource,  Holder<NoiseGeneratorSettings> supplier, Registry<Biome> biomeRegistry) {
		super(structureSetRegistry, noises, biomeSource, supplier);
        this.noises = noises;
        this.biomeRegistry = biomeRegistry;
        this.settingsRegistry = settingsRegistry;
        NoiseGeneratorSettings noiseGeneratorSettings = supplier.value();
        this.defaultBlock = noiseGeneratorSettings.defaultBlock();
        this.defaultFluid = noiseGeneratorSettings.defaultFluid();
        NoiseRouter noiseRouter = noiseGeneratorSettings.noiseRouter();

        BiomeNoise.biomeRegistry = this.biomeRegistry;
        BiomeNoise.biomeSource = this.getBiomeSource();
        BiomeNoise.sampler = new Climate.Sampler(
                noiseRouter.temperature(),
                noiseRouter.vegetation(),
                noiseRouter.continents(),
                noiseRouter.erosion(),
                noiseRouter.depth(),
                noiseRouter.ridges(),
                noiseGeneratorSettings.spawnTarget());

        this.settings = supplier;

        int seaLevel = noiseGeneratorSettings.seaLevel();
        Aquifer.FluidStatus sea = new Aquifer.FluidStatus(seaLevel, noiseGeneratorSettings.defaultFluid());
        this.globalFluidPicker = (x, y, z) -> sea;
	}

    public record BiomeNoise() implements DensityFunction.SimpleFunction {
        public static final KeyDispatchDataCodec<BiomeNoise> CODEC = KeyDispatchDataCodec.of(MapCodec.unit(new BiomeNoise()));
        public static Climate.Sampler sampler;
        public static Registry<Biome> biomeRegistry;
        public static BiomeSource biomeSource;

        @Override
        public double compute(FunctionContext functionContext) {
            return BiomeInfluencedNoiseSampler.calculateBaseNoise(
                    functionContext.blockX(),
                    functionContext.blockZ(),
                    sampler,
                    biomeSource,
                    biomeRegistry);
        }

        @Override
        public double minValue() {
            return -10;
        }

        @Override
        public double maxValue() {
            return 10;
        }

        @Override
        public KeyDispatchDataCodec<? extends DensityFunction> codec() {
            return CODEC;
        }
    }
	
}*/
