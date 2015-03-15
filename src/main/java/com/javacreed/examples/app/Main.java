/*
 * #%L
 * Simple Java Database Swing Application - Part 11 - Integration
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
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
 * #L%
 */
package com.javacreed.examples.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  public static void main(final String[] args) {
    DbHelper.getInstance().init();
    DbHelper.getInstance().registerShutdownHook();

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        Main.LOGGER.debug("Starting application");

        final Application app = new Application();
        app.setTitle("Simple Java Database Swing Application");
        app.setSize(800, 600);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
      }
    });
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
}
