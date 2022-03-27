package fr.astralcube.dungeon.astralcubedungeon;

import net.fabricmc.api.ModInitializer;
import xyz.nucleoid.plasmid.game.GameType;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.astralcube.dungeon.astralcubedungeon.game.AstralCubeDungeonConfig;
import fr.astralcube.dungeon.astralcubedungeon.game.AstralCubeDungeonWaiting;

public class AstralCubeDungeon implements ModInitializer {

    public static final String ID = "astralcubedungeon";
    public static final Logger LOGGER = LogManager.getLogger(ID);

    public static final GameType<AstralCubeDungeonConfig> TYPE = GameType.register(
            new Identifier(ID, "standard"),
            AstralCubeDungeonConfig.CODEC,
            AstralCubeDungeonWaiting::open
    );

    @Override
    public void onInitialize() {}
}
