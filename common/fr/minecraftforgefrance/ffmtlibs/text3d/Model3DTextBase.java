package fr.minecraftforgefrance.ffmtlibs.text3d;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public abstract class Model3DTextBase extends ModelBase
{
    public abstract void renderChar(char ch, float scale, float x);

    public void renderAll(ModelRenderer[] renders, float scale, float x)
    {
        if(renders != null && renders.length > 0)
        {
            for(ModelRenderer render : renders)
            {
                render.rotateAngleZ = (float)Math.PI;
                render.offsetX += x;
                render.render(scale);
                render.offsetX -= x;
            }
        }
    }
}