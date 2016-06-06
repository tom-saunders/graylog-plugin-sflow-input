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

import org.graylog2.plugin.Plugin;
import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.PluginModule;

import java.util.Collection;
import java.util.Collections;

/**
 * Implement the Plugin interface here.
 */
public class SFlowInputPlugin implements Plugin {
    @Override
    public PluginMetaData metadata() {
        return new SFlowInputMetaData();
    }

    @Override
    public Collection<PluginModule> modules () {
        return Collections.<PluginModule>singletonList(new SFlowInputModule());
    }
}
