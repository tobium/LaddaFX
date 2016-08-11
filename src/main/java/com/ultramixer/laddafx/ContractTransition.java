/*
 * Copyright (c) 2015 Tobias Bley, UltraMixer Digital Audio Solutions (www.ultramixer.com)
 */

package com.ultramixer.laddafx;

import javafx.animation.Transition;
import javafx.util.Duration;

/**
 * Created by TB on 01.06.15.
 */
public class ContractTransition extends Transition
{
    private final double originalWidth;
    private LaddaButton button;

    public ContractTransition(LaddaButton button)
    {
        this.button = button;
        this.setCycleDuration(Duration.millis(2000));
        this.setCycleCount(1);
        originalWidth = button.getPrefWidth();
    }

    @Override
    protected void interpolate(double frac)
    {
        int pi = 24 + 20;
        int radius = (int) (pi * frac);
        int w = (int) ((originalWidth-pi)* (1-frac)) + pi;
        String css = String.format("-fx-pref-width: %dpx;-fx-padding: 10;-fx-background-radius: %dpx;", w,radius);
        button.setStyle(css);
    }
}
