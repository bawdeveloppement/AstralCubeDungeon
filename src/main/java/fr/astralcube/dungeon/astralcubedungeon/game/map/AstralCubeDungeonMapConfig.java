package fr.astralcube.dungeon.astralcubedungeon.game.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;

public class AstralCubeDungeonMapConfig {
    public static final Codec<AstralCubeDungeonMapConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockState.CODEC.fieldOf("spawn_block").forGetter(map -> map.spawnBlock)
    ).apply(instance, AstralCubeDungeonMapConfig::new));

    public final BlockState spawnBlock;

    public AstralCubeDungeonMapConfig(BlockState spawnBlock) {
        this.spawnBlock = spawnBlock;
    }
}
