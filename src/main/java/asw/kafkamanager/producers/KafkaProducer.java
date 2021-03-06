package asw.kafkamanager.producers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import javax.annotation.ManagedBean;

/**
 * Created by on 26/12/16.
 */
@ManagedBean
public class KafkaProducer {

    private static final Logger logger = Logger.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String data) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info(data + "\" to topic " + topic);
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Error on " + data + "\", stacktrace " + ex.getMessage());
            }
        });
    }

}
