package de.ait;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class CommentsDto {

    private String body;

    @Override
    public String toString() {
        return body ;
    }
}
