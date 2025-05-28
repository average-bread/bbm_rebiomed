package cursedbread.bbmr.entities;

import cursedbread.bbmr.BBMRMain;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;

public class BBMREntities {
	public static int entityId;

	public void initilizeEntities(){
		EntityHelper.createEntity(EntitySteve.class, NamespaceID.getPermanent(BBMRMain.MOD_ID, "steve"), "entity.bbmr.steve");
	}
}
