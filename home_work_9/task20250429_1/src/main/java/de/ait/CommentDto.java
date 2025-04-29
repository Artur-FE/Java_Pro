package de.ait;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentDto {

    private String body;

    @Override
    public String toString() {
        return body;
    }
}
