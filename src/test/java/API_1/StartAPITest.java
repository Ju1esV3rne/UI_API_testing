package API_1;

import API_1.Spec_Data.CommentData;
import API_1.Spec_Data.Spec;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class StartAPITest {
    private final String URL = "https://jsonplaceholder.typicode.com/";
    private final String keyWord = "Presley.Mueller@myrl.com";

    @Test
    @Story("Проверка вхождения email в список")
    void checkElement() {
        Spec.installSpec(Spec.requestSpec(URL), Spec.responseSpec());

        List<CommentData> comments =
                given()
                .when()
                .get("comments")
                .then().log().all()
                .extract().body().jsonPath().getList(".", CommentData.class);

        List <String> list1 = comments.stream().map(CommentData::getEmail).collect(Collectors.toList());

        assertThat(list1).  //has(item())
                contains(keyWord);
    }
}
