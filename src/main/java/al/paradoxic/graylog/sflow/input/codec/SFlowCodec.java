package al.paradoxic.graylog.sflow.input.codec;

import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.graylog2.plugin.Message;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.inputs.annotations.Codec;
import org.graylog2.plugin.inputs.annotations.ConfigClass;
import org.graylog2.plugin.inputs.annotations.FactoryClass;
import org.graylog2.plugin.inputs.codecs.AbstractCodec;
import org.graylog2.plugin.inputs.codecs.MultiMessageCodec;
import org.graylog2.plugin.inputs.transports.NettyTransport;
import org.graylog2.plugin.journal.RawMessage;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Codec(name = "sflow", displayName = "sFlow")
public class SFlowCodec extends AbstractCodec implements MultiMessageCodec
{
  public static final int DEFAULT_SFLOW_PORT = 6343;

@Inject
  private SFlowCodec(@Assisted Configuration configuration)
  {
    super(configuration);
  }

  @Nullable
  @Override
  public Message decode(@Nonnull RawMessage rawMessage)
  {
      throw new UnsupportedOperationException("MultiMessageCodec " + getClass() + " does not support decode()");
  }

  @Nullable
  @Override
  public Collection<Message> decodeMessages(@Nonnull RawMessage rawMessage)
  {
      // TODO Auto-generated method stub
      return null;
  }

  @FactoryClass
  public interface Factory extends AbstractCodec.Factory<SFlowCodec>
  {
    @Override
    SFlowCodec create(Configuration configuration);

    @Override
    Config getConfig();
  }

  @ConfigClass
  public static class Config extends AbstractCodec.Config
  {
    @Override
    public void overrideDefaultValues(@Nonnull ConfigurationRequest cr)
    {
      if (cr.containsField(NettyTransport.CK_PORT))
      {
        cr.getField(NettyTransport.CK_PORT).setDefaultValue(DEFAULT_SFLOW_PORT);
      }
    }
  }
}