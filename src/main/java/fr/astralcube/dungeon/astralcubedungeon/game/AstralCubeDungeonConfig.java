package fr.astralcube.dungeon.astralcubedungeon.game;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.astralcube.dungeon.astralcubedungeon.game.map.AstralCubeDungeonMapConfig;
import xyz.nucleoid.plasmid.game.common.config.PlayerConfig;

public class AstralCubeDungeonConfig {
    public static final Codec<AstralCubeDungeonConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            PlayerConfig.CODEC.fieldOf("players").forGetter(config -> config.playerConfig),
            AstralCubeDungeonMapConfig.CODEC.fieldOf("map").forGetter(config -> config.mapConfig),
            Codec.INT.fieldOf("time_limit_min").forGetter(config -> config.timeLimitMin)
    ).apply(instance, AstralCubeDungeonConfig::new));

    public final PlayerConfig playerConfig;
    public final AstralCubeDungeonMapConfig mapConfig;
    public final int timeLimitMin;

    public AstralCubeDungeonConfig(PlayerConfig players, AstralCubeDungeonMapConfig mapConfig, int timeLimitMin) {
        this.playerConfig = players;
        this.mapConfig = mapConfig;
        this.timeLimitMin = timeLimitMin;
    }
}
