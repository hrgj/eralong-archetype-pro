#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 站点等级
 */
@Getter
public enum StationLevelEnum {

    HUB(10,"枢纽"),

    FIRST_LEVEL_TRANSSHIPMENT(20,"一级转运"),

    SECOND_LEVEL_TRANSSHIPMENT(30,"二级转运"),

    FIRST_LEVEL_DISTRIBUTION(40,"一级集散"),

    SECOND_LEVEL_DISTRIBUTION(50,"二级集散"),

    THREE_LEVEL_DISTRIBUTION(60,"三级集散")

    ;

    private final Integer code;
    private final String name;

    StationLevelEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            StationLevelEnum::getCode,
                            StationLevelEnum::getName
                    ));

    public static String getNameByCode(Integer code) {
        return CODE_TO_NAME.getOrDefault(code, "未知站点等级");
    }
}
