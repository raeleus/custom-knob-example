/*
 * The MIT License
 *
 * Copyright 2018 Raymond Buckley.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ray3k.customknobexample;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 *
 * @author Raymond
 */
public class KnobDrawable extends BaseDrawable {
    private Drawable knob;
    private Drawable bg;
    private boolean stretchHorizontally;

    public KnobDrawable() {
        stretchHorizontally = true;
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        float leftWidth = 0;
        float rightWidth = 0;
        float bottomHeight = 0;
        float topHeight = 0;
        
        if (bg != null) {
            bg.draw(batch, x, y, width, height);
            
            leftWidth = bg.getLeftWidth();
            rightWidth = bg.getRightWidth();
            bottomHeight = bg.getBottomHeight();
            topHeight = bg.getTopHeight();
        }
        
        if (knob != null) {
            if (stretchHorizontally) {
                float knobWidth = width - leftWidth - rightWidth;
                float knobHeight = knob.getMinHeight();
                float xOffset = x + leftWidth;
                float yOffset = y + height / 2 - knobHeight / 2;
                knob.draw(batch, MathUtils.round(xOffset), MathUtils.round(yOffset), MathUtils.round(knobWidth), MathUtils.round(knobHeight));
            } else {
                float knobWidth = knob.getMinWidth();
                float knobHeight = height - bottomHeight - topHeight;
                float xOffset = x + width / 2 - knobWidth / 2;
                float yOffset = y + bottomHeight;
                knob.draw(batch, MathUtils.round(xOffset), MathUtils.round(yOffset), MathUtils.round(knobWidth), MathUtils.round(knobHeight));
            }
        }
    }

    public Drawable getKnob() {
        return knob;
    }

    public void setKnob(Drawable knob) {
        this.knob = knob;
    }

    public Drawable getBg() {
        return bg;
    }

    public void setBg(Drawable bg) {
        this.bg = bg;
    }

    public boolean isStretchHorizontally() {
        return stretchHorizontally;
    }

    public void setStretchHorizontally(boolean stretchHorizontally) {
        this.stretchHorizontally = stretchHorizontally;
    }
    
    @Override
    public float getMinHeight() {
        float returnValue = super.getMinHeight();
        
        if (bg != null) {
            returnValue = Math.max(returnValue, bg.getMinHeight());
        }
        
        if (knob != null) {
            returnValue = Math.max(returnValue, knob.getMinHeight());
        }
        
        return returnValue;
    }

    @Override
    public float getMinWidth() {
        float returnValue = super.getMinWidth();
        
        if (bg != null) {
            returnValue = Math.max(returnValue, bg.getMinWidth());
        }
        
        if (knob != null) {
            returnValue = Math.max(returnValue, knob.getMinWidth());
        }
        
        return returnValue;
    }
}
