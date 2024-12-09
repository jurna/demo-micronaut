package com.example.customer;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import io.micronaut.core.annotation.Introspected;

import static org.bson.BsonType.OBJECT_ID;

@Introspected
public record CustomerView(@BsonId @BsonRepresentation(OBJECT_ID) String id, String firstName, String lastName) {
}
