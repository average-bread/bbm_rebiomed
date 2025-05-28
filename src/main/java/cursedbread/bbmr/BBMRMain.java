package cursedbread.bbmr;

import cursedbread.bbmr.biomes.BBMRBiomes;
import cursedbread.bbmr.blocks.BBMRBlocks;
import cursedbread.bbmr.entities.BBMREntities;
import cursedbread.bbmr.items.BBMRItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class BBMRMain implements ModInitializer, GameStartEntrypoint, ClientModInitializer {
    public static final String MOD_ID = "bbmr";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","2200");
		prop.setProperty("starting_item_id","17890");
		//prop.setProperty("starting_entity_id","634");

		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		BBMRBlocks.blockId = config.getInt("starting_block_id");
		BBMRItems.itemId = config.getInt("starting_item_id");
		//BBMREntities.entityId = config.getInt("starting_entity_id");
	}

	@Override
	public void onInitialize() {
		LOGGER.info("New Biomes");
		new BBMRBlocks().initilizeBlocks();
		new BBMRItems().initilizeItems();
		new BBMRBiomes().initilixeBiomes();
		//new BBMREntities().initilizeEntities();
	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onInitializeClient() {
		new BBMRModels();
	}
}
