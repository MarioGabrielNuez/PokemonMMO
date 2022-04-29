package model;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import model.pokemones.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends Canvas {

    private static final long serialVersionUID = 1L;

    ArrayList<Pokemon> pokeBuffer = new ArrayList<>();
    ArrayList<Image> tiles = new ArrayList<>();
    Image actualTile;
    File playerSprites;

    public ArrayList<Pokemon> getPokeBuffer() {
        return pokeBuffer;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokeBuffer.add(pokemon);
    }

    public File getPlayerSprites() {
        return playerSprites;
    }

    public void setPlayerSprites(File playerSprites) {
        this.playerSprites = playerSprites;
    }

    public Image getPlayerTile() {
        return actualTile;
    }

    public void setPlayerTile(Image playerSpriteFront) {
        this.actualTile = playerSpriteFront;
    }

    public void addAllTiles(ArrayList<Image> tiles) {
        this.tiles.addAll(tiles);
    }

    public ArrayList<Image> getTileBuffer() {
        return tiles;
    }
}