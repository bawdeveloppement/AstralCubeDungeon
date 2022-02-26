package fr.astralcube.dungeon.astralcubedungeon.game.map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import xyz.nucleoid.map_templates.MapTemplate;
import xyz.nucleoid.plasmid.game.world.generator.TemplateChunkGenerator;

public class AstralCubeDungeonMap {
    private final MapTemplate template;
    private final AstralCubeDungeonMapConfig config;
    public BlockPos spawn;

    public AstralCubeDungeonMap(MapTemplate template, AstralCubeDungeonMapConfig config) {
        this.template = template;
        this.config = config;
    }

    public ChunkGenerator asGenerator(MinecraftServer server) {
        return new TemplateChunkGenerator(server, this.template);
    }
}
