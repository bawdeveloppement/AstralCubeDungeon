package fr.astralcube.dungeon.astralcubedungeon.game;

import net.minecraft.entity.boss.BossBar;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import xyz.nucleoid.plasmid.game.common.GlobalWidgets;
import xyz.nucleoid.plasmid.game.common.widget.BossBarWidget;

public final class AstralCubeDungeonTimerBar {
    private final BossBarWidget widget;

    public AstralCubeDungeonTimerBar(GlobalWidgets widgets) {
        LiteralText title = new LiteralText("Waiting for the game to start...");
        this.widget = widgets.addBossBar(title, BossBar.Color.GREEN, BossBar.Style.NOTCHED_10);
    }

    public void update(long ticksUntilEnd, long totalTicksUntilEnd) {
        if (ticksUntilEnd % 20 == 0) {
            this.widget.setTitle(this.getText(ticksUntilEnd));
            this.widget.setProgress((float) ticksUntilEnd / totalTicksUntilEnd);
        }
    }

    private Text getText(long ticksUntilEnd) {
        long secondsUntilEnd = ticksUntilEnd / 20;

        long minutes = secondsUntilEnd / 60;
        long seconds = secondsUntilEnd % 60;
        String time = String.format("%02d:%02d left", minutes, seconds);

        return new LiteralText(time);
    }
}
