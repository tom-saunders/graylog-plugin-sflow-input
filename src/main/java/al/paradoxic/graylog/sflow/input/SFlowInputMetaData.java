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

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * Implement the PluginMetaData interface here.
 */
public class SFlowInputMetaData implements PluginMetaData {
    @Override
    public String getUniqueId() {
        return "al.paradoxic.graylog.sflow.input.SFlowInputPlugin";
    }

    @Override
    public String getName() {
        return "SFlowInput";
    }

    @Override
    public String getAuthor() {
        return "Tom Saunders";
    }

    @Override
    public URI getURL() {
        return URI.create("https://github.com/tom-saunders/graylog-plugin-sflow-input/");
    }

    @Override
    public Version getVersion() {
        return new Version(1, 0, 0);
    }

    @Override
    public String getDescription() {
        return "sFlow input plugin";
    }

    @Override
    public Version getRequiredVersion() {
        return new Version(2, 0, 0);
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
