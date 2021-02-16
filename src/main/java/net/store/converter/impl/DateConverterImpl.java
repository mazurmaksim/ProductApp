package net.store.converter.impl;

import net.store.converter.DateConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.Converter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Converter(autoApply=true)
public class DateConverterImpl implements DateConverter<Date,String> {

    @Override
    public String convertToDatabaseColumn(final Date createdAt) {
        if(createdAt!=null) {
            DateTime dateTime = new DateTime(createdAt);
            DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd hh:mm:ss");
            return dateTime.toString(fmt);
        }
        return null;
    }

    @Override
    public Date convertToEntityAttribute(final String databaseDate) {
        SimpleDateFormat resultFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        try {
            java.util.Date parse = resultFormat.parse(databaseDate);
            return new java.sql.Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
