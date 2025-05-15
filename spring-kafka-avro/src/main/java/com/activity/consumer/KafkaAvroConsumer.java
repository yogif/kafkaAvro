package com.activity.consumer;

import com.activity.dto.Employee;
import com.activity.service.FirstNameService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class KafkaAvroConsumer {

    private FirstNameService firstNameService;

    public KafkaAvroConsumer(FirstNameService firstNameService) {
        this.firstNameService = Objects.requireNonNull(firstNameService);
    }

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();
        log.info("Avro message received for key : " + key + " value : " + employee.toString());
        log.info("Avro message received first name : "+ employee.getFirstName());

        if(employee.getFirstName().toString().equalsIgnoreCase("*")){
            firstNameService.callService("*");
        }else {
            if (employee.getFirstName().toString().equalsIgnoreCase("Basant")) {
                firstNameService.callService("Basant");
            } else if (employee.getFirstName().toString().equalsIgnoreCase("James")) {
                firstNameService.callService("James");
            } else if (employee.getFirstName().toString().equalsIgnoreCase("Kent")) {
                firstNameService.callService("Kent");
            }
        }

    }
}
