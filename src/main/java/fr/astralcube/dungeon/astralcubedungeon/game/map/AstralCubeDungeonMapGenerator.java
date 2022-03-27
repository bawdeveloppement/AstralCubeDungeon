package fr.astralcube.dungeon.astralcubedungeon.game.map;

import xyz.nucleoid.map_templates.MapTemplate;
import xyz.nucleoid.map_templates.MapTemplateSerializer;
import xyz.nucleoid.plasmid.game.GameOpenException;

import java.io.IOException;

import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralText;

public class AstralCubeDungeonMapGenerator {

    private final AstralCubeDungeonMapConfig config;

    public AstralCubeDungeonMapGenerator(AstralCubeDungeonMapConfig config) {
        this.config = config;
    }

    public AstralCubeDungeonMap build(MinecraftServer server) {
        MapTemplate template = this.loadFromConfig(server);
        AstralCubeDungeonMap map = new AstralCubeDungeonMap(template, this.config);
        
        this.buildSpawn(template);
        return map;
    }

    private void buildSpawn(MapTemplate builder) {
    }

    public MapTemplate loadFromConfig (MinecraftServer server) {
        try {
            MapTemplate mapTemplate = MapTemplateSerializer.loadFromResource(server, this.config.mapTemplateId);
            return mapTemplate;
        }
		catch(IOException e) {
			throw new GameOpenException(new LiteralText("Failed to load map template"), e);
		}
    }
}
