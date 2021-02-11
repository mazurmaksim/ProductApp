package net.store.converter;

import javax.persistence.AttributeConverter;

public interface DateConverter <Date,String> extends AttributeConverter<Date, String> {
    String convertToDatabaseColumn(Date createdAt);
    Date convertToEntityAttribute(String databaseDate);
}
