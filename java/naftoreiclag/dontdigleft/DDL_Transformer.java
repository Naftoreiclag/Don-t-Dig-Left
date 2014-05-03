/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the BSD 2-Clause License (http://opensource.org/licenses/BSD-2-Clause)
 * See accompanying file LICENSE
 */

package naftoreiclag.dontdigleft;

import java.util.ArrayList;
import java.util.List;

import naftoreiclag.dontdigleft.transformer.ResizePlayerBoudingBox;
import net.minecraft.launchwrapper.IClassTransformer;

public class DDL_Transformer implements IClassTransformer
{
	public static DDL_Transformer instance;
	public static List<IClassTransformer> transformers = new ArrayList<IClassTransformer>();
	
	protected boolean isObf;
	
	public DDL_Transformer()
	{
		if(instance != null)
		{
			throw new RuntimeException("Error: Trying to instiantate multiple singletons for DDL_Transformer!");
		}
		else
		{
			transformers.add(new ResizePlayerBoudingBox());
			instance = this;
		}
	}

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass)
	{
		for(IClassTransformer transformer : transformers)
		{
			basicClass = transformer.transform(name, transformedName, basicClass);
		}
		
		return basicClass;
	}
}
