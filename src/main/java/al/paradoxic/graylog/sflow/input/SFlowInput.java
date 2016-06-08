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

import al.paradoxic.graylog.sflow.input.codec.SFlowCodec;
import com.codahale.metrics.MetricRegistry;
import com.google.inject.assistedinject.Assisted;

import org.graylog2.inputs.transports.UdpTransport;
import org.graylog2.plugin.LocalMetricRegistry;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.inputs.MessageInput;
import org.graylog2.plugin.inputs.codecs.Codec;
import org.graylog2.plugin.inputs.transports.Transport;
import org.graylog2.plugin.inputs.annotations.ConfigClass;
import org.graylog2.plugin.inputs.annotations.FactoryClass;

import javax.inject.Inject;

/**
 * This is the plugin. Your class should implement one of the existing plugin
 * interfaces. (i.e. AlarmCallback, MessageInput, MessageOutput)
 */
public class SFlowInput extends MessageInput
{

    @Inject
    public SFlowInput(@Assisted Configuration configuration,
                      UdpTransport.Factory transportFactory,
                      SFlowCodec.Factory codecFactory,
                      Config config,
                      Descriptor descriptor,
                      MetricRegistry metricRegistry,
                      LocalMetricRegistry localRegistry,
                      ServerStatus serverStatus)
    {
        super(metricRegistry,
              configuration,
              transportFactory.create(configuration),
              localRegistry,
              codecFactory.create(configuration),
              config,
              descriptor,
              serverStatus);
    }

    @FactoryClass
    public interface Factory extends MessageInput.Factory<SFlowInput> {
        @Override
        SFlowInput create(Configuration configuration);

        @Override
        Config getConfig();

        @Override
        Descriptor getDescriptor();
    }

    public static class Descriptor extends MessageInput.Descriptor {
        @Inject
        public Descriptor() {
            super("sFlow input", false, "");
        }
    }

    @ConfigClass
    public static class Config extends MessageInput.Config {
        @Inject
        public Config(UdpTransport.Factory transport, SFlowCodec.Factory codec) {
            super(transport.getConfig(), codec.getConfig());
        }
    }
}
