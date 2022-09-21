package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("string split")
    public void req1(){
        String str = "1,2";
        String[] strSplit = str.split(",");
        assertThat(strSplit).contains("1", "2");

        str = "1";
        strSplit = str.split(",");

        assertThat(strSplit).containsExactly("1");
    }

    @Test
    @DisplayName("substring 으로 양쪽 자르기")
    public void req2(){
        String str = "(1,2)";
        String parsed = str.substring(1,str.length()-1);

        assertThat(parsed).isEqualTo("1,2");

    }

    @Test
    @DisplayName("array out of bound exception test")
    public void req3(){
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        //assertThatExceptionOfType
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {str.charAt(3);})
                .withMessage("String index out of range: %s", "3")
                .withMessageContaining("index out of")
                .withNoCause();
    }

}
