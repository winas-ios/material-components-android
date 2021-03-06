/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.material.transition;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * A {@link androidx.transition.Visibility} transition that is composed of a fade and scale of
 * incoming content and a simple fade of outgoing content.
 */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {

  private static final long DEFAULT_DURATION_ENTER = 150;
  private static final long DEFAULT_DURATION_RETURN = 75;
  private static final float DEFAULT_START_SCALE = 0.8f;
  private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;

  public MaterialFade() {
    this(true);
  }

  public MaterialFade(boolean entering) {
    setDuration(entering ? DEFAULT_DURATION_ENTER : DEFAULT_DURATION_RETURN);
  }

  @NonNull
  @Override
  FadeProvider getDefaultPrimaryAnimatorProvider() {
    FadeProvider fadeProvider = new FadeProvider();
    fadeProvider.setIncomingEndThreshold(DEFAULT_FADE_END_THRESHOLD_ENTER);
    return fadeProvider;
  }

  @Nullable
  @Override
  VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider() {
    ScaleProvider scaleProvider = new ScaleProvider();
    scaleProvider.setScaleOnDisappear(false);
    scaleProvider.setIncomingStartScale(DEFAULT_START_SCALE);
    return scaleProvider;
  }
}
