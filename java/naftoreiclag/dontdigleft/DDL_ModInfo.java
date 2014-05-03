/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the BSD 2-Clause License (http://opensource.org/licenses/BSD-2-Clause)
 * See accompanying file LICENSE
 */

package naftoreiclag.dontdigleft;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

public class DDL_ModInfo extends DummyModContainer
{
	public DDL_ModInfo()
	{
		super(new ModMetadata());
		ModMetadata myMeta = super.getMetadata();
		myMeta.modId = "dontdigleft";
		myMeta.name = "Don't Dig Left";
		myMeta.description = "Description goes here!";
		myMeta.version = "0.1.0";
		myMeta.url = "Url goes here!";
		myMeta.authorList = Arrays.asList("Naftoreiclag");
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}
}
