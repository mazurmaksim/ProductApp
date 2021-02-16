package net.store.orders;

import net.store.converter.impl.DateConverterImpl;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrdersConvertDateTest {

    @Test
    void convertStringToDate(){
        DateConverterImpl currentDate = new DateConverterImpl();
        String dateString = "2021-02-16 02:20:46";

        currentDate.convertToEntityAttribute(dateString);

        assertNotNull(currentDate);

    }

}
