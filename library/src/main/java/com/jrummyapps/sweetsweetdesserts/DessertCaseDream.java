/*
 * Copyright (C) 2017 JRummy Apps Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jrummyapps.sweetsweetdesserts;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.dreams.DreamService;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class DessertCaseDream extends DreamService {

  DessertCaseView dessertCaseView;

  @Override public void onAttachedToWindow() {
    super.onAttachedToWindow();
    setInteractive(false);
    dessertCaseView = new DessertCaseView(this);
    DessertCaseView.RescalingContainer rescalingContainer = new DessertCaseView.RescalingContainer(this);
    rescalingContainer.setView(dessertCaseView);
    setContentView(rescalingContainer);
  }

  @Override public void onDreamingStarted() {
    super.onDreamingStarted();
    dessertCaseView.postDelayed(new Runnable() {

      @Override public void run() {
        dessertCaseView.start();
      }
    }, 1000);
  }

  @Override public void onDreamingStopped() {
    super.onDreamingStopped();
    dessertCaseView.stop();
  }

}