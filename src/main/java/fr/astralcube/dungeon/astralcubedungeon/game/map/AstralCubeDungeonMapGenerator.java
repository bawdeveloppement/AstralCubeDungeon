package fr.astralcube.dungeon.astralcubedungeon.game.map;

import xyz.nucleoid.map_templates.MapTemplate;
import net.minecraft.util.math.BlockPos;

public class AstralCubeDungeonMapGenerator {

    private final AstralCubeDungeonMapConfig config;

    public AstralCubeDungeonMapGenerator(AstralCubeDungeonMapConfig config) {
        this.config = config;
    }

    public AstralCubeDungeonMap build() {
        MapTemplate template = MapTemplate.createEmpty();
        AstralCubeDungeonMap map = new AstralCubeDungeonMap(template, this.config);

        this.buildSpawn(template);
        map.spawn = new BlockPos(0,65,0);

        return map;
    }

    private void buildSpawn(MapTemplate builder) {
        BlockPos min = new BlockPos(-5, 64, -5);
        BlockPos max = new BlockPos(5, 64, 5);

        for (BlockPos pos : BlockPos.iterate(min, max)) {
            builder.setBlockState(pos, this.config.spawnBlock);
        }
    }
}
