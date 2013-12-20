package kwx.tek.core.proxies;

import com.jadarstudios.developercapes.DevCapesUtil;

public class ClientProxy extends CommonProxy {

	@Override
    public void registerRenderers() {
		DevCapesUtil.addFileUrl("https://raw.github.com/Wehavecookies56/Mod-Source/master/capes.txt");
	}
}
