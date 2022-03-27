package fr.astralcube.dungeon.astralcubedungeon.game.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;

public class AstralCubeDungeonMapConfig {
    public static final Codec<AstralCubeDungeonMapConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        BlockState.CODEC.fieldOf("spawn_block").forGetter(map -> map.spawnBlock),
        Identifier.CODEC.fieldOf("map_template_id").forGetter(map -> map.mapTemplateId)
    ).apply(instance, AstralCubeDungeonMapConfig::new));

    public final BlockState spawnBlock;
    public final Identifier mapTemplateId;

    public AstralCubeDungeonMapConfig(BlockState spawnBlock, Identifier mapTemplateId) {
        this.spawnBlock = spawnBlock;
        this.mapTemplateId = mapTemplateId;
    }
}
