/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the BSD 2-Clause License (http://opensource.org/licenses/BSD-2-Clause)
 * See accompanying file LICENSE
 */

package naftoreiclag.dontdigleft;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class DDL_Plugin implements IFMLLoadingPlugin, IFMLCallHook
{
	@Override
	public String[] getASMTransformerClass()
	{
		return new String[] { DDL_Transformer.class.getName() };
	}

	@Override
	public String getSetupClass()
	{
		return DDL_Plugin.class.getName();
	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}

	@Override
	public String getModContainerClass()
	{
		return DDL_ModInfo.class.getName();
	}

	@Override
	public void injectData(Map<String, Object> data)
	{
		Object o = (Boolean) data.get("runtimeDeobfuscationEnabled");
		if(o != null)
		{
			DDL_Transformer.instance.isObf = (Boolean) o;
		}
		
	}

	@Override
	public Void call()
	{
		return null;
	}
}
