/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the BSD 2-Clause License (http://opensource.org/licenses/BSD-2-Clause)
 * See accompanying file LICENSE
 */

package naftoreiclag.dontdigleft.transformer;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.*;

public class ResizePlayerBoudingBox implements IClassTransformer
{
	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass)
	{
		if(name.equals("net.minecraft.entity.player.EntityPlayer") || name.equals("xl"))
		{
			ClassNode classNode = new ClassNode();
			ClassReader classReader = new ClassReader(basicClass);
			
			classReader.accept(classNode, 0);
			
			MethodNode mv = new MethodNode(ASM4, ACC_PROTECTED, "setSize", "(FF)V", null, null);

			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitVarInsn(FLOAD, 1);
			mv.visitLdcInsn(new Float("0.6"));
			mv.visitInsn(FCMPL);
			Label l1 = new Label();
			mv.visitJumpInsn(IFNE, l1);
			mv.visitVarInsn(FLOAD, 2);
			mv.visitLdcInsn(new Float("1.8"));
			mv.visitInsn(FCMPL);
			mv.visitJumpInsn(IFNE, l1);
			Label l2 = new Label();
			mv.visitLabel(l2);
			mv.visitLdcInsn(new Float("0.6"));
			mv.visitVarInsn(FSTORE, 1);
			Label l3 = new Label();
			mv.visitLabel(l3);
			mv.visitLdcInsn(new Float("0.6"));
			mv.visitVarInsn(FSTORE, 2);
			mv.visitLabel(l1);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(FLOAD, 1);
			mv.visitVarInsn(FLOAD, 2);
			mv.visitMethodInsn(INVOKESPECIAL, "net/minecraft/entity/Entity", "setSize", "(FF)V");
			Label l4 = new Label();
			mv.visitLabel(l4);
			mv.visitInsn(RETURN);
			Label l5 = new Label();
			mv.visitLabel(l5);
			mv.visitLocalVariable("this", "Lnet/minecraft/entity/player/EntityPlayer;", null, l0, l5, 0);
			mv.visitLocalVariable("par1", "F", null, l0, l5, 1);
			mv.visitLocalVariable("par2", "F", null, l0, l5, 2);
			mv.visitMaxs(3, 3);
			mv.visitEnd();
			
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			classNode.accept(cw);
			mv.accept(cw);
			
			return cw.toByteArray();
		}
		else
		{
			return basicClass;
		}
	}
	
	/*
	protected void setSize(float par1, float par2)
    {
		if(par1 == 0.6f && par2 == 1.8f)
		{
			par1 = 0.6f;
			par2 = 0.6f;
		}
		
		super.setSize(par1, par2);
    }
	*/
}
