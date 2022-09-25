package pl.akvelon.akvelontask

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class RequestTestUtil {

    public static def toJson(def request) {
        return new ObjectMapper().writeValueAsString(request)
    }
}
