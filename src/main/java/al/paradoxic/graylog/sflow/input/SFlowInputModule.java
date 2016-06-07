/**
 * (C) Copyright 2016
 *
 * This file is part of sflow-input - A Graylog sFlow input plugin.
 *
 * sflow-input is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * sflow-input is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with sflow-input.  If not, see <http://www.gnu.org/licenses/>.
 */
package al.paradoxic.graylog.sflow.input;

import org.graylog2.plugin.PluginConfigBean;
import org.graylog2.plugin.PluginModule;

import al.paradoxic.graylog.sflow.input.codec.SFlowCodec;

import java.util.Collections;
import java.util.Set;

/**
 * Extend the PluginModule abstract class here to add you plugin to the system.
 */
public class SFlowInputModule extends PluginModule {
    /**
     * Returns all configuration beans required by this plugin.
     *
     * Implementing this method is optional. The default method returns an empty {@link Set}.
     */
    @Override
    public Set<? extends PluginConfigBean> getConfigBeans() {
        return Collections.emptySet();
    }

    @Override
    protected void configure() {
        addMessageInput(SFlowInput.class);
        addCodec("sFlow", SFlowCodec.class);
    }
}
