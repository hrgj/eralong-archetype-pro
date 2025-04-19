#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 区间类型
 */
@Getter
public enum SectionTypeEnum {

    DISTRIBUTION_DISTRIBUTION(10,"分拨-分拨"),

    DISTRIBUTION_OUTLETS(20,"分拨-网点")
    ;

    private final Integer code;

    private final String name;

    SectionTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            SectionTypeEnum::getCode,
                            SectionTypeEnum::getName
                    ));

    public static String getNameByCode(Integer code) {
        return CODE_TO_NAME.getOrDefault(code, "未知区间类型");
    }
}
