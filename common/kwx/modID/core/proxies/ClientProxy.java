package kwx.modID.core.proxies;

import com.jadarstudios.developercapes.DevCapesUtil;

public class ClientProxy extends CommonProxy {

	@Override
    public void registerRenderers() {
		DevCapesUtil.addFileUrl("GETTINGAURL");
	}
}
