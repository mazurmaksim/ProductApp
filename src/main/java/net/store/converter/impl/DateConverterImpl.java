package net.store.converter.impl;

import net.store.converter.DateConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.Converter;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Converter(autoApply=true)
public class DateConverterImpl implements DateConverter<Date,String> {

    @Override
    public String convertToDatabaseColumn(final Date createdAt) {
        DateTime dateTime = new DateTime(createdAt);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return dateTime.toString(fmt);
    }

    @Override
    public Date convertToEntityAttribute(final String databaseDate) {
    return Date.valueOf(databaseDate);
    }
}
