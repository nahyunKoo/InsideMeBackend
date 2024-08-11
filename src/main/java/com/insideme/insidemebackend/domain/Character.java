package com.insideme.insidemebackend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.LinkedList;
import java.util.List;


@Data
@Document(collection = "character")
public class Character {

    public enum CharacterState {FIRST, SECOND, THIRD, FOURTH}

    @Id
    private String id; //mongodb에서 자동으로 생성하는 id

    @Field("user_id")
    private String userId;
    private CharacterState state;
    private List<String> emotions;

    public Character() {
        this.emotions = new LinkedList<>();
    }

    public Character(String id, String userId, CharacterState state, List<String> emotions) {
        this.id = id;
        this.userId = userId;
        this.state = state;
        this.emotions = (emotions != null) ? emotions : new LinkedList<>();
    }
}
