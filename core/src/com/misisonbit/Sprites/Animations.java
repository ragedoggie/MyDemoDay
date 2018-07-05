package com.misisonbit.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animations {
    Array<TextureRegion> frames; //where we store all of our frames
    float maxFrameTime; //this determines how long a frame needs to stay in view before switching to the next one
    float currentFrameTime; //how long the animation has been in the current frame
    int frameCount; //number of frames in our animation
    int frame; //the current frame we're in




    public Animations(TextureRegion region, int frameCount, float cycleTime,int rows,int columns){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / columns;
        int frameHeight = region.getRegionHeight() / rows;
        for(int r = 0; r < rows; r++){
            for(int c = 0;c < columns;c ++) {
                frames.add(new TextureRegion(region, c * frameWidth, r * frameHeight, frameWidth, frameHeight));
            }

        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount)
            frame = 0;
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

}
