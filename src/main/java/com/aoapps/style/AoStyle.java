/*
 * ao-style - Set of base CSS styles shared by multiple projects.
 * Copyright (C) 2020, 2021, 2022  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-style.
 *
 * ao-style is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-style is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-style.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoapps.style;

import com.aoapps.web.resources.registry.Group;
import com.aoapps.web.resources.registry.Style;
import com.aoapps.web.resources.servlet.RegistryEE;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Registers the style in RegistryEE.")
public class AoStyle implements ServletContextListener {

  public static final Group.Name RESOURCE_GROUP = new Group.Name("ao-style");

  // TODO: Change to Group.Name once we have group-level ordering
  public static final Style AO_STYLE = new Style("/ao-style/ao-style.css");

  @Override
  public void contextInitialized(ServletContextEvent event) {
    // Add our CSS file
    RegistryEE.Application.get(event.getServletContext())
      .activate(RESOURCE_GROUP) // TODO: Activate as-needed?
      .getGroup(RESOURCE_GROUP)
      .styles
      .add(AO_STYLE);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    // Do nothing
  }
}
