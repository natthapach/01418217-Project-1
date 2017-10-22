package models;

import java.awt.Color;

public enum ColorLib {
	EARTH_LAND_GREEAN(Color.green, "Earth : Green Land"),
	EARTH_LAND_BROWN(Color.decode("#b54806"), "Earth : Brown Land"),
	EARTH_OCEAN_BLUE(Color.blue, "Earth : Blue ocean"),
	EARTH_OCEAN_LIGHT_BLUE(Color.decode("#300c6ff"), "Earth : Light bule ocean"),
	CLOUD_LIGHT_TONE(Color.decode("#43ccff"), "Cloud : Light tone"),
	CLOUD_DARK_TONE(Color.decode("#36a2ed"), "Cloud : Dark tone"),
	ISLAND_MID_TONE_LAND(Color.decode("#fee0af"), "Island : Mid tone land"),
	ISLAND_DARK_TONE_LAND(Color.decode("#ffc26f"), "Island : Dark tone land"),
	ISLAND_LIGHT_TONE_LAND(Color.decode("#f9f3d6"), "Island : Light tone land"),
	ISLAND_MID_TONE_TREE(Color.decode("#cb7941"), "Island : Mid tone tree"),
	ISLAND_DARK_TONE_TREE(Color.decode("#964722"), "Island : Dark tone tree"),
	ISLAND_LIGHT_TONE_LEAF(Color.decode("#99cf3e"), "Island : Light tone leaf"),
	ISLAND_DARK_TONE_LEAF(Color.decode("#62a44d"), "Island : Dark tone leaf"),
	ISLAND_LIGHT_TONE_OCEAN(Color.decode("#3ec4f0"), "Island : Light tone ocean"),
	MOUNTAIN_DARK_BROWN(Color.decode("#974700"), "Mountain : Dark brown"),
	MOUNTAIN_DARK_WHITE(Color.decode("#79e1ff"), "Mountain : Dark white"),
	MOUNTAIN_LIGHT_BROWN(Color.decode("#da6e0f"), "Mountain : Light brown"),
	MOUNTAIN_LIGHT_WHITE(Color.decode("#d9f7ff"), "Mountain : Lght white");
	
	public final Color color;
	public final String name;
	
	private ColorLib(Color color, String name){
		this.color = color;
		this.name = name;
	}
	@Override
	public String toString(){
		return this.name;
	}
	public static ColorLib[] getMountainColors(){
		return new ColorLib[] {
			MOUNTAIN_DARK_BROWN,
			MOUNTAIN_DARK_WHITE,
			MOUNTAIN_LIGHT_BROWN,
			MOUNTAIN_LIGHT_WHITE
		};
	}
	public static ColorLib[] getIslandColors(){
		return new ColorLib[]{
				ISLAND_DARK_TONE_LAND,
				ISLAND_MID_TONE_LAND,
				ISLAND_LIGHT_TONE_LAND,
				ISLAND_DARK_TONE_LEAF,
				ISLAND_LIGHT_TONE_LEAF,
				ISLAND_DARK_TONE_TREE,
				ISLAND_MID_TONE_TREE,
				ISLAND_LIGHT_TONE_OCEAN
		};
	}
	public static ColorLib[] getCloundColors(){
		return new ColorLib[]{
				CLOUD_DARK_TONE, CLOUD_LIGHT_TONE
		};
	}
	
}
