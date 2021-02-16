package net.store.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class UserId {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static int nextValue(){
        return (int)(new Date().getTime()/1000);
    }

}
