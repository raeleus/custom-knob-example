package com.ray3k.customknobexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Core extends ApplicationAdapter {
    private Skin skin;
    private Stage stage;

    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal("custom-knob-example.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);
        
        root.defaults().space(20);
        Slider slider = new Slider(0, 100, 1, false, skin);
        root.add(slider);
        
        slider = new Slider(0, 100, 1, true, skin);
        root.add(slider);
        
        root.row();
        Table table = new Table();
        root.add(table).colspan(2);
        
        table.defaults().space(20);
        Image image = new Image(skin, "knob-drawable-horizontal");
        table.add(image).minSize(100);
        
        image = new Image(skin, "knob-drawable-vertical");
        table.add(image).minSize(100);
        
        root.row();
        table = new Table();
        root.add(table).colspan(2);
        
        table.defaults().space(20);
        image = new Image(skin, "knob-drawable-horizontal");
        table.add(image).minSize(50, 100);
        
        image = new Image(skin, "knob-drawable-horizontal");
        table.add(image).minSize(100, 50);
        
        image = new Image(skin, "knob-drawable-vertical");
        table.add(image).minSize(50, 100);
        
        image = new Image(skin, "knob-drawable-vertical");
        table.add(image).minSize(100, 50);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.5f, .5f, .5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        skin.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
