package net.store.converter;

import javax.persistence.AttributeConverter;
import java.sql.Date;

public interface DateConverter <X,Y> extends AttributeConverter<Date, String> {
    String convertToDatabaseColumn(Date createdAt);
    Date convertToEntityAttribute(String databaseDate);
}
